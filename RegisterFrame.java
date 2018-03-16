import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class RegisterFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 350;
	private static final int FRAME_HEIGHT = 360;
	private JPanel panel;
	private JLabel labelN;
	
	public RegisterFrame(){
		panel = new JPanel();
		createRegister();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);	
	}
	
	
	public void createRegister(){
	//call methods to create pannels
		
	JPanel textPanel = createTextPanel();	
	JPanel inputPanel = createInputPanel();
	JPanel emailPanel = createEmailInput();
	JPanel passwordPanel = createPasswordInput();
	JPanel radioPanel = createRadio();
	JPanel buttonPanel = createButtons();
	JPanel regpanel = new JPanel();
	regpanel.setLayout(new GridLayout(6, 2));
	regpanel.add(textPanel);
	regpanel.add(inputPanel);
	regpanel.add(emailPanel);
	regpanel.add(passwordPanel);
	regpanel.add(radioPanel);
	regpanel.add(buttonPanel);
	add(regpanel, BorderLayout.NORTH);
	
	
	
	
	}
	
	public JPanel createTextPanel(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel("<html><b><u>Register an Account</u></b></html>");
		label.setFont(new Font("Serif", Font.PLAIN, 32));
		panel.add(label);
		return panel;
	}
	
	public JPanel createInputPanel(){
		JPanel panel = new JPanel();
		JTextField namefield = new JTextField("Enter first name");
		namefield.setPreferredSize(new Dimension(100, 20));
		JTextField lastfield = new JTextField("Enter last name");
		lastfield.setPreferredSize(new Dimension(100, 20));
		panel.add(namefield);
		panel.add(lastfield);
		return panel;
	}
	
	public JPanel createEmailInput(){
		JPanel panel = new JPanel();
		JTextField emailfield = new JTextField("Enter an email");
		emailfield.setPreferredSize(new Dimension(200, 20));
		panel.add(emailfield);
		return panel;
	}
	
	public JPanel createPasswordInput(){
		JPanel panel = new JPanel();
		JTextField passwordfield = new JTextField("Enter a password");
		passwordfield.setPreferredSize(new Dimension(200, 20));
		panel.add(passwordfield);
		return panel;
	}
	
	public JPanel createRadio(){
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Select a user type:");
		JRadioButton userradio = new JRadioButton("User");
		JRadioButton coachradio = new JRadioButton("Coach");
		JRadioButton treasurerradio = new JRadioButton("Treasurer");
		panel.add(label, BorderLayout.NORTH);
		panel.add(userradio, BorderLayout.SOUTH);
		panel.add(coachradio);
		panel.add(treasurerradio);
		return panel;
	}
	
	public JPanel createButtons(){
		JPanel panel = new JPanel();
		JButton submit = new JButton("Submit");
		JButton cancel = new JButton("Cancel");
		panel.add(submit);
		panel.add(cancel);
		return panel;
	}
	
}

