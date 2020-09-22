package mvc.views.loginscreens;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class UserLoginFrame extends JFrame {

	private JPanel contentPane;
	private UserLoginPanel login_panel;
	private UserRegisterPanel register_panel;

	/**
	 * Create the frame.
	 */
	public UserLoginFrame(ActionListener listener) {
		setTitle("Login Screen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		login_panel = new UserLoginPanel(listener);
		contentPane.add(login_panel);
		login_panel.startComponents();
		
		register_panel = new UserRegisterPanel(listener);
		contentPane.add(register_panel);
		register_panel.startComponents();
	}

	public UserLoginPanel getLogin_panel() {
		return login_panel;
	}

	public UserRegisterPanel getRegister_panel() {
		return register_panel;
	}
	
	public void switchPanel() {
		//register_panel.
	}
}
