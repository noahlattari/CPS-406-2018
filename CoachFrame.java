import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * 
 */
public class CoachFrame extends JFrame{
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	
	public CoachFrame(){
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=0.05;
		constraints.gridx=0;
		constraints.gridy=0;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		add(addWelcome(),constraints);
		constraints.gridy=1;
		constraints.weighty=0.5;
		add(addAnnouncements(),constraints);
		constraints.gridy=2;
		add(addMessages(),constraints);
		constraints.gridy=3;
		add(addMemLog(),constraints);
	}
	
	public static void main(String args[]){
		
		CoachFrame frame = new CoachFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public JPanel addWelcome(){
		JPanel temp = new JPanel();
		JLabel welcomeUser = new JLabel("Welcome, " + "user" + "!");
		welcomeUser.setFont(new Font("Serif", Font.BOLD, 30));
		temp.add(welcomeUser);
		return temp;
	}
	
	public JPanel addAnnouncements(){
		JPanel temp = new JPanel();
		temp.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Announcements", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Serif", Font.PLAIN, 25)));
		
		JPanel announcementPanel = new JPanel();
		JTextArea announce = new JTextArea("Type to send an announcement to some/all users...");
		JButton sendAnnouncement = new JButton ("Announce!");
		announcementPanel.add(announce);
		announcementPanel.add(sendAnnouncement);
		
		temp.add(announcementPanel);
		return temp;
	}
	
	public JPanel addMessages(){
		JPanel temp = new JPanel();
		temp.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Messages",TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Serif", Font.PLAIN, 25)));
		
		JPanel messagePanel = new JPanel();
		JTextArea message = new JTextArea("Type to send a message to a user...");
		JButton sendMessage = new JButton ("Send!");
		messagePanel.add(message);
		messagePanel.add(sendMessage);
		
		temp.add(messagePanel);
		return temp;
	}
	
	public JPanel addMemLog(){
		JPanel temp = new JPanel();
		
		JButton memLog = new JButton("Member Log");
		
		temp.add(memLog);
		return temp;
	}
}
