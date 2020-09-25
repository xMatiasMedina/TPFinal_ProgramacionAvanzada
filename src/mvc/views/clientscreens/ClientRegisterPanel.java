package mvc.views.clientscreens;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.security.ntlm.Client;
import com.toedter.calendar.JDateChooser;

public class ClientRegisterPanel extends JPanel {

	private JTextField nombre_tf;
	private JTextField apellido_tf;
	private JTextField dni_tf;
	private JTextField numeroPasaporte_tf;
	private JTextField otro_tf;
	private JTextField autoridad_tf;
	private JTextField cuit_tf;
	private JDateChooser emision_tf;
	private JDateChooser vencimiento_tf;
	private JDateChooser nacimiento_tf;
	private JTextField mail_tf;
	private JTextField personal_tf;
	private JTextField celular_tf;
	private JTextField laboral_tf;
	private JTextField calle_tf;
	private JTextField altura_tf;
	private JTextField codigo_tf;
	private String[] provincias;//TODO implementar estos dos ultimos
	private String[] paises;
	private JTextField otro_tf2;
	
	public ClientRegisterPanel(ActionListener listener, String[] paises, String[] provincias) {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		this.paises = paises;
		this.provincias = provincias;
		
		startTitleLabel();
		startDocumentacion();
		startPasaporte();
		startComunicacion();
		startDireccion();
		
		JButton done_bt = new JButton("Done");
		done_bt.setBounds(401, 585, 117, 29);
		done_bt.addActionListener(listener);
		done_bt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean isverified = true;
				for(Component component:getComponents()) {
					if(component instanceof JTextField)
						if(((JTextField) component).getText().isEmpty() && component!=otro_tf && component!=otro_tf2)
							isverified = false;
				}
				if(isverified)
					done_bt.setActionCommand("RDone_bt");
				else {
					JOptionPane.showMessageDialog
					(null, "You must fill the empty gaps" , "Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		this.add(done_bt);
	}
	
	public void startTitleLabel() {
		JLabel registro_label = new JLabel("Registro");
		registro_label.setForeground(Color.ORANGE);
		registro_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 25));
		registro_label.setBounds(401, 64, 149, 26);
		this.add(registro_label);
	}
	
	public void startDocumentacion() {

		nombre_tf = new JTextField();
		nombre_tf.setBounds(34, 176, 130, 26);
		this.add(nombre_tf);
		nombre_tf.setColumns(10);
		
		apellido_tf = new JTextField();
		apellido_tf.setBounds(212, 176, 130, 26);
		this.add(apellido_tf);
		apellido_tf.setColumns(10);
		
		JLabel nombre_label = new JLabel("Nombre");
		nombre_label.setForeground(Color.ORANGE);
		nombre_label.setBounds(38, 160, 61, 16);
		this.add(nombre_label);
		
		JLabel apellido_label = new JLabel("Apellido");
		apellido_label.setForeground(Color.ORANGE);
		apellido_label.setBounds(215, 160, 61, 16);
		this.add(apellido_label);
		
		dni_tf = new JTextField();
		dni_tf.setBounds(34, 226, 130, 26);
		this.add(dni_tf);
		dni_tf.setColumns(10);
		
		JLabel dni_label = new JLabel("DNI");
		dni_label.setForeground(Color.ORANGE);
		dni_label.setBounds(38, 210, 61, 16);
		this.add(dni_label);
		
		JLabel cuit_label = new JLabel("CUIT/CUIL");
		cuit_label.setForeground(Color.ORANGE);
		cuit_label.setBounds(38, 264, 76, 16);
		this.add(cuit_label);
		
		cuit_tf = new JTextField();
		cuit_tf.setBounds(34, 277, 130, 26);
		this.add(cuit_tf);
		cuit_tf.setColumns(10);
		
		nacimiento_tf = new JDateChooser();
		nacimiento_tf.setBounds(212, 226, 130, 26);
		this.add(nacimiento_tf);
		
		JLabel nacimiento_label = new JLabel("Fecha de Nacimiento");
		nacimiento_label.setForeground(Color.ORANGE);
		nacimiento_label.setBounds(215, 210, 144, 16);
		this.add(nacimiento_label);
	}

