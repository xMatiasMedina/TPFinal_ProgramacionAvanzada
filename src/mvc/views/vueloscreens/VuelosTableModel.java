package mvc.views.vueloscreens;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import mvc.modelo.dominio.Vuelo;

public class VuelosTableModel extends AbstractTableModel {
	
	private List<Vuelo> vuelos;
	private String[] columns;
	
	
	public VuelosTableModel() {
		vuelos = new ArrayList<>();
		columns = new String[] {"idVuelo","Asientos","Salida"
				,"Llegada","Fecha Salida", "Fecha Llegada"
				, "Tiempo","Vendidos"};
		
	}
	
	public void cleanTable() {
		vuelos = new ArrayList<>();
	}
	
	public void remove(String id) {
		for (int i = 0; i < vuelos.size(); i++) 
			if(vuelos.get(i).getIdVuelo().equals(id))
				vuelos.remove(i);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return vuelos.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return this.columns[column];
	}
	
	public void addVuelo(Vuelo vuelo) {
		vuelos.add(vuelo);
	}
	
	public void addVuelo(List<Vuelo> vuelos) {
		if(vuelos != null)
			this.vuelos.addAll(vuelos);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(vuelos.size() <= rowIndex)
			return null;
			
		switch(columnIndex) {
			case 0: return vuelos.get(rowIndex).getIdVuelo();
			case 1: return vuelos.get(rowIndex).getCantidadDeAsientos();
			case 2: return vuelos.get(rowIndex).getAeropuertoDeSalida();
			case 3: return vuelos.get(rowIndex).getAeropuertoDeLlegada();
			case 4: return vuelos.get(rowIndex).getDateSalida();
			case 5: return vuelos.get(rowIndex).getDateLlegada();
			case 6: return vuelos.get(rowIndex).getTiempo();
			case 7: return vuelos.get(rowIndex).getVendidos();
			default: return null;
		}
	}
	
	public Vuelo getVuelo(String id) {
		for (Vuelo vuelo : vuelos) 
			if(vuelo.getIdVuelo().equals(id))
				return vuelo;
		return null;
	}
}
