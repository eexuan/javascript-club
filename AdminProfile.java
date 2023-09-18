import java.util.Scanner;

public class AdminProfile 
{
	private String username;
	private String password;
	
	public AdminProfile()
	{
		username = "ADMIN";
		password = "abcd12345";
	}
	
	public AdminProfile(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
	
	//accessor
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	//mutator
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	//instance method
	public void usernameInput()
	{
		char[] ch;
		boolean inRange = false;
		Scanner input = new Scanner(System.in);
	  	
		do
		{	
			int j = 0;
			boolean found = false;
			
			System.out.println("Enter new username (more than 4 characters): ");
			username = input.nextLine();
			ch = username.toCharArray();
			
			//store user password in character array
			while(j < ch.length && !found)
			{
				//System.out.println(ch[j]);
				if(((ch[j] >= 'A' && ch[j] <= 'Z') || (ch[j] >= 'a' && ch[j] <= 'z')) || Character.isDigit(ch[j]))
					inRange = true;
				else
					inRange = false;
				
				if(inRange)
					j++;
				else
					found = true;	
			}
			
			if(!inRange)
				System.out.println("Please enter alphabetical character and digit only.\n");
			
			if(ch.length < 5)
				System.out.println("Please enter more than 4 characters\n");	
			
			System.out.println();
		}while(!inRange || ch.length < 5);  	
		
		setUsername(username);
	}
	
	public void passwordInput()
	{
		char[] ch;
		boolean inRange = false;
		Scanner input = new Scanner(System.in);
		do
		{	
			int j = 0;
			boolean found = false;
			
			System.out.println("Enter a new eight characters password (alphabetical characters and digits only): ");
			password = input.nextLine();
			ch = password.toCharArray();
			
			//store user password in character array
			while(j < ch.length && !found)
			{
				//System.out.println(ch[j]);
				if(((ch[j] >= 'A' && ch[j] <= 'Z') || (ch[j] >= 'a' && ch[j] <= 'z')) || Character.isDigit(ch[j]))
				{
					inRange = true;
					//System.out.println("in Range");
				}
				else
				{
					inRange = false;
					//System.out.println("not in Range");
				}
				
				if(inRange)
				{
					j++;
					//System.out.println("is alphabet or space");
				}
				else
				{
					found = true;
					//System.out.println("not alphabet or space");
				}	
			}
			
			if(!inRange)
			{
				System.out.println("Please enter alphabetical character and digit only.");
			}
			
			if(ch.length < 8)
			{
				System.out.println("Please enter more than 7 characters");
			}		
			
			System.out.println();
		}while(!inRange || ch.length < 8);
		
		setPassword(password);
		//System.out.println(getPassword());
	}

}
