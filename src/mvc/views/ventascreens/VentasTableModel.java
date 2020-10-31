package mvc.views.ventascreens;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import mvc.modelo.dominio.Venta;
import mvc.modelo.dominio.Vuelo;

public class VentasTableModel  extends AbstractTableModel {

	private List<Venta> ventas;
	private String[] columns;
	
	public VentasTableModel() {
		ventas = new ArrayList<>();
		columns = new String[] {"idVenta","Cliente","Vuelo"
				,"Aerolinea","Fecha Venta", "Forma de Pago"};
	}
	
	public void cleanTable() {
		ventas = new ArrayList<>();
	}
	
	public void remove(String id) {
		for (int i = 0; i < ventas.size(); i++) 
			if(ventas.get(i).getIdVenta().equals(id))
				ventas.remove(i);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ventas.size();
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
	
	public void addVenta(Venta venta) {
		ventas.add(venta);
	}
	
	public void addVenta(List<Venta> ventas) {
		this.ventas.addAll(ventas);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(ventas.size() <= rowIndex)
			return null;
			
		switch(columnIndex) {
			case 0: return ventas.get(rowIndex).getIdVenta();
			case 1: return ventas.get(rowIndex).getCliente().getDni();
			case 2: return ventas.get(rowIndex).getVuelo().getIdVuelo();
			case 3: return ventas.get(rowIndex).getAerolinea().getAerolinea();
			case 4: return ventas.get(rowIndex).getDateVenta().toString();
			case 5: return ventas.get(rowIndex).getFormaDePago().toString();
			default: return null;
		}
	}
	
	public Venta getVenta(String id) {
		for (Venta venta : ventas) 
			if(venta.getIdVenta().equals(id))
				return venta;
		return null;
	}

}
