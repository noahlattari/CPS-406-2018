
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 
 */
public class CoachFrame extends JFrame {

	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;

	public CoachFrame() {
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 0.01;
		constraints.gridx = 0;
		constraints.gridy = 0;
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		add(addWelcome(), constraints);
		constraints.gridy = 1;
		constraints.weighty = 0.33;
		add(addAnnouncements(), constraints);
		constraints.gridy = 2;
		add(addMessages(), constraints);
		constraints.gridy = 3;
		add(addMemLog(), constraints);
	}

	public static void main(String args[]) {

		CoachFrame frame = new CoachFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public JPanel addWelcome() {
		JPanel temp = new JPanel();
		JLabel welcomeUser = new JLabel("Welcome, " + "user" + "!");
		welcomeUser.setFont(new Font("Serif", Font.BOLD, 30));
		temp.add(welcomeUser);
		return temp;
	}

	public JPanel addAnnouncements() {
		JPanel temp = new JPanel();
		temp.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Announcements",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Serif", Font.PLAIN, 25)));

		JPanel announcementPanel = new JPanel();
		announcementPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 0.9;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		JTextArea announce = new JTextArea("Type to send an announcement to some/all users...");
		announce.setPreferredSize(new Dimension(370, 150));
		JButton sendAnnouncement = new JButton("Announce!");
		sendAnnouncement.addActionListener(new Announce(announce));
		announcementPanel.add(announce, constraints);
		constraints.weighty = 0.1;
		constraints.weightx = 0.25;
		constraints.gridy = 1;
		constraints.gridx = 3;
		constraints.gridwidth = 1;
		announcementPanel.add(sendAnnouncement, constraints);

		temp.add(announcementPanel);
		return temp;
	}

	public JPanel addMessages() {
		JPanel temp = new JPanel();
		temp.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(), "Messages",
				TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Serif", Font.PLAIN, 25)));

		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1;
		constraints.weighty = 0.9;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 4;
		JTextArea message = new JTextArea("Type to send a message to a user...");
		message.setPreferredSize(new Dimension(370, 150));
		messagePanel.add(message, constraints);
		JButton sendMessage = new JButton("Send!");
		constraints.weighty = 0.1;
		constraints.weightx = 0.25;
		constraints.gridy = 1;
		constraints.gridx = 3;
		constraints.gridwidth = 1;
		messagePanel.add(sendMessage, constraints);

		temp.add(messagePanel);
		return temp;
	}

	public JPanel addMemLog() {
		JPanel temp = new JPanel();
		JButton memLog = new JButton("Member Log");
		temp.add(memLog);
		return temp;
	}
	

	class Announce implements ActionListener{
		private JTextArea announcement;
		public Announce(JTextArea announce) {
			// TODO Auto-generated constructor stub
			this.announcement = announce;
		}
		public String getText(){
			return announcement.getText();
		}
		public void actionPerformed(ActionEvent e) {
			try {
				Announce temp = new Announce(announcement);
				PrintWriter out = new PrintWriter(new FileWriter("announcements.txt", true));
				out.println(temp.getText());
				out.println("");
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
