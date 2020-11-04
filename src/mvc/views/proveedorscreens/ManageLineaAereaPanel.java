package mvc.views.proveedorscreens;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;

public class ManageLineaAereaPanel extends JPanel {
	
	private JButton modify_bt;
	private JButton delete_bt;

	/**
	 * Create the panel.
	 */
	public ManageLineaAereaPanel(ActionListener listener) {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		modify_bt = new JButton("Modify");
		modify_bt.setBounds(364, 172, 117, 29);
		modify_bt.setActionCommand("Modify_bt");
		modify_bt.addActionListener(listener);
		this.add(modify_bt);
		
		delete_bt = new JButton("Delete");
		delete_bt.setBounds(364, 241, 117, 29);
		delete_bt.setActionCommand("Delete_bt");
		delete_bt.addActionListener(listener);
		this.add(delete_bt);

	}

}
