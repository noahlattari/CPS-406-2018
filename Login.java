import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame{

   private static final long serialVersionUID = 1L;
   private JLabel userLabel,passLabel,statusLabel;
   private JPanel controlPanel;
   private JTextField userText,passText;
   
   private Accounts account = new Accounts();
   private Person person = null;
   
   public Login(){
	   setTitle("Welcome");
	   setSize(400,230);
	   setLayout(new GridLayout(2, 1));
	        
	   controlPanel = new JPanel();
	   statusLabel = new JLabel("", JLabel.CENTER);
	   
	   add(controlPanel);
	   add(statusLabel);
	   
	   createLogin();
	   
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   setVisible(true);
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
      
      setVisible(true);  
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
				  		new MemberFrame(person);
				  		dispose();
				  	} 
				  	else if (person.getUserType().equals("coach")) {
				  		new CoachFrame(person);
				  		dispose();
				  	}
				  	else if (person.getUserType().equals("treasurer")) {
				  		new TreasurerFrame(person);
				  		dispose();
				  	}
			  	}
				else statusLabel.setText("Invalid email or password.");
			 
    		}
    		if(command.equals("Create"))
    		{
    			new RegisterFrame();
		  		dispose();
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