package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import exceptions.WrongInputException;
import mvc.modelo.bll.ClienteBLL;
import mvc.modelo.bll.PasaporteBLL;
import mvc.modelo.bll.VueloBLL;
import mvc.modelo.dao.daoimplementations.sqlserver.VueloDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.VentaDAOImpObjectStream;
import mvc.modelo.dao.factories.ClienteDAOFactory;
import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.factories.VentaDAOFactory;
import mvc.modelo.dao.factories.VueloDAOFactory;
import mvc.modelo.dao.idaos.ClienteDAO;
import mvc.modelo.dao.idaos.VentaDAO;
import mvc.modelo.dao.idaos.VueloDAO;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.FormaDePago;
import mvc.modelo.dominio.Venta;
import mvc.modelo.dominio.Vuelo;
import mvc.views.clientscreens.AdquiridosPanel;
import mvc.views.clientscreens.ComprarVuelosPanel;
import mvc.views.ventascreens.VentasTableModel;

public class VentaController implements ActionListener {
	
	private JPanel comprarVuelosPanel, adquiridosPanel;
	private String idcliente;
	private VentaDAO dao;
	
	public VentaController(String clienteid, JPanel comprarVuelosPanel, JPanel adquiridosPanel) {
		dao = VentaDAOFactory.getVentaDAO(ImpType.STREAM);//TODO agregar cuando sea implementado
		this.adquiridosPanel = adquiridosPanel;
		this.comprarVuelosPanel = comprarVuelosPanel;
		ComprarVuelosPanel comprarview = (ComprarVuelosPanel) comprarVuelosPanel;
		comprarview.setListener(this);
		comprarview.setFormasDePago(FormaDePago.values());
		AdquiridosPanel panel = (AdquiridosPanel) adquiridosPanel;
		panel.setListener(this);
		((VentasTableModel) panel.getTable().getModel()).addVenta
		(dao.obtenerVentas().stream().filter
				(a -> a.getCliente().getIdCliente().equals(clienteid)).collect(Collectors.toList()));
		this.idcliente = idcliente;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Comprar_bt":
			ComprarVuelosPanel comprarview = (ComprarVuelosPanel) comprarVuelosPanel;
			try {
				Cliente cliente = ClienteDAOFactory.getClienteDAOImp(ImpType.STREAM).obtenerCliente(idcliente);
				Vuelo vuelo = VueloDAOFactory.getVueloDAO(ImpType.STREAM).obtenerVuelo(comprarview.getIdVuelo_tf().getText());
				if(new PasaporteBLL().validar(cliente.getPasaporte(), vuelo)) {
					if(new VueloBLL().disponible(vuelo, VentaDAOFactory.getVentaDAO(ImpType.STREAM).obtenerVentas())) {//TODO revisar cuando haya data base
						if(new ClienteBLL().mayorde18(cliente)) {
							vuelo.setVendidos(vuelo.getVendidos()+1);
							VueloDAOFactory.getVueloDAO(ImpType.STREAM).modificarVuelo(vuelo);
							FormaDePago formadepago = FormaDePago.get((String) comprarview.getFormadePago_cbox().getSelectedItem());
							if(FormaDePago.TARJETA_CREDITO.equals(formadepago)) {
								formadepago.setDetalle((String) comprarview.getCuotas_cbox().getSelectedItem());
								dao.registrarVenta(new Venta(vuelo,vuelo.getLineaAerea(),cliente,new Date(),formadepago));
							}else {
								dao.registrarVenta(new Venta(vuelo,vuelo.getLineaAerea(),cliente,new Date(),formadepago));
							}
						}else 
							comprarview.printWarning("Debes ser mayor de 18 para realizar compras");
					}else
						comprarview.printWarning("No hay espacio disponible en este vuelo");
				}else
					comprarview.printWarning("Pasaporte no valido");
			}catch(NumberFormatException | WrongInputException e1) {
				e1.printStackTrace();
				comprarview.printWarning("Input no valido");
			}
			break;
		case "Delete_bt":
			AdquiridosPanel view = (AdquiridosPanel) adquiridosPanel;
			try {
				Venta ventaEliminada = dao.obtenerVenta(view.getIdVenta_tf().getText());
				if(ventaEliminada != null) {
					dao.eliminarVenta(ventaEliminada);
					((VentasTableModel) view.getTable().getModel()).remove(ventaEliminada.getIdVenta());
				}
			}catch(NumberFormatException | WrongInputException e1) {
				e1.printStackTrace();
				view.printWarning("Input no valido");
			}
			break;
		}	
	}
}
