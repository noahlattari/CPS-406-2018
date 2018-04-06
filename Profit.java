import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Profit {
	private double income, expenses, profit;
	private boolean validIncome, validExpense, numError;
	ArrayList<Double>arr;
	
	public Profit(){
		validIncome = true;
		validExpense = true;
		numError = false;
		arr= new ArrayList<Double>();
		income=0;
		expenses=0;
		try
		{
			readIncomeFile();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		try
		{
			readExpensesFile();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		/*for (double element : arr){
			if (element>0){
				income+=element;
			}
			else if (element<0){
				expenses+=-(element);
			}
		}*/
		profit=income-expenses;
	}
	public void readIncomeFile() throws FileNotFoundException
	{
		File file = new File("income.csv");
		Scanner in = new Scanner(file);
		in.useDelimiter(",");
		boolean incomePos = true;
		
		if (in.hasNextLine()) in.nextLine();
		while(in.hasNextLine() && validIncome)
		{
			double newIncome = in.nextDouble();
			if (newIncome < 0) {
				validIncome = false;
				numError = true;
			}
			else {
				income+=newIncome;
			}
			in.nextLine();
		}
		in.close();
	}
	public void readExpensesFile() throws FileNotFoundException{
		File file = new File("expenses.csv");
		Scanner in = new Scanner(file);
		in.useDelimiter(",");
		if (in.hasNextLine()) in.nextLine();
		while(in.hasNextLine() && validExpense)
		{
			double newExpense = in.nextDouble();
			if (newExpense < 0) {
				validExpense = false;
				numError = true;
			}
			else {
				expenses+=newExpense;
			}
			in.nextLine();
		}
		in.close();
	}
	public double getIncome(){
		return income;
	}
	public double getExpenses(){
		return expenses;
	}
	public double getProfit(){
		return profit;
	}
	public boolean isNumError() {
		return numError;
	}
	public boolean expenseIsValid() {
		return validExpense;
	}
	public boolean incomeIsValid() {
		return validIncome;
	}
}
