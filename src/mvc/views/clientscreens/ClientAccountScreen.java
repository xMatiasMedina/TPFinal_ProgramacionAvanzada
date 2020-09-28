package mvc.views.clientscreens;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClientAccountScreen extends JPanel {

	private JButton modifyAccount_bt;
	private JButton deleteAccount_bt;
	
	public ClientAccountScreen() {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		startComponents();
	}
	
	private void startComponents() {
		modifyAccount_bt = new JButton("Modify");
		modifyAccount_bt.setBounds(378, 204, 117, 29);
		this.add(modifyAccount_bt);
		
		deleteAccount_bt = new JButton("Delete");
		deleteAccount_bt.setBounds(378, 273, 117, 29);
		this.add(deleteAccount_bt);
	}

}
