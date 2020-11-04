package mvc.views.adminscreens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdminPanel extends JPanel {

	private JTextField aeropuerto_tf;
	private JTextField idpais_tf;
	
	public AdminPanel(ActionListener listener1, ActionListener listener2) {
		this.setBackground(Color.DARK_GRAY);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		startComponents(listener1, listener2);
	}
	
	private void startComponents(ActionListener listener1, ActionListener listener2) {
		JLabel adminManu_label = new JLabel("Admin Menu");
		adminManu_label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		adminManu_label.setForeground(Color.ORANGE);
		adminManu_label.setBounds(171, 33, 114, 16);
		this.add(adminManu_label);
		
		JLabel aeropuerto_label = new JLabel("Ident. Aeropuerto");
		aeropuerto_label.setForeground(Color.ORANGE);
		aeropuerto_label.setBounds(29, 86, 113, 16);
		this.add(aeropuerto_label);
		
		aeropuerto_tf = new JTextField();
		aeropuerto_tf.setBounds(29, 105, 130, 26);
		this.add(aeropuerto_tf);
		aeropuerto_tf.setColumns(10);
		
		JButton arDelete_bt = new JButton("Delete");
		arDelete_bt.setBounds(196, 105, 117, 29);
		arDelete_bt.setActionCommand("arDelete_bt");
		arDelete_bt.addActionListener(listener2);
		this.add(arDelete_bt);
		
		JButton arAgregar_bt = new JButton("Agregar");
		arAgregar_bt.setBounds(315, 105, 117, 29);
		arAgregar_bt.setActionCommand("arAgregar_bt");
		arAgregar_bt.addActionListener(listener2);
		this.add(arAgregar_bt);
		
		JLabel paises_label = new JLabel("ID Pais");
		paises_label.setForeground(Color.ORANGE);
		paises_label.setBounds(29, 188, 61, 16);
		this.add(paises_label);
		
		idpais_tf = new JTextField();
		idpais_tf.setBounds(29, 216, 130, 26);
		this.add(idpais_tf);
		idpais_tf.setColumns(10);
		
		JButton pDelete_bt = new JButton("Delete");
		pDelete_bt.setBounds(196, 216, 117, 29);
		pDelete_bt.setActionCommand("pDelete_bt");
		pDelete_bt.addActionListener(listener1);
		this.add(pDelete_bt);
		
		JButton pAgregar_bt = new JButton("Agregar");
		pAgregar_bt.setBounds(315, 216, 117, 29);
		pAgregar_bt.setActionCommand("pAgregar_bt");
		pAgregar_bt.addActionListener(listener1);
		this.add(pAgregar_bt);
	}

	public JTextField getAeropuerto_tf() {
		return aeropuerto_tf;
	}

	public JTextField getIdpais_tf() {
		return idpais_tf;
	}
	
	

}
