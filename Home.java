import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Home 
{
	public static void main(String[] args)
	{
		String temp;
		char ans;
		boolean isValid;
		
		Scanner input = new Scanner(System.in);
		
		do
		{
			do
			{
				isValid = false;
				
				System.out.println("******************** Xtreme Sports Club ********************");
				System.out.println("(1) Member");
				System.out.println("(2) Admin");
				System.out.println("(3) Exit");
				System.out.println();
			
				
				System.out.print("Enter your option: ");
				temp = input.nextLine();
				System.out.println();
				
				if(temp.length() != 1)
				{
					isValid = false;
					System.out.println("Please enter valid digit character.\n");
				}
				else
					isValid = true;
			}while(!isValid);	
			
			ans = temp.charAt(0);
			switch(ans)
			{
				case '1': 	memberPage();
							break;
				case '2': 	adminPage();	
							adminHome();
							break;
				case '3': 	break;
				default:	System.out.println("Please enter valid digit character.\n");
			}
			
		} while(!Character.isDigit(ans) || ans != '3');	
		
		input.close();
	}
	
	public static void memberPage()
	{
		char ans;
		String temp, id;
		boolean isValid;
		
		User user = new User();
		File file = new File("MemberList.txt");
		if(file.exists())
			readMemberFile(user);
		
		Scanner input = new Scanner(System.in);
		
		do
		{
			do
			{
				isValid = false;	
				
				System.out.println("******************** Member Page ********************");
				System.out.println("(1) Member Login");
				System.out.println("(2) Member Register");
				System.out.println("(3) Exit");
				System.out.println();
				System.out.print("Enter your option: ");
				temp = input.nextLine();
				System.out.println();
				
				if(temp.length() != 1)
				{
					isValid = false;
					System.out.println("Please enter valid character.\n");
				}
				else
					isValid = true;
			}while(!isValid);	
		
			ans = temp.charAt(0);			
			switch(ans)
			{
				case '1': 	if(file.exists())
							{
								memberLogin(user);
								homePage(user);	
							}
							else
								System.out.println("No member found.\n");
							break;
				case '2': 	memberRegister(user);
							storeMemberList(user);
							break;
				case '3':	break;
				default: 	System.out.println("Please enter valid digit character.\n");
			}	
		} while(!Character.isDigit(ans) || ans != '3');
	}
	
	public static User memberLogin(User user)
	{
		String id, password;
		int index = 0;
		boolean isValid = false;
		MemberProfile m = null;
		MemberProfile[] memberList = user.getMemberList();
		Scanner input = new Scanner(System.in);
		
		System.out.println("******************** Member Login ********************");
		
		//verify input id
		do
		{
			System.out.print("Enter id: ");		
			id = input.nextLine();
			
			int i = 0;
			boolean found = false;
			while(i < user.getNumberOfMembers() && !found)
			{
				//System.out.println(memberList[i].getId());
				if(!memberList[i].getId().equals(id))
				{
					i++;
					isValid = false;
					//System.out.println("not valid");
				}
				else
				{
					found = true;
					isValid = true;
					index = i;
					//System.out.println("valid");
				}		
			}	
			
			if(!isValid)
			{
				System.out.println("Invalid id");
				System.out.println();
			}
		}while(!isValid);	
		
		System.out.println();
		//verify input password
		do
		{
			System.out.print("Enter password: ");		
			password = input.nextLine();
			
			int i = 0;
			boolean found = false;
			while(i < user.getNumberOfMembers() && !found)
			{
				//System.out.println(memberList[i].getPassword());
				if(!memberList[i].getPassword().equals(password))
				{
					i++;
					isValid = false;
				}
				else
				{
					found = true;
					isValid = true;
				}
			}
			
			if(!isValid)
			{
				System.out.println("Invalid password");
				System.out.println();
			}
		}while(!isValid);
		
		if(isValid)
		{
			m = new MemberProfile(memberList[index].getName(), memberList[index].getGender(), memberList[index].getId(),
										memberList[index].getContact(), memberList[index].getDateRegistered(),memberList[index].getPassword());
		}
		user.getMemberInfo(m);
		return user;
	}
	
	public static void homePage(User user)
	{
		char ans;
		String temp;
		boolean isValid;
		Booking details = new Booking();
		
		Scanner input = new Scanner(System.in);
		
		File file1 = new File("SportList.txt");
		if(file1.exists())
			readDetailsFile(details);
		else
			System.out.println("SportList File does not exist");
		
		File file2 = new File("BookingList.txt");
		if(file2.exists())
			readBookingFile(details);
		else
			System.out.println("Booking List File does not exist");	

		do
		{
			do
			{
				isValid = false;
			
				System.out.println("******************** Home ********************");
				System.out.println("(1) Booking details");
				System.out.println("(2) Create booking");
				System.out.println("(3) Update booking");
				System.out.println("(4) Delete booking");
				System.out.println("(5) View booking");
				System.out.println("(6) Search booking");
				System.out.println("(7) View Profile");
				System.out.println("(8) Edit profile");
				System.out.println("(9) Exit");
				System.out.println();
				System.out.print("Enter your option: ");
				temp = input.nextLine();
				System.out.println();
				
				if(temp.length() != 1)
				{
					isValid = false;
					System.out.println("Please enter valid character.");
				}
				else
					isValid = true;
			}while(!isValid);
			
			ans = temp.charAt(0);			
			switch(ans)
			{
				case '1': 	if(!file2.exists())
								displayDetailsList(details);
							else
							{
								details.clearBookingList();
								readBookingFile(details);
								checkAvailableSlot(details);
								displayAvailableList(details);
							}
							break;
				case '2': 	if(file2.exists())
							{
								details.clearBookingList();
								readBookingFile(details);
							}
							checkAvailableSlot(details);
							details.createBooking(user);
							storeBookingList(details);
							break;
				case '3':	if(file2.exists())
							{
								details.updateBooking(user);
								storeBookingList(details);
							}	
							else
							{
								System.out.println("Your booking is empty");
								ans = '1';
							}
							break;
				case '4':	if(file2.exists())
							{
								details.deleteABooking(user);	
								storeBookingList(details);
							}
							else
							{
								System.out.println("Your booking is empty");
								ans = '1';
							}
							break;
				case '5':	if(file2.exists())
							{
								details.clearBookingList();
								readBookingFile(details);
								viewBookedList(details, user);
							}	
							else
							{
								System.out.println("Your booking is empty");
								ans = '1';
							}
							break;
				case '6':	if(file2.exists())
							{
								details.clearBookingList();
								readBookingFile(details);
								details.searchBooking(user);
							}	
							else
							{
								System.out.println("Your booking is empty");
								ans = '1';
							}
							break;
				case '7':	user.getMemberInfo().displayProfile();
							break;
				case '8': 	editMemProfile(user);
							break;			
				case '9': 	break;
							default: System.out.println("Please enter valid digit characters.\n");
			}	
		} while(!Character.isDigit(ans) || ans != '9');	
	}
	
	public static void readDetailsFile(Booking details)
	{
		String sport, roomNum, day, time;
		
		try
		{
			File text = new File("SportList.txt");
			Scanner input = new Scanner(text);
			while(input.hasNextLine())
			{
				sport = input.nextLine();
				day = input.nextLine();
				time = input.nextLine();
				roomNum = input.nextLine();
				BookingDetails b = new BookingDetails(sport, day, time, roomNum);
				details.recordADetail(b);
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
	
	public static void displayDetailsList(Booking details)
	{
		BookingDetails[] detailsList = details.getDetailsList();
		for(int i = 0; i < detailsList.length; i++)
		{
			System.out.print((i + 1) + ". ");
			System.out.printf("SPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s", detailsList[i].getSport(), detailsList[i].getDay(),
								detailsList[i].getTime(), detailsList[i].getRoomNum());
			System.out.println();
		}
	}

	public static void checkAvailableSlot(Booking details)
	{	
		int bookCount = details.getNumberOfBooking();
		boolean found;
		BookingDetails[] detailsList = details.getDetailsList();
		BookingDetails[] bookingList = details.getBookingList();
		ArrayList<BookingDetails> temp = new ArrayList<BookingDetails>();
		
		//store detailsList into temp
		for(int i = 0; i < details.getNumberOfDetails(); i++)
		{
			BookingDetails slot = new BookingDetails(detailsList[i].getSport(), detailsList[i].getDay(),
														detailsList[i].getTime(), detailsList[i].getRoomNum());
			temp.add(slot);
		}
		
		for(int i = 0; i < bookCount; i++)
		{
			for(int j = 0; j < temp.size(); j++)
			{
				if(temp.get(j) != null)
				{
					for(int k = 0; k < details.getNumberOfBooking(); k++)
					{
						
						if(temp.get(j).getSport().equals(bookingList[k].getSport()) 
								&& temp.get(j).getDay().equals(bookingList[k].getDay())
								&& temp.get(j).getTime().equals(bookingList[k].getTime())
								&& temp.get(j).getRoomNum().equals(bookingList[k].getRoomNum()))
						{
							
							temp.remove(j);
							found = true;
							k = details.getNumberOfBooking();
							j = temp.size();
									
						}
							
					}	
				}
				
			}
		}
		
		//clear original array 
		details.clearSlotList();
		
		//store in new arrayList
		for(int i = 0; i < temp.size(); i++)
		{
			BookingDetails slot = new BookingDetails(temp.get(i).getSport(), temp.get(i).getDay(),
													temp.get(i).getTime(), temp.get(i).getRoomNum());
			details.recordASlot(slot);
		}
	}	
	
	public static void displayAvailableList(Booking details)
	{
		BookingDetails[] newSlot = details.getAvailableSlot();	
		for(int i = 0; i < newSlot.length; i++)
		{
			System.out.print((i + 1) + ". ");
			System.out.printf("SPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s\n", newSlot[i].getSport(), newSlot[i].getDay(),
								newSlot[i].getTime(), newSlot[i].getRoomNum());
		}
	}
	
	public static void storeBookingList(Booking details)
	{
		BookingDetails[] bookingList = details.getBookingList();
		try
		{
			FileWriter text = new FileWriter("BookingList.txt");
			for(int i = 0; i < details.getNumberOfBooking(); i++)
			{
				if(bookingList[i] != null)
				{	
					text.write(bookingList[i].getName() + "\n");
					text.write(bookingList[i].getId() + "\n");
					text.write(bookingList[i].getSport() + "\n");
					text.write(bookingList[i].getDay() + "\n");
					text.write(bookingList[i].getTime() + "\n");
					text.write(bookingList[i].getRoomNum() + "\n");
				}
			}
			text.close();
			System.out.println("Successfully written");
		}
		catch(IOException e)
		{
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	}	
	
	public static void viewBookedList(Booking details, User member) 
	{
		int index = 1;
		
		BookingDetails[] bookedList = details.getBookingList();
		System.out.println("The sport(s) you have booked: ");
		System.out.println();
		for(int i = 0; i < bookedList.length; i++)
		{
			if (bookedList[i].getId().equals(member.getMemberInfo().getId()))
			{
				System.out.print(index + ". ");
				System.out.printf("SPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s", bookedList[i].getSport(),
									bookedList[i].getDay(), bookedList[i].getTime(), bookedList[i].getRoomNum());
				System.out.println();	
				
				index++;
			}
		}
	}
	
	public static void editMemProfile(User member)
	{
		MemberProfile[] memberList = member.getMemberList();
		for(int i = 0; i < member.getNumberOfMembers(); i++)
		{
			if(memberList[i] != null)
			{
				if(memberList[i].getId().equals(member.getMemberInfo().getId()))
					memberList[i].editProfile();
			}
		}
		storeMemberList(member);
	}
	
	public static void memberRegister(User user)
	{
		System.out.println("******************** Register Page ********************");
		
		MemberProfile profile = new MemberProfile();
		profile.getInput(user);
		
		user.register(profile);
	}
	
	public static void storeMemberList(User user)
	{
		MemberProfile[] memberList = user.getMemberList();
		
		try
		{
			FileWriter text = new FileWriter("MemberList.txt");
			for(int i = 0; i < user.getNumberOfMembers(); i++)
			{
				if(memberList[i] != null)
				{	
					text.write(memberList[i].getName() + "\n");
					text.write(memberList[i].getGender() + "\n");
					text.write(memberList[i].getId() + "\n");
					text.write(memberList[i].getContact() + "\n");
					text.write(memberList[i].getDateRegistered() + "\n");
					text.write(memberList[i].getPassword() + "\n");
				}
			}
			text.close();
			//System.out.println("Successfully written");		//Delete later
		}
		catch(IOException e)
		{
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	}
	
	public static void adminPage()
	{
		String username, password;
		boolean foundUsername = false, foundPass = false;
		User admin = new User();
		Scanner input = new Scanner(System.in);
		
		File file = new File("AdminProfile.txt");
		if(file.exists())
			readAdminProfile(admin);
		else
			System.out.println("AdminProfile textfile does not exists");
		
		System.out.println("******************** Admin Page ********************");
		
		//verify admin username
		do
		{
			System.out.print("Enter username: ");		
			username = input.nextLine();
			
			//System.out.println(memberList[i].getId());
			if(!admin.getAdminInfo().getUsername().equals(username))
			{
				foundUsername = false;
				//System.out.println("not valid");
			}
			else
			{
				foundUsername = true;
				//System.out.println("valid");	
			}	
			
			if(!foundUsername)
			{
				System.out.println("Invalid username");
				System.out.println();
			}
		}while(!foundUsername);
		
		System.out.println();
		//verify admin password
		do
		{
			System.out.print("Enter password: ");
			password = input.nextLine();
			
			//System.out.println(memberList[i].getId());
			if(!admin.getAdminInfo().getPassword().equals(password))
			{
				foundPass = false;
				//System.out.println("not valid");
			}
			else
			{
				foundPass = true;
				//System.out.println("valid");
						
			}	
			
			if(!foundPass)
			{
				System.out.println("Invalid username");
				System.out.println();
			}
		}while(!foundPass);
		
	}
	
	public static void adminHome()
	{
		char ans;
		String temp;
		boolean isValid;
		Scanner input = new Scanner(System.in);
		
		Booking details = new Booking();
		User mem = new User();
		
		File file1 = new File("SportList.txt");
		if(file1.exists())
			readDetailsFile(details);
		else
			System.out.println("SportList File does not exist");
		
		File file2 = new File("BookingList.txt");
		if(file2.exists())
			readBookingFile(details);
		else
			System.out.println("BookingList File does not exist");
		
		File file3 = new File("MemberList.txt");
		if(file3.exists())
			readMemberFile(mem);
		else
			System.out.println("MemberList File does not exist");		
		
		do
		{
			do
			{
				isValid = false;
			
			System.out.println("******************** Admin Home ********************");
			System.out.println("(1) View booking details");
			System.out.println("(2) Create a booking detail");
			System.out.println("(3) Delete booking details");
			System.out.println("(4) Search a member's booking");
			System.out.println("(5) View member's booking list");
			System.out.println("(6) View member list");
			System.out.println("(7) Search member");
			System.out.println("(8) Edit profile");
			System.out.println("(9) Exit");
			System.out.println();
			System.out.print("Enter your option: ");
			temp = input.nextLine();
			System.out.println();
			
			if(temp.length() != 1)
			{
				isValid = false;
				System.out.println("Please enter valid character.");
			}
			else
				isValid = true;
			}while(!isValid);
		
			ans = temp.charAt(0);				
			switch(ans)
			{
				case '1': 	displayDetailsList(details);
							break;
				case '2':	details.createADetail();	
							storeBookingDetails(details);
							break;	
				case '3':	displayDetailsList(details);
							details.deleteADetail();
							storeBookingDetails(details);
							break;
				case '4':	details.searchAMemberBooking();
							break;
				case '5':	displayBookingList(details);	
							break;
				case '6':	displayMemberList(mem);
							break;
				case '7':	searchMember(mem);
							break;
				case '8':	editAdminProfile();
							break;
				case '9': 	break;
				default: 	System.out.println("Invalid input");
			}	
		} while(!Character.isDigit(ans) || ans != '9');	
		
	}
	
	public static void readBookingFile(Booking details)
	{
		String name, id, sport, roomNum, day, time;
		
		try
		{
			File text = new File("BookingList.txt");
			Scanner input = new Scanner(text);
			while(input.hasNextLine())
			{
				name = input.nextLine();
				id = input.nextLine();
				sport = input.nextLine();
				day = input.nextLine();
				time = input.nextLine();
				roomNum = input.nextLine();
				BookingDetails b = new BookingDetails(name, id, sport, day, time, roomNum);
				details.recordABooking(b);
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
	
	public static void readMemberFile(User mem)
	{
		String name, gender, id, contact, dateRegistered, password;
		
		try
		{
			File text = new File("MemberList.txt");
			Scanner input = new Scanner(text);
			while(input.hasNextLine())
			{
				name = input.nextLine();
				gender = input.nextLine();
				id = input.nextLine();
				contact = input.nextLine();
				dateRegistered = input.nextLine();
				password = input.nextLine();
				MemberProfile profile = new MemberProfile(name, gender, id, contact,  
														dateRegistered, password);
				mem.register(profile);
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}
	
	public static void storeBookingDetails(Booking details)
	{
		BookingDetails[] bookingDetails = details.getDetailsList();
		try
		{
			FileWriter text = new FileWriter("SportList.txt");
			for(int i = 0; i < details.getNumberOfDetails(); i++)
			{
				if(bookingDetails[i] != null)
				{	
					text.write(bookingDetails[i].getSport() + "\n");
					text.write(bookingDetails[i].getDay() + "\n");
					text.write(bookingDetails[i].getTime() + "\n");
					text.write(bookingDetails[i].getRoomNum() + "\n");
				}
			}
			text.close();
			System.out.println("Successfully written");
		}
		catch(IOException e)
		{
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	}
	
	public static void displayBookingList(Booking details)
	{
		BookingDetails[] bookingList = details.getBookingList();
		for(int i = 0; i < bookingList.length; i++)
		{
			System.out.print((i + 1) + ". ");
			System.out.printf("NAME: %-25s\tID: %-8sSPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s", bookingList[i].getName(),
								bookingList[i].getId(), bookingList[i].getSport(), bookingList[i].getDay(), bookingList[i].getTime(),
								bookingList[i].getRoomNum());
			System.out.println();
		}
	}	
	
	public static void displayMemberList(User user)
	{
		MemberProfile[] memberList = user.getMemberList();
		System.out.println("List of members:");
		for(int i = 0; i < user.getNumberOfMembers(); i++)
		{
			if(memberList[i] != null)
			{	
				System.out.print(i + 1 + ". ");
				System.out.printf("NAME: %-25s\tGENDER: %-9sID: %-8sCONTACT NUMBER: %-15sDATE REGISTERED: %-12s", 
									memberList[i].getName(), memberList[i].getGender(), memberList[i].getId(), 
									memberList[i].getContact(), memberList[i].getDateRegistered());
			}	
		}
		System.out.println();
	}
	
	public static void searchMember(User mem)
	{
		String id;
		boolean found = false;	
		Scanner input = new Scanner(System.in);	
		MemberProfile[] memberList = mem.getMemberList();
		
		System.out.print("Enter the member's Id that you wish to search: ");
		id = input.nextLine();
			
		for(int i = 0; i < memberList.length; i++)
		{
			if(memberList[i] != null)
			{
				if(memberList[i].getId().equals(id))
				{
					System.out.println("The member's details is: ");
					System.out.printf("Name: %s\nGender: %s\nContact: %s\nDate Registered: %s\n\n", memberList[i].getName(), memberList[i].getGender(),
										memberList[i].getContact(), memberList[i].getDateRegistered());
					found = true;
					i = memberList.length;
				}
				else
					found = false;	
			}
		}	
			
		if(!found)
			System.out.println("Invalid id.\n");
	}
	
	public static void editAdminProfile()
	{
		char ans;
		boolean inRange;
		String username, password;
		User admin = new User();
		Scanner input = new Scanner(System.in);
		
		do
		{
			System.out.println("Edit which component?");
			System.out.println("(1) Username");
			System.out.println("(2) Password");
			System.out.println("Enter your option: ");
			ans = input.next().charAt(0);
			
			switch(ans)
			{
				case '1':	admin.getAdminInfo().usernameInput();
						  	break;
				case '2': 	admin.getAdminInfo().passwordInput();
							break;
				default: 	System.out.println("Please enter valid digit character.");		
			}
			
			if(ans == '1' || ans == '2')
				inRange = true;
			else
				inRange = false;
		}while(!Character.isDigit(ans) || !inRange);
		
		System.out.println(admin.getAdminInfo().getUsername());
		System.out.println(admin.getAdminInfo().getPassword());
		
		storeAdminProfile(admin);
	}
	
	public static void storeAdminProfile(User user)
	{	
		try
		{
			FileWriter text = new FileWriter("AdminProfile.txt");
			text.write(user.getAdminInfo().getUsername() + "\n");
			text.write(user.getAdminInfo().getPassword() + "\n");
			text.close();
			System.out.println("Successfully written");
		}
		catch(IOException e)
		{
			System.out.println("An error has occured.");
			e.printStackTrace();
		}	
	}
	
	public static void readAdminProfile(User user)
	{
		String username, password;
		
		try
		{
			File text = new File("AdminProfile.txt");
			Scanner input = new Scanner(text);
			while(input.hasNextLine())
			{
				username = input.nextLine();
				password = input.nextLine();
				user.getAdminInfo().setUsername(username);
				user.getAdminInfo().setPassword(password);
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("An error has occured");
			e.printStackTrace();
		}
	}

}
