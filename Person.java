import java.util.Comparator;

public class Person implements Comparable<Person> 
{
	private String first;
	private String last;
	private String email;
	private String password;
	private String userType;
	
	public Person(String first, String last, String email, String password, String userType)
	{
		this.first = first;
		this.last = last;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	
	public String getFirst()
	{
		return this.first;
	}
	
	public String getLast()
	{
		return this.last;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	
	public String getPassword()
	{
		return this.password;
	}
	
	public String getUserType()
	{
		return this.userType;
	}
	
	public int compareTo(Person other)
	{
		if(this.password.equals(other.password))
			return this.email.compareTo(other.email);
		else return this.password.compareTo(other.password);
	}
}