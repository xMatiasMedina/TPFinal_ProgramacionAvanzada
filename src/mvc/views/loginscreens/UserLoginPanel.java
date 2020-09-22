package mvc.views.loginscreens;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLoginPanel extends JPanel {
	
	private JTextField user_tf;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 * @param listener 
	 */
	public UserLoginPanel(ActionListener listener) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
	}

	public void startComponents() {
		user_tf = new JTextField();
		user_tf.setBounds(154, 62, 130, 26);
		this.add(user_tf);
		user_tf.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 134, 130, 26);
		this.add(passwordField);
		
		JButton register_bt = new JButton("Register");
		register_bt.setBounds(62, 212, 117, 29);
		this.add(register_bt);
		
		JButton login_bt = new JButton("Login");
		login_bt.setBounds(258, 212, 117, 29);
		this.add(login_bt);
		
		JLabel username_label = new JLabel("Username");
		username_label.setForeground(Color.ORANGE);
		username_label.setBounds(154, 46, 78, 16);
		this.add(username_label);
		
		JLabel password_label = new JLabel("Password");
		password_label.setForeground(Color.ORANGE);
		password_label.setBounds(154, 118, 61, 16);
		this.add(password_label);
		
	}

}
