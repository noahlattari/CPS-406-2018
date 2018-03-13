import java.awt.*;
import javax.swing.*;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.*;

public class TreasurerFrame extends JFrame {
	
	private static final int FRAME_WIDTH = 400;
	private static final int FRAME_HEIGHT = 700;
	
	public TreasurerFrame() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		//get name using some method
		JLabel name = new JLabel("Name");
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=0.1;
		constraints.gridx=0;
		constraints.gridy=0;
		//constraints.gridwidth=2;
		add(name,constraints);
		
		JPanel incomePanel = createProfitPanel();
		//constraints.gridx=0;
		constraints.gridy=1;
		constraints.weighty=1;
		add(incomePanel,constraints);
		
		JPanel rmdPanel = createRmdPanel();
		//constraints.gridx=0;
		constraints.gridy=2;
		add(rmdPanel,constraints);
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	/**
	   Creates panel for profit.
	   @return the profit panel.
	 */
	public JPanel createProfitPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder());
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill=GridBagConstraints.BOTH;
		
		//(to be added) Read in messages and add to textArea. 
		JTextArea netProfitText = new JTextArea(5, 5);
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
	public JPanel createIncomePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EtchedBorder());
		
		JTextArea incomeText = new JTextArea(5,5);
		incomeText.setEditable(false);

		panel.add(incomeText);
		return panel;
	}
	
	
	/**
	   Creates panel for expenses.
	   @return the expense panel.
	 */
	public JPanel createExpensePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EtchedBorder());
		
		JTextArea expenseText = new JTextArea(5,5);
		expenseText.setEditable(false);

		panel.add(expenseText);
		return panel;
	}
	
	
	
	
	/**
	   Creates panel for reminders.
	   @return the reminder panel.
	 */
	public JPanel createRmdPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBorder(new EtchedBorder());
		
		//(to be added) Read in reminders and add to textArea. 
		JTextArea rmdArea = new JTextArea(15, 20);
		rmdArea.setEditable(false);
		
		panel.add(rmdArea);
		return panel;
	}
	
}