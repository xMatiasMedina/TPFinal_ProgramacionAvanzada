package mvc.views.vueloscreens;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.components.JLocaleChooser;

import mvc.modelo.dominio.Aeropuerto;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class AddVuelosPanel extends JPanel {
	private JTextField asientos_tf;
	private JDateChooser dateLlegada;
	private JDateChooser dateSalida;
	private JTextField timeSalida_tf;
	private JTextField timeLlegada_tf;
	private JComboBox arSalida_cbox;
	private JComboBox arLlegada_cbox;
	private JButton done_bt;

	/**
	 * Create the panel.
	 */
	public AddVuelosPanel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel nuevovuelo_label = new JLabel("Nuevo Vuelo");
		nuevovuelo_label.setFont(new Font("Dialog", Font.PLAIN, 17));
		nuevovuelo_label.setForeground(Color.ORANGE);
		nuevovuelo_label.setBounds(378, 58, 120, 35);
		add(nuevovuelo_label);
		
		JLabel cantidadAsientos_label = new JLabel("Cantidad Asientos");
		cantidadAsientos_label.setForeground(Color.ORANGE);
		cantidadAsientos_label.setBounds(373, 145, 125, 16);
		add(cantidadAsientos_label);
		
		asientos_tf = new JTextField();
		asientos_tf.setBounds(368, 173, 130, 26);
		add(asientos_tf);
		asientos_tf.setColumns(10);
		
		JLabel arSalida_label = new JLabel("Aeropuerto Salida");
		arSalida_label.setForeground(Color.ORANGE);
		arSalida_label.setBounds(305, 223, 120, 16);
		add(arSalida_label);
		
		arSalida_cbox = new JComboBox();
		arSalida_cbox.setBounds(301, 249, 130, 27);
		add(arSalida_cbox);
		
		JLabel dateSalida_label = new JLabel("Dia Salida");
		dateSalida_label.setForeground(Color.ORANGE);
		dateSalida_label.setBounds(305, 302, 76, 16);
		add(dateSalida_label);
		
		dateSalida = new JDateChooser();
		dateSalida.setBounds(305, 330, 99, 26);
		add(dateSalida);
		
		timeSalida_tf = new JTextField();
		timeSalida_tf.setText("00:00");
		timeSalida_tf.setBounds(458, 330, 130, 26);
		add(timeSalida_tf);
		timeSalida_tf.setColumns(10);
		
		JLabel timeSalida_label = new JLabel("Hora Salida");
		timeSalida_label.setForeground(Color.ORANGE);
		timeSalida_label.setBounds(464, 302, 76, 16);
		add(timeSalida_label);
		
		JLabel dateLlegada_label = new JLabel("Dia Llegada");
		dateLlegada_label.setForeground(Color.ORANGE);
		dateLlegada_label.setBounds(305, 387, 76, 16);
		add(dateLlegada_label);
		
		JLabel timeLlegada_label = new JLabel("Hora Llegada");
		timeLlegada_label.setForeground(Color.ORANGE);
		timeLlegada_label.setBounds(464, 387, 82, 16);
		add(timeLlegada_label);
		
		dateLlegada = new JDateChooser();
		dateLlegada.setBounds(305, 412, 99, 26);
		add(dateLlegada);
		
		timeLlegada_tf = new JTextField();
		timeLlegada_tf.setText("00:00");
		timeLlegada_tf.setBounds(458, 412, 130, 26);
		add(timeLlegada_tf);
		timeLlegada_tf.setColumns(10);
		
		JLabel arLlegada_label = new JLabel("Aeropuerto Llegada");
		arLlegada_label.setForeground(Color.ORANGE);
		arLlegada_label.setBounds(463, 223, 125, 16);
		add(arLlegada_label);
		
		arLlegada_cbox = new JComboBox();
		arLlegada_cbox.setBounds(458, 249, 130, 27);
		add(arLlegada_cbox);
		
		done_bt = new JButton("Done");
		done_bt.setBounds(378, 462, 117, 29);
		done_bt.setActionCommand("RDone_bt");
		add(done_bt);
	}
	
	
	
	public JTextField getAsientos_tf() {
		return asientos_tf;
	}



	public JDateChooser getDateLlegada() {
		return dateLlegada;
	}



	public JDateChooser getDateSalida() {
		return dateSalida;
	}



	public JTextField getTimeSalida_tf() {
		return timeSalida_tf;
	}



	public JTextField getTimeLlegada_tf() {
		return timeLlegada_tf;
	}



	public JComboBox getArLlegada_cbox() {
		return arLlegada_cbox;
	}

	public JComboBox getArSalida_cbox() {
		return arSalida_cbox;
	}



	public void setListener(ActionListener listener) {
		done_bt.addActionListener(listener);
	}



	public void loadAeropuertos(List<Aeropuerto> all) {
		for (Aeropuerto aeropuerto : all) {
			arLlegada_cbox.addItem(aeropuerto.getIdentificacion());
			arSalida_cbox.addItem(aeropuerto.getIdentificacion());
		}		
	}
}
