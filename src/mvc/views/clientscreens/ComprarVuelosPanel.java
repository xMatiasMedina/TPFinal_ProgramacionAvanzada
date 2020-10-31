package mvc.views.clientscreens;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import mvc.modelo.dominio.FormaDePago;
import mvc.views.vueloscreens.VuelosTableModel;

public class ComprarVuelosPanel extends JPanel {

	private JTextField idVuelo_tf;
	private JTable table;
	private JComboBox formadePago_cbox;
	private JComboBox cuotas_cbox;
	private JButton comprar_bt;
	/**
	 * Create the panel.
	 */
	public ComprarVuelosPanel() {
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		startComponents();
	}
	
	private void startComponents() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 202, 848, 404);
		this.add(scrollPane);
		
		VuelosTableModel model = new VuelosTableModel();
		table = new JTable(model);
		//model.addVuelo(new Vuelo("200 horas")); Prueba victoriosa
		
		scrollPane.setViewportView(table);
		
		idVuelo_tf = new JTextField();
		idVuelo_tf.setBounds(35, 127, 130, 26);
		this.add(idVuelo_tf);
		idVuelo_tf.setColumns(10);
		
		JLabel comprarVuelo_label = new JLabel("Comprar Vuelo");
		comprarVuelo_label.setForeground(Color.ORANGE);
		comprarVuelo_label.setBounds(384, 27, 93, 16);
		this.add(comprarVuelo_label);
		
		JLabel idVuelo_label = new JLabel("idVuelo");
		idVuelo_label.setForeground(Color.ORANGE);
		idVuelo_label.setBounds(35, 108, 61, 16);
		this.add(idVuelo_label);
		
		formadePago_cbox = new JComboBox();
		formadePago_cbox.setBounds(236, 128, 130, 27);
		this.add(formadePago_cbox);
		
		JLabel formadePago_label = new JLabel("Forma de Pago");
		formadePago_label.setForeground(Color.ORANGE);
		formadePago_label.setBounds(236, 108, 107, 16);
		this.add(formadePago_label);
		
		cuotas_cbox = new JComboBox(new String[]{"3-6","12-24(+10%)"});
		cuotas_cbox.setBounds(425, 128, 130, 27);
		cuotas_cbox.setVisible(false);
		this.add(cuotas_cbox);
		
		comprar_bt = new JButton("Comprar");
		comprar_bt.setBounds(626, 127, 117, 29);
		comprar_bt.setActionCommand("Comprar_bt");
		this.add(comprar_bt);
	}
	
	public void setListener(ActionListener listener) {
		comprar_bt.addActionListener(listener);
	}
	
	public void setFormasDePago(FormaDePago[] formaDePagos) {
		for (FormaDePago formaDePago : formaDePagos) 
			formadePago_cbox.addItem(formaDePago.getValue());
		formadePago_cbox.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("Tarjeta de Credito"))
					cuotas_cbox.setVisible(true);
				else
					cuotas_cbox.setVisible(false);
			}
		});
		
	}

	public JTextField getIdVuelo_tf() {
		return idVuelo_tf;
	}

	public JTable getTable() {
		return table;
	}

	public JComboBox getFormadePago_cbox() {
		return formadePago_cbox;
	}

	public JComboBox getCuotas_cbox() {
		return cuotas_cbox;
	}

	public JButton getComprar_bt() {
		return comprar_bt;
	}

	public void printWarning(String message) {
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}
}
