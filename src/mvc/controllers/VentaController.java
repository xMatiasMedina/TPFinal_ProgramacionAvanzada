package mvc.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import mvc.modelo.bll.ClienteBLL;
import mvc.modelo.dao.daoimplementations.sqlserver.VueloDAOImpSQLServer;
import mvc.modelo.dao.factories.ClienteDAOFactory;
import mvc.modelo.dao.factories.ImpType;
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
		dao = null;//TODO agregar cuando sea implementado
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Comprar_bt":
			Cliente cliente = ClienteDAOFactory.getClienteDAOImp(ImpType.SQLSERVER).obtenerCliente(Integer.parseInt(idcliente));
			ComprarVuelosPanel comprarview = (ComprarVuelosPanel) comprarVuelosPanel;
			if(new ClienteBLL().mayorde18(cliente)) {
				Vuelo vuelo = new VueloDAOImpSQLServer().obtenerVuelo(comprarview.getIdVuelo_tf().getText());
				FormaDePago formadepago = FormaDePago.get((String) comprarview.getFormadePago_cbox().getSelectedItem());
				if(FormaDePago.TARJETA_CREDITO.equals(formadepago)) {
					formadepago.setDetalle((String) comprarview.getCuotas_cbox().getSelectedItem());
					dao.registrarVenta(new Venta(vuelo,vuelo.getLineaAerea(),cliente,new Date(),formadepago));
				}else {
					dao.registrarVenta(new Venta(vuelo,vuelo.getLineaAerea(),cliente,new Date(),formadepago));
				}
			}else 
				comprarview.printWarning("Debes ser mayor de 18 para realizar compras");
			break;
		case "Delete_bt":
			AdquiridosPanel view = (AdquiridosPanel) adquiridosPanel;
			Venta ventaEliminada = dao.obtenerVenta(view.getIdVuelo_tf().getText());
			if(ventaEliminada != null) {
				dao.eliminarVenta(ventaEliminada);
				((VentasTableModel) view.getTable().getModel()).remove(ventaEliminada.getIdVenta());
			}
			break;
	}	
	}
}
