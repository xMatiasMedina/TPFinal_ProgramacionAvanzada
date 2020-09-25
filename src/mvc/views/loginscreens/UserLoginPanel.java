package mvc.views.loginscreens;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class UserLoginPanel extends JPanel {
	
	private JTextField user_tf;
	private JPasswordField passwordField;
	private ActionListener listener;

	/**
	 * Create the panel.
	 * @param listener 
	 */
	public UserLoginPanel(ActionListener listener) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		this.listener = listener;
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
		register_bt.addActionListener(listener);
		register_bt.setActionCommand("Register_bt1");
		this.add(register_bt);
		
		JButton login_bt = new JButton("Login");
		login_bt.setBounds(258, 212, 117, 29);
		login_bt.addActionListener(listener);
		login_bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(user_tf.getText().isEmpty() || String.copyValueOf(passwordField.getPassword()).isEmpty()) {
					login_bt.setActionCommand(null);
					JOptionPane.showMessageDialog(null, "You must fill the empty gaps" , "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					login_bt.setActionCommand("Login_bt");
				}
			}
		});
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

	public JTextField getUser_tf() {
		return user_tf;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
