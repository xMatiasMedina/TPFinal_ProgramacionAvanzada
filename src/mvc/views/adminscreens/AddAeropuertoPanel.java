package mvc.views.adminscreens;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import mvc.modelo.dominio.Pais;
import mvc.modelo.dominio.Provincia;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddAeropuertoPanel extends JPanel {
	private JTextField ident_tf;
	private JTextField ciudad_tf;
	private JComboBox pais_cbox;
	private JComboBox prov_cbox;
	/**
	 * Create the panel.
	 */
	public AddAeropuertoPanel(ActionListener listener) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel menu_label = new JLabel("Aeropuerto Menu");
		menu_label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		menu_label.setForeground(Color.ORANGE);
		menu_label.setBounds(155, 36, 143, 29);
		add(menu_label);
		
		JLabel identificacion_label = new JLabel("Identificacion (max: 3 chr)");
		identificacion_label.setForeground(Color.ORANGE);
		identificacion_label.setBounds(144, 105, 165, 16);
		add(identificacion_label);
		
		ident_tf = new JTextField();
		ident_tf.setBounds(138, 133, 180, 26);
		add(ident_tf);
		ident_tf.setColumns(10);
		
		JLabel ciudad_label = new JLabel("Ciudad");
		ciudad_label.setForeground(Color.ORANGE);
		ciudad_label.setBounds(144, 182, 77, 16);
		add(ciudad_label);
		
		ciudad_tf = new JTextField();
		ciudad_tf.setBounds(144, 210, 174, 26);
		add(ciudad_tf);
		ciudad_tf.setColumns(10);
		
		JLabel provincias_label = new JLabel("Provincia");
		provincias_label.setForeground(Color.ORANGE);
		provincias_label.setBounds(144, 267, 61, 16);
		add(provincias_label);
		
		prov_cbox = new JComboBox();
		prov_cbox.setBounds(144, 295, 174, 27);
		add(prov_cbox);
		
		JLabel pais_label = new JLabel("Pais");
		pais_label.setForeground(Color.ORANGE);
		pais_label.setBounds(144, 344, 61, 16);
		add(pais_label);
		
		pais_cbox = new JComboBox();
		pais_cbox.setBounds(144, 372, 174, 27);
		add(pais_cbox);
		
		JButton done_bt = new JButton("Done");
		done_bt.setBounds(166, 411, 117, 29);
		done_bt.addActionListener(listener);
		done_bt.setActionCommand("Done_bt");
		add(done_bt);
	}
	
	public void loadCBoxes(List<String> paises, List<String> provincias) {
		for (String provincia : provincias) 
			prov_cbox.addItem(provincia);
		for (String pais : paises) 
			pais_cbox.addItem(pais);
		
	}
	
	public JTextField getIdent_tf() {
		return ident_tf;
	}
	public JTextField getCiudad_tf() {
		return ciudad_tf;
	}
	public JComboBox getPais_cbox() {
		return pais_cbox;
	}
	public JComboBox getProv_cbox() {
		return prov_cbox;
	}
	
	
}
