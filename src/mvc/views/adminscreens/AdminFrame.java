package mvc.views.adminscreens;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mvc.views.clientscreens.ClientRegisterPanel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminFrame extends JFrame {

	private JPanel contentPane, adminPanel, addAeropuertoPanel;

	public AdminFrame(ActionListener listener1, ActionListener listener2) {
		setTitle("Admin Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 439);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		adminPanel = new AdminPanel(listener1, listener2);
		contentPane.add(adminPanel, "admin_panel");
		addAeropuertoPanel = new AddAeropuertoPanel(listener2);
		contentPane.add(addAeropuertoPanel, "aeropuerto_panel");
	}
	
	public String askInput(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public void switchPanel(int i) {
		CardLayout layout = (CardLayout) contentPane.getLayout();
		switch(i) {
			case 0:
				layout.show(getContentPane(), "admin_panel");
				break;
			case 1:
				layout.show(getContentPane(), "aeropuerto_panel");
				break;
				default:
					throw new RuntimeException("Se esta pidiendo un panel no existente");
		}
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public AdminPanel getAdminPanel() {
		return (AdminPanel) adminPanel;
	}

	public AddAeropuertoPanel getAddAeropuertoPanel() {
		return (AddAeropuertoPanel) addAeropuertoPanel;
	}
	
	public void printPaneError(String message) {
		JOptionPane.showMessageDialog(null, message , "Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void printPaneWarning(String message) {
		JOptionPane.showMessageDialog(null, message , "Warning",JOptionPane.WARNING_MESSAGE);
	}
	
}
