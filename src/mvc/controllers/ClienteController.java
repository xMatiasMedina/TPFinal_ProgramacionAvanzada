package mvc.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List.*;

import javax.swing.JComponent;
import javax.swing.JTextField;

import mvc.modelo.dao.daoimplementations.sqlserver.PaisDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.sqlserver.ProvinciasDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.stream.ClienteDAOImpObjectStream;
import mvc.modelo.dao.daoimplementations.stream.PaisDAOImpFileStream;
import mvc.modelo.dao.daoimplementations.stream.ProvinciasDAOImpFileStream;
import mvc.modelo.dao.factories.ClienteDAOFactory;
import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.idaos.ClienteDAO;
import mvc.modelo.dominio.Cliente;
import mvc.modelo.dominio.Direccion;
import mvc.modelo.dominio.Pasaporte;
import mvc.modelo.dominio.Provincia;
import mvc.modelo.dominio.Telefono;
import mvc.views.clientscreens.ClientFrame;
import mvc.views.clientscreens.ClientRegisterPanel;

public class ClienteController implements ActionListener{
	
	private ClientFrame view;
	private ClienteDAO dao;
	private int idclient;
	
	public ClienteController(int id) {
		this.idclient = id;
		view = new ClientFrame(this,
				PaisDAOImpFileStream.getInstance().getAllasString().toArray(new String[5]),
				ProvinciasDAOImpFileStream.getInstance().getAllasString().toArray(new String[23]));
		view.setVisible(true);
		dao = ClienteDAOFactory.getClienteDAOImp(ImpType.STREAM);
		validateClient();
	}

	public void validateClient() {
		if(dao.obtenerCliente(this.idclient) == null) {
			view.printPaneWarning("You haven't registered yet");
			view.switchPanel(0);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "RDone_bt":
				if(dao.obtenerCliente(this.idclient) == null) 
					dao.registrarCliente(getClient());
				else 
					dao.modificarCliente(getClient());
				view.switchPanel(1);
				break;
			case "Modify_bt":
				view.switchPanel(0);
				break;
			case "Delete_bt":
				dao.eliminarCliente(dao.obtenerCliente(idclient));
				UsuarioController scontroller = new UsuarioController();
				scontroller.deleteUser(idclient);
				view.setVisible(false);
				scontroller.startLogin();
				break;
		}
	}
	
	//TODO Telefono no tenia seters, si lo quieren cambiar o 
	//mejorar en cuestiones de diseno tengan en cuenta que hay que cambiar todo esto.
	//Este metodo fue eterno /\ En stream como se puede ver no tienen id los objetos
	private Cliente getClient() {
		ClientRegisterPanel register = view.getRegisterPanel();
		Pasaporte pasaporte = new Pasaporte();
		pasaporte.setNumero(register.getNumeroPasaporte_tf().getText());
		pasaporte.setAutoridadDeEmision(register.getAutoridad_tf().getText());
		String pais1 = (String) register.getPais_cbox().getSelectedItem();
		pasaporte.setPaisEmision
		("Otro".equals(pais1)?
				PaisDAOImpFileStream.getInstance().getPais(register.getOtro_tf().getText()):
			PaisDAOImpFileStream.getInstance().getPais(pais1));//Validacion otro 1
		pasaporte.setFechaDeEmision(register.getEmision_tf().getDate());
		pasaporte.setFechaDeVencimiento(register.getVencimiento_tf().getDate());
		Direccion direccion = new Direccion();
		direccion.setCalle(register.getCalle_tf().getText());
		direccion.setAltura(register.getAltura_tf().getText());
		direccion.setCiudad(register.getCiudad_tf().getText());
		direccion.setCodigoPostal(register.getCodigo_tf().getText());
		String pais2 = (String) register.getPais_cbox().getSelectedItem();
		direccion.setPais(pais2.equals("Otro")?
				PaisDAOImpFileStream.getInstance().getPais(register.getOtro_tf2().getText()):
					PaisDAOImpFileStream.getInstance().getPais(pais2));//Validacion de otro 2
		if(!"Otro".equals(pais2))
			direccion.setProvincia
			(ProvinciasDAOImpFileStream.getInstance().getProvincia
					((String) register.getProvincia_cbox().getSelectedItem()));
		Telefono telefono = new Telefono(
				register.getPersonal_tf().getText(),
				register.getCelular_tf().getText(),
				register.getLaboral_tf().getText()
				);
		Cliente cliente = new Cliente();
		cliente.setIdCliente(String.valueOf(idclient));//No pasen el id a la db, ahi deberia mantenerse sola
		cliente.setNombre(register.getNombre_tf().getText());
		cliente.setApellido(register.getApellido_tf().getText());
		cliente.setDni(register.getDni_tf().getText());
		cliente.setEmail(register.getDni_tf().getText());
		cliente.setCuit(register.getCuit_tf().getText());
		cliente.setPasaporte(pasaporte);
		cliente.setFechaDeNacimiento(register.getNacimiento_tf().getDate());
		cliente.setTelefono(telefono);
		cliente.setDireccion(direccion);
		return cliente;
	}
}
