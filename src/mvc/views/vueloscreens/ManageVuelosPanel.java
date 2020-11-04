package mvc.views.vueloscreens;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ManageVuelosPanel extends JPanel {
	
	private JTable table;
	private JTextField idVuelo_tf;
	private JButton modicar_bt;
	private JButton delete_bt;

	/**
	 * Create the panel.
	 */
	public ManageVuelosPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		startComponents();
	}

	private void startComponents() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 8, 841, 501);
		this.add(scrollPane);
		
		
		table = new JTable();
		table.setModel(new VuelosTableModel());
		scrollPane.setViewportView(table);
		
		idVuelo_tf = new JTextField();
		idVuelo_tf.setBounds(60, 561, 130, 26);
		this.add(idVuelo_tf);
		idVuelo_tf.setColumns(10);
		
		JLabel idVuelo_label = new JLabel("idVuelo");
		idVuelo_label.setForeground(Color.ORANGE);
		idVuelo_label.setBounds(62, 542, 91, 16);
		this.add(idVuelo_label);
		
		modicar_bt = new JButton("Modify");
		modicar_bt.setBounds(249, 561, 117, 29);
		modicar_bt.setActionCommand("Modify_bt");
		this.add(modicar_bt);
		
		delete_bt = new JButton("Delete");
		delete_bt.setBounds(399, 561, 117, 29);
		delete_bt.setActionCommand("Delete_bt");
		this.add(delete_bt);		
	}


	public void setListener(ActionListener listener) {
		modicar_bt.addActionListener(listener);
		delete_bt.addActionListener(listener);
	}
	
	public JTable getTable() {
		return table;
	}

	public JTextField getIdVuelo_tf() {
		return idVuelo_tf;
	}
	
	public void printPaneError(String message) {
		JOptionPane.showMessageDialog(null, message , "Error",JOptionPane.ERROR_MESSAGE);
	}

	public void printPaneWarning(String message) {
		JOptionPane.showMessageDialog(null, message , "Warning",JOptionPane.WARNING_MESSAGE);		
	}
	
	
}
