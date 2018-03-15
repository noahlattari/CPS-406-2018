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
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		add(addWelcome());
		add(addAnnouncements());
		add(addMessages());
		add(addMemLog());
		setLayout(new GridLayout(4, 1));
	}
	
	public static void main(String args[]){
		
		CoachFrame frame = new CoachFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

	public JPanel addWelcome(){
		JPanel temp = new JPanel();
		JLabel welcomeUser = new JLabel("Welcome, " + "user" + "!");
		temp.add(welcomeUser);
		return temp;
	}
	
	public JPanel addAnnouncements(){
		JPanel temp = new JPanel();
		temp.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Announcements"));
		
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
		temp.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Messages"));
		
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
