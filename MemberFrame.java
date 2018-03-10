import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MemberFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	
	public MemberFrame() {
		
		//get name using some method
		JLabel name = new JLabel("Name");
		JPanel msgPanel = createMsgPanel();
		JPanel rmdPanel = createRmdPanel();
		JPanel panel = new JPanel();
		
		add(name, BorderLayout.NORTH);
		add(msgPanel, BorderLayout.CENTER);
		add(rmdPanel, BorderLayout.SOUTH);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	/**
	   Creates panel for messages.
	   @return the message panel.
	 */
	public JPanel createMsgPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Messages"));
		
		//(to be added) Read in messages and add to textArea. 
		JTextArea msgArea = new JTextArea(25, 5);
		msgArea.setEditable(false);
		
		panel.add(msgArea);
		return panel;
	}
	
	/**
	   Creates panel for reminders.
	   @return the reminder panel.
	 */
	public JPanel createRmdPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Reminders"));
		
		//(to be added) Read in reminders and add to textArea. 
		JTextArea rmdArea = new JTextArea(15, 20);
		rmdArea.setEditable(false);
		
		panel.add(rmdArea);
		return panel;
	}
	
}
