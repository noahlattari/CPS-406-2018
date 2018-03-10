import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login {
   private JFrame mainFrame;
   private JLabel userLabel,passLabel;
   private JPanel controlPanel;
   private JTextField userText,passText;
   
   public Login(){
	   mainFrame = new JFrame("Welcome!");
	   mainFrame.setSize(400,200);
	   mainFrame.setLayout(new GridLayout(2, 1));
	        
	   controlPanel = new JPanel();

	   mainFrame.add(controlPanel,BorderLayout.CENTER);
	   mainFrame.setVisible(true); 
   }
   
   public static void main(String[] args){
	   Login log = new Login();
	   log.createLogin();       
   }
   
   private void createLogin(){
	  JPanel userPanel = new JPanel();
	  userLabel = new JLabel("Username: ");
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
      loginPanel.add(logButton);
      
      logButton.setActionCommand("Login");

      logButton.addActionListener(new ButtonClickListener());  
      
      controlPanel.add(userPanel);
      controlPanel.add(passPanel);
      controlPanel.add(loginPanel); 
      
      controlPanel.setLayout(new GridLayout(3, 1));
      
      mainFrame.setVisible(true);  
   }
   
   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
    	  
      }		
   }
}