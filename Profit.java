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
			readFile();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		for (double element : arr){
			if (element>0){
				income+=element;
			}
			else if (element<0){
				expenses+=-(element);
			}
		}
		profit=income-expenses;
	}
	public void readFile() throws FileNotFoundException
	{
		int lines = 0;
		File file = new File("income.txt");
		Scanner in = new Scanner(file);
		while(in.hasNextLine())
		{
			arr.add(in.nextDouble());
		}
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
