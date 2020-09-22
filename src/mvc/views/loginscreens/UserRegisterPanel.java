package mvc.views.loginscreens;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserRegisterPanel extends JPanel {

	private JTextField username_tf;
	private JTextField password_pf;
	private JComboBox type_cb;

	/**
	 * Create the panel.
	 */
	public UserRegisterPanel() {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
	}
	
	public void startComponents() {	
		username_tf = new JTextField();
		username_tf.setBounds(155, 53, 130, 26);
		this.add(username_tf);
		username_tf.setColumns(10);
		
		password_pf = new JTextField();
		password_pf.setBounds(155, 109, 130, 26);
		this.add(password_pf);
		password_pf.setColumns(10);
		
		type_cb = new JComboBox();
		type_cb.setBounds(155, 168, 130, 27);
		this.add(type_cb);
		
		JButton register_button = new JButton("Register");
		register_button.setBounds(160, 222, 117, 29);
		this.add(register_button);
		
		JLabel username_label = new JLabel("Username");
		username_label.setForeground(Color.ORANGE);
		username_label.setBounds(155, 37, 83, 16);
		this.add(username_label);
		
		JLabel password_label = new JLabel("Password");
		password_label.setForeground(Color.ORANGE);
		password_label.setBounds(155, 92, 61, 16);
		this.add(password_label);
		
		JLabel type_label = new JLabel("Type");
		type_label.setForeground(Color.ORANGE);
		type_label.setBounds(155, 149, 61, 16);
		this.add(type_label);
	}

}
