package mvc.views.clientscreens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ClientRegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nombre_tf;
	private JTextField apellido_tf;
	private JTextField dni_tf;
	private JTextField numeroPasaporte_tf;
	private JTextField otro_tf;
	private JTextField autoridad_tf;
	private JTextField cuit_tf;
	private JTextField emision_tf;
	private JTextField vencimiento_tf;
	private JTextField nacimiento_tf;
	private JTextField userName_tf;
	private JTextField password_tf;
	private JTextField mail_tf;
	private JTextField personal_tf;
	private JTextField celular_tf;
	private JTextField laboral_tf;
	private JTextField calle_tf;
	private JTextField altura_tf;
	private JTextField codigo_tf;

	/**
	 * Create the frame.
	 */
	public ClientRegisterFrame(ActionListener listener) {
		setTitle("Sign Up Screen");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 916, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startUserComponents();
		startDocumentacion();
		startPasaporte();
		startComunicacion();
		startDireccion();
		
		JButton signup_bt = new JButton("Sign Up");
		signup_bt.setBounds(401, 585, 117, 29);
		signup_bt.addActionListener(listener);
		signup_bt.setActionCommand("SignUp_bt2");
		contentPane.add(signup_bt);
	}
	
	public void startUserComponents() {
		JLabel usuario_label = new JLabel("Usuario");
		usuario_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		usuario_label.setBounds(421, 24, 76, 26);
		contentPane.add(usuario_label);
		
		userName_tf = new JTextField();
		userName_tf.setBounds(296, 74, 130, 26);
		contentPane.add(userName_tf);
		userName_tf.setColumns(10);
		
		JLabel userName_label = new JLabel("Usuario");
		userName_label.setBounds(300, 60, 61, 16);
		contentPane.add(userName_label);
		
		password_tf = new JTextField();
		password_tf.setBounds(498, 74, 130, 26);
		contentPane.add(password_tf);
		password_tf.setColumns(10);
		
		JLabel password_label = new JLabel("Password");
		password_label.setBounds(504, 60, 61, 16);
		contentPane.add(password_label);
	}
	
	public void startDocumentacion() {

		nombre_tf = new JTextField();
		nombre_tf.setBounds(34, 176, 130, 26);
		contentPane.add(nombre_tf);
		nombre_tf.setColumns(10);
		
		apellido_tf = new JTextField();
		apellido_tf.setBounds(212, 176, 130, 26);
		contentPane.add(apellido_tf);
		apellido_tf.setColumns(10);
		
		JLabel nombre_label = new JLabel("Nombre");
		nombre_label.setBounds(38, 160, 61, 16);
		contentPane.add(nombre_label);
		
		JLabel apellido_label = new JLabel("Apellido");
		apellido_label.setBounds(215, 160, 61, 16);
		contentPane.add(apellido_label);
		
		dni_tf = new JTextField();
		dni_tf.setBounds(34, 226, 130, 26);
		contentPane.add(dni_tf);
		dni_tf.setColumns(10);
		
		JLabel dni_label = new JLabel("DNI");
		dni_label.setBounds(38, 210, 61, 16);
		contentPane.add(dni_label);
		
		JLabel cuit_label = new JLabel("CUIT/CUIL");
		cuit_label.setBounds(38, 264, 76, 16);
		contentPane.add(cuit_label);
		
		cuit_tf = new JTextField();
		cuit_tf.setBounds(34, 277, 130, 26);
		contentPane.add(cuit_tf);
		cuit_tf.setColumns(10);
		
		nacimiento_tf = new JTextField();
		nacimiento_tf.setBounds(212, 226, 130, 26);
		contentPane.add(nacimiento_tf);
		nacimiento_tf.setColumns(10);
		
		JLabel nacimiento_label = new JLabel("Fecha de Nacimiento");
		nacimiento_label.setBounds(215, 210, 144, 16);
		contentPane.add(nacimiento_label);
	}

	public void startPasaporte() {
		numeroPasaporte_tf = new JTextField();
		numeroPasaporte_tf.setBounds(34, 395, 130, 26);
		contentPane.add(numeroPasaporte_tf);
		numeroPasaporte_tf.setColumns(10);
		
		JLabel numeroPasaporte_label = new JLabel("Numero de Pasaporte");
		numeroPasaporte_label.setBounds(38, 379, 144, 16);
		contentPane.add(numeroPasaporte_label);
		
		JComboBox paisEmision_cbox = new JComboBox();
		paisEmision_cbox.setBounds(34, 448, 130, 27);
		contentPane.add(paisEmision_cbox);
		
		JLabel paisEmision_label = new JLabel("Pais de Emision");
		paisEmision_label.setBounds(38, 433, 106, 16);
		contentPane.add(paisEmision_label);
		
		otro_tf = new JTextField();
		otro_tf.setText("Otro_tf");
		otro_tf.setBounds(212, 447, 130, 26);
		contentPane.add(otro_tf);
		otro_tf.setColumns(10);
		
		autoridad_tf = new JTextField();
		autoridad_tf.setBounds(34, 503, 130, 26);
		contentPane.add(autoridad_tf);
		autoridad_tf.setColumns(10);
		
		JLabel autoridad_label = new JLabel("Autoridad de Emision");
		autoridad_label.setBounds(38, 487, 144, 16);
		contentPane.add(autoridad_label);
		
		JLabel pasaport_label = new JLabel("Pasaporte");
		pasaport_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		pasaport_label.setBounds(132, 341, 130, 26);
		contentPane.add(pasaport_label);
		
		JLabel documentacion_label = new JLabel("Documentacion");
		documentacion_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		documentacion_label.setBounds(116, 120, 130, 26);
		contentPane.add(documentacion_label);
		
		JLabel emision_label = new JLabel("Fecha de Emision");
		emision_label.setBounds(38, 544, 126, 16);
		contentPane.add(emision_label);
		
		emision_tf = new JTextField();
		emision_tf.setBounds(34, 560, 130, 26);
		contentPane.add(emision_tf);
		emision_tf.setColumns(10);
		
		vencimiento_tf = new JTextField();
		vencimiento_tf.setBounds(212, 560, 130, 26);
		contentPane.add(vencimiento_tf);
		vencimiento_tf.setColumns(10);
		
		JLabel vencimiento_label = new JLabel("Fecha de Vencimiento");
		vencimiento_label.setBounds(215, 544, 144, 16);
		contentPane.add(vencimiento_label);
	}

	public void startComunicacion() {
		JLabel comunicacion_label = new JLabel("Comunicacion");
		comunicacion_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		comunicacion_label.setBounds(665, 120, 130, 26);
		contentPane.add(comunicacion_label);
		
		mail_tf = new JTextField();
		mail_tf.setBounds(753, 176, 130, 26);
		contentPane.add(mail_tf);
		mail_tf.setColumns(10);
		
		JLabel mail_label = new JLabel("E-Mail");
		mail_label.setBounds(756, 160, 61, 16);
		contentPane.add(mail_label);
		
		personal_tf = new JTextField();
		personal_tf.setBounds(574, 176, 130, 26);
		contentPane.add(personal_tf);
		personal_tf.setColumns(10);
		
		JLabel personal_label = new JLabel("Numero Personal");
		personal_label.setBounds(578, 160, 125, 16);
		contentPane.add(personal_label);
		
		JLabel celular_label = new JLabel("Numero Celular");
		celular_label.setBounds(578, 210, 118, 16);
		contentPane.add(celular_label);
		
		celular_tf = new JTextField();
		celular_tf.setBounds(574, 226, 130, 26);
		contentPane.add(celular_tf);
		celular_tf.setColumns(10);
		
		JLabel laboral_label = new JLabel("Numero Laboral");
		laboral_label.setBounds(578, 264, 118, 16);
		contentPane.add(laboral_label);
		
		laboral_tf = new JTextField();
		laboral_tf.setBounds(574, 277, 130, 26);
		contentPane.add(laboral_tf);
		laboral_tf.setColumns(10);
	}

	public void startDireccion() {
		JLabel direccion_label = new JLabel("Direccion");
		direccion_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		direccion_label.setBounds(675, 341, 130, 26);
		contentPane.add(direccion_label);
		
		JLabel calle_label = new JLabel("Calle");
		calle_label.setBounds(578, 379, 61, 16);
		contentPane.add(calle_label);
		
		calle_tf = new JTextField();
		calle_tf.setBounds(574, 395, 130, 26);
		contentPane.add(calle_tf);
		calle_tf.setColumns(10);
		
		altura_tf = new JTextField();
		altura_tf.setBounds(753, 395, 130, 26);
		contentPane.add(altura_tf);
		altura_tf.setColumns(10);
		
		JLabel altura_label = new JLabel("Altura");
		altura_label.setBounds(756, 379, 61, 16);
		contentPane.add(altura_label);
		
		JLabel pais_label = new JLabel("Pais");
		pais_label.setBounds(578, 433, 61, 16);
		contentPane.add(pais_label);
		
		JComboBox pais_cbox = new JComboBox();
		pais_cbox.setBounds(574, 447, 130, 27);
		contentPane.add(pais_cbox);
		
		JComboBox provincia_cbox = new JComboBox();
		provincia_cbox.setBounds(753, 447, 130, 27);
		contentPane.add(provincia_cbox);
		
		JLabel provincia_label = new JLabel("Provincia");
		provincia_label.setBounds(756, 433, 61, 16);
		contentPane.add(provincia_label);
		
		JLabel postal_label = new JLabel("Codigo Postal");
		postal_label.setBounds(578, 487, 98, 16);
		contentPane.add(postal_label);
		
		codigo_tf = new JTextField();
		codigo_tf.setBounds(574, 503, 130, 26);
		contentPane.add(codigo_tf);
		codigo_tf.setColumns(10);
	}
}
