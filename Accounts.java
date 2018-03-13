import java.util.LinkedList ;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Accounts {
	private LinkedList<Person> list;
	private ArrayList<String> arr;
	private Person person;
	
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
			System.out.println(e);
		}
	}
	
	public void readContactFile() throws FileNotFoundException
	{
		int lines = 0;
		File file = new File("accounts.txt");
		Scanner in = new Scanner(file);
		while(in.hasNextLine())
		{
			lines++;
			String i = in.nextLine();
			arr.add(i);
		}
		if ((lines -1) % 5 != 0)
		{
			throw new IllegalArgumentException("Each contact must have 5 elements");
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
		int people = Integer.parseInt(arr.get(0));
		for(int i = 0; i < people; i++)
		{
			Person p = new Person(arr.get(1 + (i*5)),arr.get(2 + (i*5)),arr.get(3 + (i*5)),arr.get(4 + (i*5)),arr.get(5 + (i*5)));
			list.add(p);
		}
		
	}
}