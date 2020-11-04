package mvc.views.proveedorscreens;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import mvc.modelo.dominio.Alianza;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class RegistrarAerolineaPanel extends JPanel {
	private JTextField arNombre_tf;
	private JComboBox alianza_cbox;

	/**
	 * Create the panel.
	 */
	public RegistrarAerolineaPanel(ActionListener listener, Alianza[] alianzas) {
		setBackground(Color.DARK_GRAY);
		setForeground(Color.BLACK);
		setBounds(100, 100, 916, 665);
		setLayout(null);
		
		JLabel registroAerolineas_label = new JLabel("Registro Aerolineas");
		registroAerolineas_label.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		registroAerolineas_label.setForeground(Color.ORANGE);
		registroAerolineas_label.setBounds(377, 128, 172, 30);
		add(registroAerolineas_label);
		
		JLabel arNombre_label = new JLabel("Nombre Aerolinea");
		arNombre_label.setForeground(Color.ORANGE);
		arNombre_label.setBounds(401, 233, 113, 16);
		add(arNombre_label);
		
		arNombre_tf = new JTextField();
		arNombre_tf.setBounds(394, 261, 130, 26);
		add(arNombre_tf);
		arNombre_tf.setColumns(10);
		
		JLabel alianza_label = new JLabel("Alianza");
		alianza_label.setForeground(Color.ORANGE);
		alianza_label.setBounds(401, 303, 61, 16);
		add(alianza_label);
		
		alianza_cbox = new JComboBox(alianzas);
		alianza_cbox.setBounds(394, 331, 134, 16);
		add(alianza_cbox);
		
		JButton done_bt = new JButton("Done");
		done_bt.setBounds(401, 388, 117, 29);
		done_bt.setActionCommand("RDone_bt");
		done_bt.addActionListener(listener);
		add(done_bt);
	}

	public JTextField getArNombre_tf() {
		return arNombre_tf;
	}

	public JComboBox getAlianza_cbox() {
		return alianza_cbox;
	}
	
	

}
