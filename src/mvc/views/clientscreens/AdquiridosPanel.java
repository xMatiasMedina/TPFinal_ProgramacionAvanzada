package mvc.views.clientscreens;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import mvc.views.ventascreens.VentasTableModel;
import mvc.views.vueloscreens.VuelosTableModel;

public class AdquiridosPanel extends JPanel {

	private JTable table;
	private JTextField idVuelo_tf;
	private JButton delete_bt;

	
	public AdquiridosPanel() {
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		startComponents();
	}
	
	private void startComponents() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 848, 493);
		this.add(scrollPane);
		
		VentasTableModel model = new VentasTableModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		idVuelo_tf = new JTextField();
		idVuelo_tf.setBounds(36, 556, 130, 26);
		this.add(idVuelo_tf);
		idVuelo_tf.setColumns(10);
		
		JLabel idVuelo_label = new JLabel("idVuelo");
		idVuelo_label.setForeground(Color.ORANGE);
		idVuelo_label.setBounds(36, 539, 61, 16);
		this.add(idVuelo_label);
		
		delete_bt = new JButton("Delete");
		delete_bt.setBounds(215, 556, 117, 29);
		delete_bt.setActionCommand("Delete_bt");
		this.add(delete_bt);
	}
	
	public void setListener(ActionListener listener) {
		delete_bt.addActionListener(listener);
	}

	public JTable getTable() {
		return table;
	}

	public JTextField getIdVuelo_tf() {
		return idVuelo_tf;
	}

	public JButton getDelete_bt() {
		return delete_bt;
	}
	
	public void printWarning(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}

}
