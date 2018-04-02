import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class RegisterFrame extends JFrame{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 350;
	private static final int FRAME_HEIGHT = 360;
	private JTextField nameTextField;
	private JTextField lastTextField;
	private JTextField emailTextField;
	private JTextField passwordTextField;
	private JRadioButton userButton;
	private JRadioButton coachButton;
	private JRadioButton treasurerButton;
	
	public RegisterFrame(){
		new JPanel();
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
		this.nameTextField = namefield;
		this.lastTextField = lastfield;
		return panel;
	}
	
	public JPanel createEmailInput(){
		JPanel panel = new JPanel();
		JTextField emailfield = new JTextField("Enter an email");
		emailfield.setPreferredSize(new Dimension(200, 20));
		panel.add(emailfield);
		this.emailTextField = emailfield;
		return panel;
	}
	
	public JPanel createPasswordInput(){
		JPanel panel = new JPanel();
		JTextField passwordfield = new JTextField("Enter a password");
		passwordfield.setPreferredSize(new Dimension(200, 20));
		panel.add(passwordfield);
		this.passwordTextField = passwordfield;
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
		this.userButton = userradio;
		this.coachButton = coachradio;
		this.treasurerButton = treasurerradio;
		
		return panel;
	}
	
	public JPanel createButtons(){
		JPanel panel = new JPanel();
		JButton submit = new JButton("Submit");
		//button functionality
		submit.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		       System.out.println("Commencing Parsing");
		       //Parse everything to file
		       //call method with each jtextfield
		       parseString(nameTextField, lastTextField, emailTextField, passwordTextField);  
		    }
		});
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	//close the GUI
		    	System.out.println("SYSTEM TERMINATED");
		    	System.exit(0);
		    }
		});
		panel.add(submit);
		panel.add(cancel);
		return panel;
	}
	
	public void parseString(JTextField nameParse, JTextField lastParse, JTextField emailParse, JTextField passwordParse){
		try {
			String name = nameParse.getText();	
			String lastname = lastParse.getText();
			String email = emailParse.getText();
			String password = passwordParse.getText();
			PrintWriter writer = new PrintWriter(new FileWriter("LoginData.txt", true));
			//writer = new PrintWriter("SubmitedData.txt", "UTF-8");
			writer.println(name);
			writer.println(lastname);
			writer.println(email);
			writer.println(password);
			if (userButton.isSelected()){
				writer.println("user");
			}
			else if (coachButton.isSelected()){
				writer.println("Coach");
			}
			else if (treasurerButton.isSelected()){
				writer.println("Treasurer");
			}
			else{
				writer.println("Error");
			}
		
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
