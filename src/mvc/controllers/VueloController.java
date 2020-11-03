package mvc.controllers;

import java.awt.event.ActionEvent;
import mvc.views.vueloscreens.VuelosTableModel;
import java.awt.event.ActionListener;
import javax.swing.JTable;

import com.sun.istack.internal.Nullable;

import mvc.modelo.dao.daoimplementations.sqlserver.VueloDAOImpSQLServer;
import mvc.modelo.dao.idaos.VueloDAO;

public class VueloController implements ActionListener{
	
	private VueloDAO dao;
	private JTable[] tables;

	public VueloController(JTable... tables) {
		dao = new VueloDAOImpSQLServer();
		this.tables = tables;
		for(int i = 0; i < tables.length; i++)
			((VuelosTableModel) tables[i].getModel()).addVuelo(dao.getAll()); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
