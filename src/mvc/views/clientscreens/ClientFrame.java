package mvc.views.clientscreens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import mvc.modelo.dominio.Vuelo;
import mvc.views.vueloscreens.VuelosTableModel;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class ClientFrame extends JFrame {

	private JPanel contentPane, registerPanel, accountPanel, vuelosPanel, adquiridosPanel;
	private JTabbedPane mainscreen;
	private JTable table;
	private JTextField idVuelo_tf;
	
	
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
		
		adquiridosPanel = new AdquiridosPanel();
		mainscreen.addTab("Adquiridos",UIManager.getIcon("OptionPane.informationIcon"), adquiridosPanel, "Vuelos Adquiridos");
		vuelosPanel = new ComprarVuelosPanel();
		mainscreen.addTab("Vuelos",UIManager.getIcon("OptionPane.informationIcon"), vuelosPanel, "Comprar vuelos");
		accountPanel = new ClientAccountScreen(listener);
		mainscreen.addTab("Mi Cuenta",UIManager.getIcon("OptionPane.informationIcon"), accountPanel, "Configuracion de Cuenta");
	}
	
	//Esto es SOLO para el CardBoard Layout, de ser necesario es facil agragar mas paneles
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

	public ClientRegisterPanel getRegisterPanel() {
		return (ClientRegisterPanel) registerPanel;
	}

	public JTabbedPane getMainscreen() {
		return mainscreen;
	}
}
