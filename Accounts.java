import java.util.LinkedList ;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Accounts {
	private LinkedList<Person> list;
	private ArrayList<String> arr;
	private Person person;
	//private RegisterFrame registerFrame = new RegisterFrame();
	private int total = 0;
	public Accounts()
	{
		list = new LinkedList<Person>();
		arr= new ArrayList<String>();
		try
		{
			readContactFile();
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("e");
		}
	}
	
	public void readContactFile() throws FileNotFoundException
	{
		int lines = 0;
		File file = new File("Accounts.txt");
		Scanner in = new Scanner(file);
		while(in.hasNextLine())
		{
			lines++;
			String i = in.nextLine();
			arr.add(i);
		}
		if ((lines) % 5 != 0)
		{
			throw new IllegalArgumentException("Each account must have 5 elements");
		}
		accountInList();
	}
	
	public Person findPerson(String email, String pass)
	   {
		   person = new Person(null,null,email,pass,null);
		   for(Person p:list)
			{
				if(p.compareTo(person) == 0){
					return p;
				}
			}
		   return null;
	   }
	
	public void accountInList()
	{
		try
		{
			countLines();
		}
		
		catch(IOException e)
		{
			System.out.println("e");
		}
		//int people = Integer.parseInt(arr.get(0));
		int people = getTotal();
		for(int i = 0; i < people; i++)
		{
			Person p = new Person(arr.get(0 + (i*5)),arr.get(1 + (i*5)),arr.get(2 + (i*5)),arr.get(3 + (i*5)),arr.get(4 + (i*5)));
			list.add(p);
		}
		
	}
	public void countLines() throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("Accounts.txt"));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		total = lines/5 ;
		System.out.println(total);
	}
	
	public int getTotal(){
		return total;
	}
}
