import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class MemberFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	
	public MemberFrame() {
		
		//create the panels
		JPanel titlePanel = createTitlePanel();
		JPanel msgPanel = createMsgPanel();
		JPanel rmdPanel = createRmdPanel();
		
		add(titlePanel, BorderLayout.NORTH);
		add(msgPanel, BorderLayout.CENTER);
		add(rmdPanel, BorderLayout.SOUTH);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	/**
	   Creates panel for the title.
	   @return the title panel.
	 */
	public JPanel createTitlePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		//get name using some method
		String nameStr = " Name";
		JLabel name = new JLabel(nameStr);
		name.setFont(new Font("Serif", Font.BOLD, 30));
		
		panel.add(name);
		return panel;
	}
	
	/**
	   Creates panel for messages.
	   @return the message panel.
	 */
	public JPanel createMsgPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Messages", 
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Serif", Font.PLAIN, 25)));
		
		//(to be added) Read in messages and add to textArea. 
		JTextArea msgArea = new JTextArea();
		msgArea.setPreferredSize(new Dimension (400, 400));
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
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Reminders", 
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Serif", Font.PLAIN, 25)));
		
		//(to be added) Read in reminders and add to textArea. 
		JTextArea rmdArea = new JTextArea();
		rmdArea.setPreferredSize(new Dimension (400, 200));
		rmdArea.setEditable(false);
		
		panel.add(rmdArea);
		return panel;
	}
	
}
