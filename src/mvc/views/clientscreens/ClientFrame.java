package mvc.views.clientscreens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;

public class ClientFrame extends JFrame {

	private JPanel contentPane, registerPanel;
	private JTabbedPane mainscreen;
	/**
	 * Create the frame.
	 */
	public ClientFrame(ActionListener listener, String[] paises, String[] provincias) {
		setTitle("Client Session");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 665);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		mainscreen = new JTabbedPane(JTabbedPane.LEFT);
		contentPane.add(mainscreen, "mainscreen");
		registerPanel = new ClientRegisterPanel(listener, paises, provincias);
		contentPane.add(registerPanel, "register_panel");
		
		JPanel panel3 = new JPanel();
		mainscreen.addTab("Adquiridos",UIManager.getIcon("OptionPane.informationIcon"), panel3, "Comprar vuelos");
		JPanel panel = new JPanel();
		mainscreen.addTab("Vuelos",UIManager.getIcon("OptionPane.informationIcon"), panel, "Comprar vuelos");
		JPanel panel2 = new JPanel();
		mainscreen.addTab("Mi Cuenta",UIManager.getIcon("OptionPane.informationIcon"), panel2, "Comprar vuelos");
	}
	
	public void switchPanel(int i) {
		CardLayout layout = (CardLayout) contentPane.getLayout();
		switch(i) {
			case 0:
				layout.show(getContentPane(), "register_panel");
				break;
			case 1:
				layout.show(getContentPane(), "mainscreen");
				break;
				default:
					throw new RuntimeException("Se esta pidiendo un panel no existente");
		}
	}
	
	public void printPaneError(String message) {
		JOptionPane.showMessageDialog(null, message , "Error",JOptionPane.ERROR_MESSAGE);
	}
	
	public void printPaneWarning(String message) {
		JOptionPane.showMessageDialog(null, message , "Warning",JOptionPane.WARNING_MESSAGE);
	}

	public JPanel getRegisterPanel() {
		return registerPanel;
	}

	public JTabbedPane getMainscreen() {
		return mainscreen;
	}

}
