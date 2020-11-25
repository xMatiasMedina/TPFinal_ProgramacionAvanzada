package mvc.controllers;

import java.awt.event.ActionEvent;

import mvc.views.vueloscreens.AddVuelosPanel;
import mvc.views.vueloscreens.ManageVuelosPanel;
import mvc.views.vueloscreens.VuelosTableModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.stream.Collectors;

import javax.swing.JTable;

import com.sun.istack.internal.Nullable;

import mvc.modelo.bll.VueloBLL;
import mvc.modelo.dao.daoimplementations.sqlserver.AeropuertoDAOImplSQLServer;
import mvc.modelo.dao.daoimplementations.sqlserver.LineaAereaDAOImpSQLServer;
import mvc.modelo.dao.daoimplementations.sqlserver.VueloDAOImpSQLServer;
import mvc.modelo.dao.factories.AeropuertoDAOFactory;
import mvc.modelo.dao.factories.ImpType;
import mvc.modelo.dao.factories.LineaAereaDAOFactory;
import mvc.modelo.dao.factories.VueloDAOFactory;
import mvc.modelo.dao.idaos.VueloDAO;
import mvc.modelo.dominio.Vuelo;

public class VueloController implements ActionListener{
	
	private VueloDAO dao;
	private AddVuelosPanel addVuelosPanel;
	private ManageVuelosPanel manageVuelosPanel;
	private JTable[] tables;
	private int idLineaAerea;

	public VueloController(JTable... tables) {
		dao = VueloDAOFactory.getVueloDAO(ImpType.STREAM);
		this.tables = tables;
		loadTables(tables);
	}
	
	public VueloController(int idLineaAerea, AddVuelosPanel addVuelosPanel, ManageVuelosPanel manageVuelosPanel) {
		this.idLineaAerea = idLineaAerea;
		this.addVuelosPanel = addVuelosPanel;
		addVuelosPanel.setListener(this);
		addVuelosPanel.loadAeropuertos(AeropuertoDAOFactory.getAeropuertoDAO(ImpType.STREAM).getAll());
		manageVuelosPanel.setListener(this);
		this.manageVuelosPanel = manageVuelosPanel;
		loadTablesLA(manageVuelosPanel.getTable());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		switch(e.getActionCommand()) {
		case "RDone_bt":
			if(manageVuelosPanel.getIdVuelo_tf().getText().isEmpty() && dao.obtenerVuelo(manageVuelosPanel.getIdVuelo_tf().getText()) == null) 
				dao.registrarVuelo(loadVuelo());
			else {
				Vuelo vuelo = loadVuelo();
				vuelo.setIdVuelo(manageVuelosPanel.getIdVuelo_tf().getText());
				dao.modificarVuelo(vuelo);
			}
			break;
		case "Modify_bt":
			manageVuelosPanel.printPaneWarning("Vaya a agregar vuelos para continuar");
			break;
		case "Delete_bt":
			dao.eliminarVuelo(dao.obtenerVuelo(manageVuelosPanel.getIdVuelo_tf().getText()));
			((VuelosTableModel)tables[0].getModel()).remove(manageVuelosPanel.getIdVuelo_tf().getText());
			break;
	}
		}catch(NumberFormatException | NullPointerException e1) {
			e1.getStackTrace();
			manageVuelosPanel.printPaneError("Algo salio mal");
		}
	}
	
	//TODO quedo rep el numero de vuelo
	private Vuelo loadVuelo() {
		String[] time1 = addVuelosPanel.getTimeSalida_tf().getText().split(":");
		String[] time2 = addVuelosPanel.getTimeLlegada_tf().getText().split(":");		
		Date salida = addVuelosPanel.getDateSalida().getDate();
		salida.setHours(Integer.valueOf(time1[0]));
		salida.setMinutes(Integer.valueOf(time1[1]));
		Date llegada = addVuelosPanel.getDateLlegada().getDate();
		llegada.setHours(Integer.valueOf(time2[0]));
		llegada.setMinutes(Integer.valueOf(time2[1]));
		Vuelo vuelo = new Vuelo(
				"esta rep",
				LineaAereaDAOFactory.getLineaAereaDAO(ImpType.STREAM).obtenerLAerea(idLineaAerea),
				Integer.valueOf(addVuelosPanel.getAsientos_tf().getText()),
				AeropuertoDAOFactory.getAeropuertoDAO(ImpType.STREAM).obtenerAeropuerto((String) addVuelosPanel.getArSalida_cbox().getSelectedItem()),
				AeropuertoDAOFactory.getAeropuertoDAO(ImpType.STREAM).obtenerAeropuerto((String) addVuelosPanel.getArLlegada_cbox().getSelectedItem()),
				salida,
				llegada,
				null
				);
		new VueloBLL().cargarTiempodeVuelo(vuelo);
		return vuelo;
	}
	
	private void loadTables(JTable... tables) {
		for(int i = 0; i < tables.length; i++)
			((VuelosTableModel) tables[i].getModel()).addVuelo(dao.getAll()); 
	}
	
	private void loadTablesLA(JTable... tables) {
		for(int i = 0; i < tables.length; i++)
			((VuelosTableModel) tables[i].getModel()).addVuelo(dao.getAll().stream().filter(a -> a.getLineaAerea().getId() == idLineaAerea).collect(Collectors.toList())); 
	}
}
