import java.time.LocalDate;
import java.util.Scanner;

public class MemberProfile 
{
	private String name;
	private String gender;
	private String id;
	private String contact;
	private String dateRegistered;
	private String password;
	
	// constructor
	public MemberProfile()
	{
		
	}
	
	public MemberProfile(String name, String gender, String id, String contact, 
			   			 String dateRegistered, String password)
	{
		this.name = name;
		this.gender = gender;
		this.id = id;
		this.contact = contact;
		this.dateRegistered = dateRegistered;
		this.password = password;
	}
	
	//accessor method
	public String getName()
	{
		return name;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public String getId()	
	{	
		return id;
	}
	
	public String getContact()
	{
		return contact;
	}
	
	public String getDateRegistered()	
	{
		return dateRegistered;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	//mutator method	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public void setGender(String aGender)
	{
		gender = aGender;	
	}
	
	public void setContact(String aContact)
	{
		contact = aContact;
	}
		
	public void setPassword(String aPassword)
	{
		password = aPassword;
	}
	
	//instance method
	public void getInput(User member)
	{
		char ans;
		boolean inRange = false;
		Scanner input = new Scanner(System.in);
		
		nameInput();
		generateGender();
		System.out.println();
		id = generateId(member);
		dateRegistered = generateDateRegistered();
		contactInput();
		passwordInput();
		
		System.out.println("Your profile is: ");
		displayProfile();
		
		System.out.println();
		do
		{
			System.out.print("Confirm your details? (y/n)");
			ans = Character.toLowerCase(input.next().charAt(0));
			
			if(Character.isAlphabetic(ans) && (ans == 'y' || ans == 'n'))
			{
				inRange = true;
				//System.out.println("true");
			}
			else
			{
				inRange = false;
				//System.out.println("false");
			}
			
			if(!inRange)
			{
				System.out.println("Invalid input");
				System.out.println();
			}
		}while(!inRange);
		
		System.out.println();
		if(ans == 'n')
		{
			editProfile();
		}
		
	}
	
	public void nameInput()
	{
		char[] ch;
		boolean inRange = false;
		Scanner input = new Scanner(System.in);
		do
		{	
			int j = 0;
			boolean found = false;
					
			System.out.print("Enter your name: ");
			name = input.nextLine();
			name = name.toUpperCase();		
			ch = name.toCharArray();
					
			//check name input
			while(j < ch.length && !found)	
			{	
				//System.out.println(ch[j]);
				if((Character.isAlphabetic(Character.valueOf(ch[j])) && (ch[j] >= 'A' && ch[j] <= 'Z')) || Character.isSpaceChar(ch[j]))
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
					
				if(!inRange )
				{	
					//System.out.println(!inRange);
					System.out.println("Please enter alphabetical characters or space only.");
					System.out.println();
				}	
			}while(!inRange);	
			setName(name);
			//System.out.println(getName());
			System.out.println();	
	}
	
	public void contactInput()
	{
		char[] ch;
		boolean isDigit = false;
		Scanner input = new Scanner(System.in);
		do
		{	
			int j = 0;
			boolean found = false;
			
			System.out.print("Enter your contact number (only digits): ");
			contact = input.nextLine();
			ch = contact.toCharArray();
			
			//check whether user input is digit
			while(j < ch.length && !found)
			{
				//System.out.println(ch[j]);
				if(!Character.isDigit(ch[j]))
				{
					found = true;
					isDigit = false;
					//System.out.println("is not Digit");
				}
				else
				{
					j++;
					isDigit = true;
					//System.out.println("is Digit");
				}
			}
			
			if(!isDigit)
			{
				System.out.println("Please enter numerical characers only");
			}
			
			if(ch.length < 9)
			{
				System.out.println("Please enter valid contact");
			}
			
		}while(!isDigit || ch.length < 9);
		
		setContact(contact);
		//System.out.println(getContact());
		System.out.println();
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
			
			System.out.println("Enter a eight characters password (alphabetical characters and digits only): ");
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
	
	public void generateGender()	
	{
		String gender;
		char g;
		Scanner input = new Scanner(System.in);
		
		do
		{	
			System.out.print("Choose your gender(m/f):");
			g = input.next().charAt(0);
			g = Character.toLowerCase(g);
			if(g != 'm' && g != 'f')
				System.out.println("Please enter valid character.");
		} while(g != 'm' && g != 'f');
		
		if(g == 'm')
			gender = "MALE";
		else
			gender = "FEMALE";
		
		setGender(gender);
	}

	public String generateId(User member)	
	{
		String id, year, idYear, idIndex; 
		int num;
		
		//first 2 digit of id
		LocalDate date = LocalDate.now();
		year = Integer.toString(date.getYear());
		idYear = year.substring(2);	
				
		//last 3 digit of id
		num = member.getNumberOfMembers();
		if(num < 10)
			idIndex = "00" + Integer.toString(num);
		else if(num < 100)
			idIndex = "0" + Integer.toString(num);
		else
			idIndex = Integer.toString(num);
				
		id = idYear + idIndex;
		return id;
	}
	
	public String generateDateRegistered()
	{
		LocalDate date = LocalDate.now();
		String year = Integer.toString(date.getYear());
		String day = Integer.toString(date.getDayOfMonth());
		String month = Integer.toString(date.getMonthValue());
		String registerDate = day + "-" + month + "-" + year;
		
		return registerDate;
	}
	
	public void editProfile()
	{
		char index, ans;
		boolean inRange, isValid;
		Scanner input = new Scanner(System.in);
	
		do
		{	
			do
			{
				System.out.println("Enter category that you wish to edit: ");
				System.out.println("(1) Name");
				System.out.println("(2) Gender");
				System.out.println("(3) Contact");
				System.out.println("(4) Password");
				System.out.print("Enter your option: ");
				index = input.next().charAt(0);
				//editIndex = Character.getNumericValue(index);
				System.out.println();
						
				if(index > '0' && index <= '4')
				{	
					inRange = true;
					//System.out.println("in range");
				}	
				else
				{
					inRange = false;
					//System.out.println("in range");
				}	
									
				if(!Character.isDigit(index) || !inRange)
				{
					System.out.println("Enter a valid number.");
					System.out.println();
				}					
			}while(!Character.isDigit(index) || !inRange);	
								
			if(index == '1')
				nameInput();
			else if(index == '2')
				generateGender();
			else if(index == '3')
				contactInput();
			else
				passwordInput();
			
			System.out.println("Your new profile details are: ");
			displayProfile();
			System.out.println();
			
			do
			{
				System.out.print("Are the details correct?(y/n) ");	
				ans = Character.toLowerCase(input.next().charAt(0));
				
				if(ans == 'y' || ans == 'n')
					isValid = true;
				else
					isValid = false;
				
				if(!Character.isAlphabetic(ans) || !isValid)
				{
					System.out.println("Please enter valid character.");
					System.out.println();
				}
			}while(!Character.isAlphabetic(ans) || !isValid);	
			System.out.println();
				
			if(ans == 'y')
				System.out.println("Your profile is successfully updated.");
			
		}while(ans == 'n');		
	}
	
	public void displayProfile()
	{
		System.out.println("Name: " + getName());
		System.out.println("Gender: " + getGender());
		System.out.println("Contact: " + getContact());
		System.out.println("Date registered: " + getDateRegistered());
		System.out.println("ID: " + getId());
		System.out.println("Password: " + getPassword());
	}
}
