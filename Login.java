//package memUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public JFrame mainFrame;
   private JLabel userLabel,passLabel,statusLabel;
   private JPanel controlPanel;
   private JTextField userText,passText;
   
   private Accounts account = new Accounts();
   private Person person = null;
   
   public Login(){
	   mainFrame = new JFrame("Welcome!");
	   mainFrame.setSize(400,200);
	   mainFrame.setLayout(new GridLayout(2, 1));
	        
	   controlPanel = new JPanel();
	   statusLabel = new JLabel("", JLabel.CENTER);
	   
	   mainFrame.add(controlPanel);
	   mainFrame.add(statusLabel);
	   mainFrame.setVisible(true); 
   }
   
   public static void main(String[] args){
	   Login log = new Login();
	   log.createLogin();       
	   RegisterFrame test = new RegisterFrame();
	   
   }
   
   public void setVis(){
	   mainFrame.setVisible(true);
   }
   
  public void createLogin(){
	  JPanel userPanel = new JPanel();
	  userLabel = new JLabel("      Email: ");
	  userText = new JTextField(15);
	  userPanel.add(userLabel);
	  userPanel.add(userText);
	  
	  JPanel passPanel = new JPanel();
	  passLabel = new JLabel("Password: ");
	  passText = new JTextField(15);
	  passPanel.add(passLabel);
	  passPanel.add(passText);
	  
	  JPanel loginPanel = new JPanel();
      JButton logButton = new JButton("Login");
	  JButton createButton = new JButton("Create Account");
      loginPanel.add(logButton);
	  loginPanel.add(createButton);
      
      logButton.setActionCommand("Login");
	  createButton.setActionCommand("Create");
      
      logButton.addActionListener(new ButtonClickListener());  
	  createButton.addActionListener(new ButtonClickListener());  
      
      controlPanel.add(userPanel);
      controlPanel.add(passPanel);
      controlPanel.add(loginPanel); 
      
      controlPanel.setLayout(new GridLayout(3, 1));
      
      mainFrame.setVisible(true);  
   }
   
   private class ButtonClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e) {
    	  	String command = e.getActionCommand(); 
    		if( command.equals( "Login" ))  {
    		  
    		  	boolean found = findAccount();
    		  	if (found) 
			  	{
				  	if (person.getUserType().equals("member")) {
				  		JFrame frame = new MemberFrame();
				  		frame.setVisible(true);
				  		mainFrame.dispose();
				  	} 
				  	else if (person.getUserType().equals("coach")) {
				  		JFrame frame = new CoachFrame();
				  		frame.setVisible(true);
				  		mainFrame.dispose();
				  	}
				  	else if (person.getUserType().equals("treasurer")) {
				  		JFrame frame = new TreasurerFrame();
				  		frame.setVisible(true);
				  		mainFrame.dispose();
				  	}
			  	}
				else statusLabel.setText("Invalid email or password.");
			 
    		}
    		if(command.equals("Create"))
    		{
    			JFrame frame = new RegisterFrame();
		  		frame.setVisible(true);
		  		mainFrame.dispose();
    		}
      }
   }
   
   private boolean findAccount()
   {   
	   if(account.findPerson(userText.getText(), passText.getText()) != null)
	   {
		   person = account.findPerson(userText.getText(), passText.getText());
	   }
	   if (person != null) return true;
	   else return false;
			 
   }

   
}