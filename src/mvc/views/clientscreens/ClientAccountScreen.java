package mvc.views.clientscreens;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ClientAccountScreen extends JPanel {

	private JButton modifyAccount_bt;
	private JButton deleteAccount_bt;
	private ActionListener listener;
	
	public ClientAccountScreen(ActionListener listener) {
		this.setBackground(Color.DARK_GRAY);
		this.listener = listener;
		this.setLayout(null);
		startComponents();
	}
	
	private void startComponents() {
		modifyAccount_bt = new JButton("Modify");
		modifyAccount_bt.setBounds(378, 204, 117, 29);
		modifyAccount_bt.setActionCommand("Modify_bt");
		modifyAccount_bt.addActionListener(listener);
		this.add(modifyAccount_bt);
		
		deleteAccount_bt = new JButton("Delete");
		deleteAccount_bt.setBounds(378, 273, 117, 29);
		deleteAccount_bt.setActionCommand("Delete_bt");
		deleteAccount_bt.addActionListener(listener);
		this.add(deleteAccount_bt);
	}

}
