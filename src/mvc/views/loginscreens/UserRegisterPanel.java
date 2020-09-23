package mvc.views.loginscreens;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserRegisterPanel extends JPanel {

	private JTextField username_tf;
	private JTextField password_pf;
	private JComboBox type_cb;
	private ActionListener listener;
	/**
	 * Create the panel.
	 * @param listener 
	 */
	public UserRegisterPanel(ActionListener listener) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		this.listener = listener;
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
		type_cb = new JComboBox(new String[]{"Cliente", "Proveedor"});
		type_cb.setBounds(155, 168, 130, 27);
		this.add(type_cb);
		JButton register_button = new JButton("Register");
		register_button.setBounds(160, 222, 117, 29);
		register_button.addActionListener(listener);
		register_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(username_tf.getText().isEmpty() || password_pf.getText().isEmpty()) {
					register_button.setActionCommand(null);
					JOptionPane.showMessageDialog(null, "You must fill the empty gaps" , "Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					register_button.setActionCommand("Register_bt2");
				}
			}
		});
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

	public JTextField getUsername_tf() {
		return username_tf;
	}

	public JTextField getPassword_pf() {
		return password_pf;
	}

	public JComboBox getType_cb() {
		return type_cb;
	}
}
