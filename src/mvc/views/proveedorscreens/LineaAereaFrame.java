package mvc.views.proveedorscreens;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import mvc.modelo.dominio.Alianza;
import mvc.views.clientscreens.AdquiridosPanel;
import mvc.views.vueloscreens.AddVuelosPanel;
import mvc.views.vueloscreens.ManageVuelosPanel;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class LineaAereaFrame extends JFrame {

	private JPanel contentPane, registerPanel, addVuelosPanel, manageVuelosPanel, manageLineaAereaPanel;
	private JTabbedPane mainscreen;	

	/**
	 * Create the frame.
	 */
	public LineaAereaFrame(ActionListener listener, Alianza[] alianzas) {
		setTitle("LineaAerea Session");
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
		registerPanel = new RegistrarAerolineaPanel(listener, alianzas);
		contentPane.add(registerPanel, "register_panel");
		
		addVuelosPanel = new AddVuelosPanel();
		mainscreen.addTab("Agregar",UIManager.getIcon("OptionPane.informationIcon"), addVuelosPanel, "Agregar Vuelos");
		manageVuelosPanel = new ManageVuelosPanel();
		mainscreen.addTab("Administrar",UIManager.getIcon("OptionPane.informationIcon"), manageVuelosPanel, "Administrar Vuelos");
		manageLineaAereaPanel = new ManageLineaAereaPanel(listener);
		mainscreen.addTab("Cuenta",UIManager.getIcon("OptionPane.informationIcon"), manageLineaAereaPanel, "Configuracion de Aerolinea");
	}

	public AddVuelosPanel getAddVuelosPanel() {
		return (AddVuelosPanel) addVuelosPanel;
	}

	public ManageVuelosPanel getManageVuelosPanel() {
		return (ManageVuelosPanel) manageVuelosPanel;
	}
	
	
	public RegistrarAerolineaPanel getRegisterPanel() {
		return (RegistrarAerolineaPanel) registerPanel;
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
	
	
}
