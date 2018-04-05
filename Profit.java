import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Profit {
	private double income, expenses, profit;
	ArrayList<Double>arr;
	
	public Profit(){
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
		if (in.hasNextLine()) in.nextLine();
		while(in.hasNextLine())
		{
			income+=(in.nextDouble());
			in.nextLine();
		}
		in.close();
	}
	public void readExpensesFile() throws FileNotFoundException{
		File file = new File("expenses.csv");
		Scanner in = new Scanner(file);
		in.useDelimiter(",");
		if (in.hasNextLine()) in.nextLine();
		while(in.hasNextLine())
		{
			expenses+=(in.nextDouble());
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
}
