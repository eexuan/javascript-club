import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookingDetails 
{
	private String name;
	private String id;
	private String sport;
	private String day;
	private String time;
	private String roomNum;
	
	//constructor
	public BookingDetails()
	{

	}
	
	public BookingDetails(String sport)
	{
		this.sport = sport;
	}
	
	public BookingDetails(String day, String time, String roomNum)
	{
		this.day = day;
		this.time = time;
		this.roomNum = roomNum;
	}
	
	public BookingDetails(String sport, String day, String time, String roomNum)
	{
		this.sport = sport;
		this.day = day;
		this.time = time;
		this.roomNum = roomNum;
	}

	public BookingDetails(String name, String id, String sport, String day, String time, String roomNum)
	{
		this.name = name;
		this.id = id;
		this.sport = sport;
		this.day = day;
		this.time = time;
		this.roomNum = roomNum;		
	}

	public BookingDetails(User member, String sport, String day, String time, String roomNum)
	{
		this.name = member.getMemberInfo().getName();
		this.id = member.getMemberInfo().getId();
		this.sport = sport;
		this.day = day;
		this.time = time;
		this.roomNum = roomNum;
	}	
		
	//accessor method
	public String getName()
	{	
		return name;
	}
	
	public String getId()
	{
		return id;
	}
	
	public String getSport()
	{
		return sport;
	}
	
	public String getDay()
	{
		return day;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public String getRoomNum()
	{
		return roomNum;
	}
	
	//mutator method
	public void setSport(String sport)
	{
		this.sport = sport;
	}
	
	public void setDay(String day)
	{
		this.day = day;
	}
	
	public void setTime(String time)
	{
		this.time = time;
	}
	
	public void setRoomNum(String roomNum)
	{
		this.roomNum = roomNum;
	}
	
	//instance method
	
	public void sportInput()
	{
		Scanner input = new Scanner(System.in);	
		char[] ch;
		boolean found;
		
		do
		{
			System.out.print("Enter new sport name: ");
			sport = input.nextLine();
			ch = sport.toCharArray();
			
			int i = 0;
			found = false;
			while(i < ch.length && !found)
			{
				if(!Character.isAlphabetic(ch[i]))
				{
					found = true;
					System.out.println("Please enter valid alphabetical characters.\n");
				}
				else
					i++;
			}
		}while(found);
			
		setSport(sport.toUpperCase());	
	}
	
	public void dayInput()
	{
		Scanner input = new Scanner(System.in);	
		String temp;
		char[] ch;
		int index;
		boolean found;
		
		do
		{
			do
			{
				System.out.print("\nChoose a day: \n(1)Monday\n(2)Tuesday\n(3)Wednesday\n(4)Thursday\n(5)Friday\n(6)Saturday\n(7)Sunday\n");
				System.out.print("Enter your option: ");
				temp = input.nextLine();
				ch = temp.toCharArray();
				
				int i = 0;
				found = false;
				while(i < ch.length && !found)
				{
					if(!Character.isDigit(ch[i]))
					{
						found = true;
						System.out.println("Please enter valid digit character.");
					}
					else
						i++;
				}
				
			}while(found);
			
			index = Integer.parseInt(temp);
			
			if(index < 1 || index > 7)
				System.out.println("Please enter valid digit character.");	
		}while(index < 1 || index > 7);
		
		if(index == 1)
			day = "MONDAY";
		else if(index == 2)
			day = "TUESDAY";
		else if(index == 3)
			day = "WEDNESDAY";
		else if(index == 4)
			day = "THURSDAY";
		else if(index == 5)
			day = "FRIDAY";
		else if(index == 6)
			day = "SATURDAY";
		else
			day = "SUNDAY";
		
		setDay(day);
	}
	
	public void timeInput()
	{
		String time1, time2;
		char[] ch;
		boolean found;
		Scanner input = new Scanner(System.in);	
		
		do
		{	
			do
			{	
				System.out.print("\nEnter start time: ");
				time1 = input.nextLine();
				ch = time1.toCharArray();
				
				int i = 0;
				found = false;
				while(i < ch.length && !found)
				{
					if(Character.isDigit(ch[i]) || Character.isAlphabetic(ch[i]) || ch[i] == '.')
						i++;
					else
					{
						found = true;
						System.out.println("Please enter valid digit and alphebetical character\n");
					}
				}
				
			}while(found);	
			
			System.out.println(time1.length());
			if(time1.length() < 1 || time1.length() > 7)
				System.out.println("Please enter less than 8 characters");
			
		}while(time1.length() < 1 || time1.length() > 7);
		
		do
		{	
			do
			{	
				System.out.print("Enter end time: ");
				time2 = input.nextLine();
				ch = time2.toCharArray();
				
				int i = 0;
				found = false;
				while(i < ch.length && !found)
				{
					if(Character.isDigit(ch[i]) || Character.isAlphabetic(ch[i]) || ch[i] == '.')
						i++;
					else
					{
						found = true;
						System.out.println("Please enter valid digit and alphebetical character\n");
					}
				}
				
			}while(found);	
			
			
			if(time2.length() < 1 || time2.length() > 7)
				System.out.println("Please enter less than 8 characters\n");
		
		}while(time2.length() < 1 || time2.length() > 7);

		time = time1 + " - " + time2;
		
		setTime(time.toUpperCase());
	}
	
	public void roomNumInput()
	{
		char[] ch;
		boolean found;
		Scanner input = new Scanner(System.in);	
		
		do
		{	
			do
			{	
				System.out.print("\nEnter new room number: ");
				roomNum = input.nextLine();
				ch = roomNum.toCharArray();
				
				int i = 0; 
				found = false;
				while(i < ch.length && !found)
				{
					if(Character.isDigit(ch[i]) || Character.isAlphabetic(ch[i]))
						i++;
					else
					{
						found = true;
						System.out.println("Please enter valid digit and alphebetical character");
					}	
				}
			}while(found);
			
			if(roomNum.length() < 1 || roomNum.length() > 3)
				System.out.println("Please enter less than 4 characters.");			
		}while(roomNum.length() < 1 || roomNum.length() > 3);	
		
		setRoomNum(roomNum.toUpperCase());
	}
	

}
