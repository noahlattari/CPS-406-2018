import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.*;

public class TreasurerFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	private JTextArea netProfitText, incomeText, expenseText, rmdArea;
	private JButton scheduleButton, unpaidExpensesButton, advancedPaymentsButton, coachListButton;
	private Profit profit;
	private NumberFormat formatter;
	
	public TreasurerFrame() {
		profit = new Profit();
		formatter = new DecimalFormat("$#0.00");
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		//get name using some method
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=0.1;
		constraints.gridx=0;
		constraints.gridy=0;
		//constraints.gridwidth=2;
		add(addWelcome(),constraints);
		
		JPanel incomePanel = createProfitPanel();
		//constraints.gridx=0;
		constraints.gridy=1;
		constraints.weighty=1;
		add(incomePanel,constraints);
		
		JPanel rmdPanel = createBottomPanel();
		//constraints.gridx=0;
		constraints.gridy=2;
		add(rmdPanel,constraints);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private JPanel addWelcome(){
		JPanel temp = new JPanel();
		JLabel welcomeUser = new JLabel("Welcome, " + "user" + "!");
		welcomeUser.setFont(new Font("Serif", Font.BOLD, 30));
		temp.add(welcomeUser);
		return temp;
	}
	
	/**
	   Creates panel for profit.
	   @return the profit panel.
	 */
	private JPanel createProfitPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder());
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill=GridBagConstraints.BOTH;
		
		//(to be added) Read in messages and add to textArea. 
		netProfitText = new JTextArea(5, 5);
		netProfitText.setFont(new Font("Serif", Font.BOLD, 90));
		netProfitText.setText(formatter.format(profit.getProfit()));
		netProfitText.setEditable(false);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		constraints.weightx=1;
		constraints.weighty=0.5;
		panel.add(netProfitText,constraints);
		
		JPanel incomePanel = createIncomePanel();
		constraints.gridwidth=1;
		constraints.gridy=1;
		constraints.weighty=1;
		panel.add(incomePanel,constraints);
		JPanel expensePanel = createExpensePanel();
		constraints.gridx=1;
		panel.add(expensePanel,constraints);
		
		return panel;
	}
	
	/**
	   Creates panel for income.
	   @return the income panel.
	 */
	//might change so income and expenses panels are the same
	private JPanel createIncomePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EtchedBorder());
		
		incomeText = new JTextArea(5,5);
		incomeText.setEditable(false);
		incomeText.setFont(new Font("Serif", Font.BOLD, 40));
		incomeText.setText(formatter.format(profit.getIncome()));
		incomeText.setEditable(false);

		panel.add(incomeText);
		return panel;
	}
	
	
	/**
	   Creates panel for expenses.
	   @return the expense panel.
	 */
	private JPanel createExpensePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EtchedBorder());
		
		expenseText = new JTextArea(5,5);
		expenseText.setEditable(false);
		expenseText.setFont(new Font("Serif", Font.BOLD, 40));
		expenseText.setText(formatter.format(profit.getExpenses()));
		expenseText.setEditable(false);

		panel.add(expenseText);
		return panel;
	}
	
	
	
	
	/**
	   Creates panel for reminders.
	   @return the reminder panel.
	 */
	private JPanel createBottomPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder());
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=0.01;
		constraints.gridx=0;
		constraints.gridy=0;
		panel.add(createButtons(),constraints);
		
		
		//(to be added) Read in reminders and add to textArea. 
		rmdArea = new JTextArea(15, 20);
		rmdArea.setEditable(false);
		constraints.gridwidth=4;
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.weightx=1;
		constraints.weighty=0.99;
		panel.add(rmdArea,constraints);
		return panel;
	}
	
	private JPanel createButtons(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		//buttons need to switch between different pages
		
		unpaidExpensesButton = new JButton("Unpaid Expenses");
		unpaidExpensesButton.setActionCommand("Unpaid");
		unpaidExpensesButton.addActionListener(new ButtonClickListener());
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=0.25;
		constraints.weighty=1;
		constraints.gridx=0;
		constraints.gridy=0;
		panel.add(unpaidExpensesButton,constraints);
		
		advancedPaymentsButton = new JButton("Prepaid");
		advancedPaymentsButton.setActionCommand("Prepaid");
		advancedPaymentsButton.addActionListener(new ButtonClickListener());
		constraints.gridx=1;
		panel.add(advancedPaymentsButton,constraints);
		coachListButton = new JButton("Coaches");
		coachListButton.setActionCommand("Coaches");
		coachListButton.addActionListener(new ButtonClickListener());
		constraints.gridx=2;
		panel.add(coachListButton,constraints);
		scheduleButton = new JButton("Schedule");
		scheduleButton.setActionCommand("Schedule");
		scheduleButton.addActionListener(new ButtonClickListener());
		constraints.gridx=3;
		panel.add(scheduleButton,constraints);
		return panel;
	}
	
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand(); 
	    	if( command.equals( "Unpaid" ))  {
	    		rmdArea.setText("Unpaid"); //make getUnpaid, Prepaid, Coaches and Schedule methods
	    		//need to change background of button when clicked.
	        }
	    	else if (command.equals("Prepaid")){
	    		rmdArea.setText("Prepaid");
	    	}
	    	else if (command.equals("Coaches")){
	    		rmdArea.setText("Coaches");
	    	}
	    	else if (command.equals("Schedule")){
	    		rmdArea.setText("Schedule");
	    	}
	    }		
	}
	
	
}