	public void startPasaporte() {
		numeroPasaporte_tf = new JTextField();
		numeroPasaporte_tf.setBounds(34, 395, 130, 26);
		this.add(numeroPasaporte_tf);
		numeroPasaporte_tf.setColumns(10);
		
		JLabel numeroPasaporte_label = new JLabel("Numero de Pasaporte");
		numeroPasaporte_label.setForeground(Color.ORANGE);
		numeroPasaporte_label.setBounds(38, 379, 144, 16);
		this.add(numeroPasaporte_label);
		
		otro_tf = new JTextField();
		otro_tf.setBounds(212, 447, 130, 26);
		otro_tf.setVisible(false);
		this.add(otro_tf);
		otro_tf.setColumns(10);
		
		JComboBox paisEmision_cbox = new JComboBox(paises);
		paisEmision_cbox.setBounds(34, 448, 130, 27);
		paisEmision_cbox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("Otro"))
					otro_tf.setVisible(true);
				else
					otro_tf.setVisible(false);
			}
		});
		this.add(paisEmision_cbox);
		
		JLabel paisEmision_label = new JLabel("Pais de Emision");
		paisEmision_label.setForeground(Color.ORANGE);
		paisEmision_label.setBounds(38, 433, 106, 16);
		this.add(paisEmision_label);
		
		autoridad_tf = new JTextField();
		autoridad_tf.setBounds(34, 503, 130, 26);
		this.add(autoridad_tf);
		autoridad_tf.setColumns(10);
		
		JLabel autoridad_label = new JLabel("Autoridad de Emision");
		autoridad_label.setForeground(Color.ORANGE);
		autoridad_label.setBounds(38, 487, 144, 16);
		this.add(autoridad_label);
		
		JLabel pasaport_label = new JLabel("Pasaporte");
		pasaport_label.setForeground(Color.ORANGE);
		pasaport_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		pasaport_label.setBounds(132, 341, 130, 26);
		this.add(pasaport_label);
		
		JLabel documentacion_label = new JLabel("Documentacion");
		documentacion_label.setForeground(Color.ORANGE);
		documentacion_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		documentacion_label.setBounds(116, 120, 130, 26);
		this.add(documentacion_label);
		
		JLabel emision_label = new JLabel("Fecha de Emision");
		emision_label.setForeground(Color.ORANGE);
		emision_label.setBounds(38, 544, 126, 16);
		this.add(emision_label);
		
		emision_tf = new JDateChooser();
		emision_tf.setBounds(34, 560, 130, 26);
		this.add(emision_tf);
		
		vencimiento_tf = new JDateChooser();
		vencimiento_tf.setBounds(212, 560, 130, 26);
		this.add(vencimiento_tf);
		
		JLabel vencimiento_label = new JLabel("Fecha de Vencimiento");
		vencimiento_label.setForeground(Color.ORANGE);
		vencimiento_label.setBounds(215, 544, 144, 16);
		this.add(vencimiento_label);
	}

	public void startComunicacion() {
		JLabel comunicacion_label = new JLabel("Comunicacion");
		comunicacion_label.setForeground(Color.ORANGE);
		comunicacion_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		comunicacion_label.setBounds(665, 120, 130, 26);
		this.add(comunicacion_label);
		
		mail_tf = new JTextField();
		mail_tf.setBounds(753, 176, 130, 26);
		this.add(mail_tf);
		mail_tf.setColumns(10);
		
		JLabel mail_label = new JLabel("E-Mail");
		mail_label.setForeground(Color.ORANGE);
		mail_label.setBounds(756, 160, 61, 16);
		this.add(mail_label);
		
		personal_tf = new JTextField();
		personal_tf.setBounds(574, 176, 130, 26);
		this.add(personal_tf);
		personal_tf.setColumns(10);
		
		JLabel personal_label = new JLabel("Numero Personal");
		personal_label.setForeground(Color.ORANGE);
		personal_label.setBounds(578, 160, 125, 16);
		this.add(personal_label);
		
		JLabel celular_label = new JLabel("Numero Celular");
		celular_label.setForeground(Color.ORANGE);
		celular_label.setBounds(578, 210, 118, 16);
		this.add(celular_label);
		
		celular_tf = new JTextField();
		celular_tf.setBounds(574, 226, 130, 26);
		this.add(celular_tf);
		celular_tf.setColumns(10);
		
		JLabel laboral_label = new JLabel("Numero Laboral");
		laboral_label.setForeground(Color.ORANGE);
		laboral_label.setBounds(578, 264, 118, 16);
		this.add(laboral_label);
		
		laboral_tf = new JTextField();
		laboral_tf.setBounds(574, 277, 130, 26);
		this.add(laboral_tf);
		laboral_tf.setColumns(10);
	}

	public void startDireccion() {
		JLabel direccion_label = new JLabel("Direccion");
		direccion_label.setForeground(Color.ORANGE);
		direccion_label.setFont(new Font("Ubuntu Mono derivative Powerline", Font.PLAIN, 20));
		direccion_label.setBounds(675, 341, 130, 26);
		this.add(direccion_label);
		
		JLabel calle_label = new JLabel("Calle");
		calle_label.setForeground(Color.ORANGE);
		calle_label.setBounds(578, 379, 61, 16);
		this.add(calle_label);
		
		calle_tf = new JTextField();
		calle_tf.setBounds(574, 395, 130, 26);
		this.add(calle_tf);
		calle_tf.setColumns(10);
		
		altura_tf = new JTextField();
		altura_tf.setBounds(753, 395, 130, 26);
		this.add(altura_tf);
		altura_tf.setColumns(10);
		
		JLabel altura_label = new JLabel("Altura");
		altura_label.setForeground(Color.ORANGE);
		altura_label.setBounds(756, 379, 61, 16);
		this.add(altura_label);
		
		JLabel pais_label = new JLabel("Pais");
		pais_label.setForeground(Color.ORANGE);
		pais_label.setBounds(578, 433, 61, 16);
		this.add(pais_label);
		
		JComboBox provincia_cbox = new JComboBox(provincias);
		provincia_cbox.setBounds(753, 447, 130, 27);
		provincia_cbox.setVisible(false);
		this.add(provincia_cbox);
		
		JLabel provincia_label = new JLabel("Provincia");
		provincia_label.setForeground(Color.ORANGE);
		provincia_label.setBounds(756, 433, 61, 16);
		provincia_label.setVisible(false);
		this.add(provincia_label);
		
		otro_tf2 = new JTextField();
		otro_tf2.setBounds(753, 447, 130, 27);
		otro_tf2.setVisible(false);
		this.add(otro_tf2);
		otro_tf2.setColumns(10);
		
		JComboBox pais_cbox = new JComboBox(paises);
		pais_cbox.setBounds(574, 447, 130, 27);
		pais_cbox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getItem().equals("Argentina")) {
					provincia_label.setVisible(true);
					provincia_cbox.setVisible(true);
				}
				else {
					provincia_label.setVisible(false);
					provincia_cbox.setVisible(false);
				}
				if(e.getItem().equals("Otro"))
					otro_tf2.setVisible(true);
				else
					otro_tf2.setVisible(false);
			}
		});
		this.add(pais_cbox);
		
		JLabel postal_label = new JLabel("Codigo Postal");
		postal_label.setForeground(Color.ORANGE);
		postal_label.setBounds(578, 487, 98, 16);
		this.add(postal_label);
		
		codigo_tf = new JTextField();
		codigo_tf.setBounds(574, 503, 130, 26);
		this.add(codigo_tf);
		codigo_tf.setColumns(10);
	}
}
