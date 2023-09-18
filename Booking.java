import java.util.ArrayList;
import java.util.Scanner;

public class Booking 
{
	private static ArrayList<BookingDetails> detailsList;
	private static ArrayList<BookingDetails> bookingList;
	private static ArrayList<BookingDetails> availableSlot;
	
	//constructor
	public Booking()
	{
		detailsList = new ArrayList<BookingDetails>();
		bookingList = new ArrayList<BookingDetails>();	
		availableSlot = new ArrayList<BookingDetails>();
	}
	
	//DetailsList
	public void recordADetail(BookingDetails details)
	{
		detailsList.add(details);
	}
	
	public void rearrangeDetail(BookingDetails newDetails)
    {
        boolean found = false;
		String newSport = newDetails.getSport();
        
        for(int i=0; i<detailsList.size(); i++)
        {
            String sportInList = detailsList.get(i).getSport().toUpperCase();
            if (newSport.equals(sportInList))
            {
                for(int j=i+1; j<detailsList.size(); j++)
                {
                	sportInList = detailsList.get(j).getSport().toUpperCase();
                	if (!newSport.equals(sportInList))
                	{
                		detailsList.add(j, newDetails);
                		j = detailsList.size();
                	}
                }
                found = true;
                i = detailsList.size();
            }
        }
        
        if(!found)
        	recordADetail(newDetails);
    }
	
	public int getNumberOfDetails()
	{
		return detailsList.size();
	}
	
	public BookingDetails[] getDetailsList()
	{
		BookingDetails[] d = new BookingDetails[detailsList.size()];
		for(int i = 0; i < d.length; i++)
			d[i] = detailsList.get(i);
		
		return d;
	}
	
	public void createADetail()
	{
		char ans, index;
		int editIndex;
		boolean inRange, found;
		Scanner input = new Scanner(System.in);
		
		BookingDetails b = new BookingDetails();
		BookingDetails[] booking = getDetailsList();
		
		do
		{	
			b.sportInput();
			b.dayInput();
			b.timeInput();
			b.roomNumInput();
			
			//check whether details already exists 
			int i = 0;
			found = false;
			while(i < booking.length && !found)
			{
				if(booking[i].getSport().equals(b.getSport()) && booking[i].getDay().equals(b.getDay())
					&& booking[i].getTime().equals(b.getTime()) && booking[i].getRoomNum().equals(b.getRoomNum()))
					found = true;
				else
				{
					found = false;
					i++;
				}
			}
		
			if(found)
			{
				System.out.println("The booking is already exists");
				System.out.println();
			}
			else
			{
				System.out.println();
				System.out.println("The new slot is: ");
				System.out.println("Sport: " + b.getSport() + "\t Day: " + b.getDay() + "\t Time: " + b.getTime() + "\t Room number: " + b.getRoomNum());
			}
		}while(found); 		
				
		do
		{
			System.out.println();
			System.out.print("Are you confirm to add this new slot?(y/n) ");	
			ans = Character.toLowerCase(input.next().charAt(0));
			System.out.println();
					
			if(ans == 'y')
			{	
				rearrangeDetail(b);			
			}
					
			if(ans == 'y'|| ans == 'n')
				inRange = true;
			else
				inRange = false;
		
					
			if(!Character.isAlphabetic(ans) || !inRange)
				System.out.println("Please enter valid character.\n");
		}while(!Character.isAlphabetic(ans) || !inRange);	
					
		//Edit details
		if(ans == 'n')
		{	
			do
			{	
				do
				{
					System.out.println("Enter category that you wish to edit: ");
					System.out.println("(1) Sport");
					System.out.println("(2) Day");
					System.out.println("(3) Time");
					System.out.println("(4) Room number");
					System.out.print("Enter your option: ");
					index = input.next().charAt(0);
					editIndex = Character.getNumericValue(index);
					System.out.println();
								
					if(index > '0' && index <= '4')
						inRange = true;
					else
						inRange = false;
											
					if(!Character.isDigit(index) || !inRange)
						System.out.println("Enter a valid number.\n");			
				}while(!Character.isDigit(index) || !inRange);	
											
				if(editIndex == 1)
					b.sportInput();
				else if(editIndex == 2)
					b.dayInput();
				else if(editIndex == 3)
					b.timeInput();
				else
					b.roomNumInput();
						
				//check whether details already exists 
				int j = 0;
				found = false;
				while(j < booking.length && !found)
				{
					if(booking[j].getSport().equals(b.getSport()) && booking[j].getDay().equals(b.getDay())
						&& booking[j].getTime().equals(b.getTime()) && booking[j].getRoomNum().equals(b.getRoomNum()))
						found = true;
					else
					{
						found = false;
						j++;
					}
				}
					
				if(found)
				{
					ans = 'n';
					System.out.println("The booking is already exists");
					System.out.println();
				}
				else
				{
					System.out.println("The new booking slot is: ");
					System.out.println("Sport: " + b.getSport() + "\t Day: " + b.getDay() + "\t Time: " + b.getTime() + "\t Room number: " + b.getRoomNum());
					System.out.println();
					System.out.print("Are you confirm to add this new slot?(y/n) ");	
					ans = Character.toLowerCase(input.next().charAt(0));
					System.out.println();
						
				}	
				
				if(ans == 'y')
				{	
					rearrangeDetail(b);
				}
						
				if(!Character.isAlphabetic(ans) || ans == 'y'|| ans == 'n')
				{
					System.out.println("Please enter valid character.");
					System.out.println();
				}
				
			}while(!Character.isAlphabetic(ans) || ans != 'y' || found);	
		}
			
	}

	public void deleteADetail()
	{
		String ans;
		int index;
		char[] ch;
		boolean inRange, found, isDigit;		
		Scanner input = new Scanner(System.in);
		
		do
		{	
			do
			{
				isDigit = false;
				found = false;
				
				System.out.println("Select an index that you wish to delete:");
				ans = input.next();
				ch = ans.toCharArray();
				
				//check whether user input is digit
				int j = 0;
				while(j < ch.length && !found)
				{
					if(!Character.isDigit(ch[j]))
					{
						found = true;
						isDigit = false;
					}
					else
					{
						j++;
						isDigit = true;
					}
				}
				
				if(!isDigit)
				{
					System.out.println("Please enter digits characters.");
					System.out.println();
				}
				
			}while(!isDigit);	
			
			index = Integer.parseInt(ans);
			inRange = false;
			
			if(index > 0 && index <= getNumberOfDetails())
				inRange = true;
			else
				inRange = false;
				
			if(!isDigit || !inRange)
			{
				System.out.println("Please enter valid digit character");
				System.out.println();
			}
		}while(!inRange);

		detailsList.remove(index - 1);
	}	
	
	//BookingList
	public void recordABooking(BookingDetails booking)
	{
		bookingList.add(booking);
	}
	
	public int getNumberOfBooking()
	{
		return bookingList.size();
	}
	
	public BookingDetails[] getBookingList()
	{
		BookingDetails[] b = new BookingDetails[bookingList.size()];
		for(int i = 0; i < b.length; i++)
			b[i] = bookingList.get(i);
		
		return b;
	}
	
	public void clearBookingList()
	{
		bookingList.clear();
	}
	
	//instance method
	public void createBooking(User member)
	{
		String day, time, roomNum, temp, ans;
		String sportType = "null";
		boolean inRange, found;
		int sportIndex, slotIndex;
		char[] ch;
		
		Scanner input = new Scanner(System.in);	
		
		BookingDetails[] detailsList = getDetailsList();
		ArrayList<BookingDetails> sportName = new ArrayList<BookingDetails>();	
		System.out.println("List of sport's type: ");
		
		//Check how many sport type
		for(int i = 0; i < getNumberOfDetails(); i++)
		{
			if(detailsList[i] != null)
			{			
				if(!detailsList[i].getSport().equals(sportType))
				{
					sportType = detailsList[i].getSport(); 
					BookingDetails sport = new BookingDetails(sportType);
					sportName.add(sport);
				}	
			}	
		}
		
		//Check repeated sport name in sportDetails
		for(int i = 0; i < sportName.size(); i++)
		{
			for(int j = i + 1; j < sportName.size(); j++)
			{
				if(sportName.get(i).getSport().equals(sportName.get(j).getSport()))
					sportName.remove(j);
			}
		}

		//Display sport type name
		for(int i = 0; i < sportName.size() ; i++)
		{
			System.out.println((i + 1) + ". " + sportName.get(i).getSport());
		}
		
		//Display sport type name
		do
		{	
			do
			{	
				System.out.print("\nSelect a sport: ");
				ans = input.nextLine();	
				ch = ans.toCharArray();
				
				found = false;
		        for(int x = 0; x < ch.length; x++)
		        {
		           if(Character.isDigit(ch[x]))
		        	   found = false;
		           else
		           {
						found = true;
						System.out.println("Please enter valid digit characeters.\n");
					}	
		         }  
			}while(found);
			
			sportIndex = Integer.parseInt(ans) - 1;
			System.out.println();
			
			if(sportIndex >= 0 && sportIndex < sportName.size())
				inRange = true;
			else
				inRange = false;
			
			if(!inRange)
				System.out.println("Please enter valid digit characeters.\n");
		}while(!inRange);
		
		//Store time slot for a sport		
		BookingDetails[] availableSlot = getAvailableSlot();//
		ArrayList<BookingDetails> timeSlot = new ArrayList<BookingDetails>();
		for(int i = 0; i < availableSlot.length; i++)
		{
			if(availableSlot[i] != null)
			{	
				if(availableSlot[i].getSport().equals(sportName.get(sportIndex).getSport()))	
				{
					//retrieve data of day, time, roomNum
					day = availableSlot[i].getDay();
					time = availableSlot[i].getTime();
					roomNum = availableSlot[i].getRoomNum();
					BookingDetails s = new BookingDetails(day, time, roomNum);
					timeSlot.add(s); 
				}
			}	
		}
		
		////Display time slot 
		if(timeSlot.size() > 0)
		{
			do
			{	
				do
				{	
					System.out.println("Available time slot: ");
						
					for(int i = 0; i < timeSlot.size(); i++)
					{		
						System.out.println((i+1) + ". " + timeSlot.get(i).getDay() + "\t " + timeSlot.get(i).getRoomNum() + "\t " + timeSlot.get(i).getTime());	
					}
					
					System.out.println();
					System.out.print("Select your option: ");
					ans = input.nextLine();	
					ch = ans.toCharArray();
					
					found = false;
			        for(int x = 0; x < ch.length; x++)
			        {
			           if(Character.isDigit(ch[x]))
			        	   found = false;
			           else
			           {
							found = true;
							System.out.println("Please enter valid digit characeters.\n");
						}	
			         } 
				}while(found); 
				slotIndex = Integer.parseInt(ans) - 1;
				
				if(slotIndex >= 0 && slotIndex < timeSlot.size())
					inRange = true;
				else
					inRange = false;
				
				if(!inRange)
					System.out.println("Please enter valid digit characeters.\n");
			}while(!inRange);
			
			System.out.println("You have booked: ");
			System.out.printf("SPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s\n", sportName.get(sportIndex).getSport(), timeSlot.get(slotIndex).getDay(),
								timeSlot.get(slotIndex).getTime(),timeSlot.get(slotIndex).getRoomNum());		
			
			//get the data day, time, roomNum from user 
			BookingDetails book = new BookingDetails(member, sportName.get(sportIndex).getSport(), timeSlot.get(slotIndex).getDay(),
												timeSlot.get(slotIndex).getTime(),timeSlot.get(slotIndex).getRoomNum());
			recordABooking(book);
		}	
		else
			System.out.println("No available time slot.\n");
	
	}	
	
	public void updateBooking(User member)
	{
		String sport = null;
		String updatedDay = null;
		String updatedTime = null;
		String updatedRoomNum = null;
		String temp;
		
		BookingDetails[] bookingList = getBookingList();
        
		int count = 0;
		for(int k=0; k<bookingList.length; k++)
		{
			if(bookingList[k].getName().equals(member.getMemberInfo().getName()))
				count ++;
		}
		
		if(count == 0)
			System.out.println("No booking record!");
		
		else
		{
			Scanner input = new Scanner(System.in);
	        char exist = 'n';
	        int bookedcount = 1;
	        String bookedDay, bookedTime, bookedRoomNum;
	        int updatedindex = 0;
	        String answer = "Y";
	        
			String sportType = "null";
			char[] ch;
			boolean found;
			int index;
	        ArrayList<BookingDetails> sportName = new ArrayList<BookingDetails>();	
			System.out.println("LIST OF SPORT'S TYPE: ");
			//Check how many sport type
			for(int i = 0; i < getNumberOfDetails(); i++)
			{
				if(detailsList.get(i) != null)
				{					
					if(!detailsList.get(i).getSport().equals(sportType))
					{
						sportType = detailsList.get(i).getSport(); 
						BookingDetails s = new BookingDetails(sportType);
						sportName.add(s);
					}	
				}	
			}
			
			//Check repeated sport name in sportDetails
			for(int i = 0; i < sportName.size(); i++)
			{
				for(int j = i + 1; j < sportName.size(); j++)
				{
					if(sportName.get(i).getSport().equals(sportName.get(j).getSport()))
						sportName.remove(j);
				}
			}
	        
			//Display sport type name
			for(int i = 0; i < sportName.size() ; i++)
			{
				System.out.println((i + 1) + ". " + sportName.get(i).getSport());
			}
	       
			do
	        {
				//Ask user choose a sport to update
				do
				{	
					do
					{	
						System.out.print("What sport do you want to update?: ");
			            temp = input.nextLine();
			            ch = temp.toCharArray();
			            
			            found = false;
			            for(int i = 0; i < ch.length; i++)
			            {
			            	if(Character.isDigit(ch[i]))
								found = false;
							else
							{
								found = true;
								System.out.println("Please enter valid digit characeters.");
							}	
			            }
			            
			            
					}while(found); 
					
					index = Integer.parseInt(temp) - 1;
					
					if(index < 0 || index > sportName.size())
						System.out.println("Please enter valid digit characeters.");
				}while(index < 0 || index > sportName.size());
				
				sport = sportName.get(index).getSport();
			 
	            for(int i=0; i<bookingList.length; i++)
	            {
	               if(bookingList[i].getId().equals(member.getMemberInfo().getId()) && bookingList[i].getName().equals(member.getMemberInfo().getName()) && bookingList[i].getSport().equals(sport))
	                {
	                    exist = 'y';
	                    i = bookingList.length;
	                    
	                    System.out.println("\nYOUR BOOKING FOR " + sport + " : ");
	                    
	                    // display booked time slot for that sport
	                 	for(int j=0; j<getNumberOfBooking(); j++)
	                 	{
	                 		if(bookingList[j].getSport().equals(sport) && bookingList[j].getName().equals(member.getMemberInfo().getName()))
	                 		{
	                 			bookedDay = bookingList[j].getDay();
	                 			bookedTime = bookingList[j].getTime();
	                 			bookedRoomNum = bookingList[j].getRoomNum();
	                 			System.out.printf("%d. Day: %s\nTime: %s\nRoom Number: %s\n\n",
	                 					bookedcount, bookedDay, bookedTime, bookedRoomNum);
	                 			bookedcount++;
	                 		}	
	                 	}
	                 	
	                 	do
	                 	{
	                 		System.out.print("Continue to update?(y/n): ");
		                 	answer = input.nextLine().toUpperCase();
		                 	
		                 	if(answer.equals("Y"))
		                 	{
		                 		do
				                {	
				                 	do
					                {	
				                 		
						                 System.out.print("\nSelect a time slot to update(1/2/3/...): ");
						                 temp = input.nextLine();
						                 ch = temp.toCharArray();
								            
								         found = false;
								         for(int x = 0; x < ch.length; x++)
								         {
								            if(Character.isDigit(ch[x]))
								            	found = false;
								            else
											{
												found = true;
												System.out.println("Please enter valid digit characeters.");
											}	
								         }  
								         
								        if(!found)
								        {
								        	 if(Integer.parseInt(temp) > bookedcount-1)
									        {
								        		 System.out.println("Invalid input. Please enter an available index number in your booking list");
								        		 found = true;
									        }
								        }
								         
					                 }while(found);	
				                 	updatedindex = Integer.parseInt(temp);
				                }while(updatedindex <= 0 || updatedindex > bookedcount);
		                 	}
		                 	else if(!answer.equals("Y") && !answer.equals("N"))
		                 		System.out.println("Please enter 'y' or 'n'");
		                 	
	                 	}while(!answer.equals("Y") && !answer.equals("N"));
	                 	
		                
	                }
	            }
	            
	            if(exist == 'n')
	                System.out.println("No booking record found!");
	            
	        }while(exist != 'y');
			
			if(answer.equals("Y"))
			{
				int detailscount = 0;
				int bookingcount = 0;
				ArrayList<BookingDetails> availableTimeSlot = new ArrayList<BookingDetails>();
				int availablecount = 0;
				
				// display available time slot
				System.out.println("\nAVAILABLE TIME SLOT:");
				for(int i=0; i<getNumberOfDetails(); i++)
				{
					String empty = "y";
					BookingDetails[] detailslist = getDetailsList();
					if(detailslist[i].getSport().equals(sport))
					{
						detailscount++;
						updatedDay = detailslist[i].getDay();
						updatedTime = detailslist[i].getTime();
						updatedRoomNum = detailslist[i].getRoomNum();
							
						BookingDetails[] bookinglist = getBookingList();
						for(int j=0; j<getNumberOfBooking(); j++)
						{
							if(bookinglist[j].getSport().equals(sport))
							{
								if(bookinglist[j].getDay().equals(updatedDay) &&
									bookinglist[j].getTime().equals(updatedTime) &&
									bookinglist[j].getRoomNum().equals(updatedRoomNum))
								{
									empty = "n";
									j = getNumberOfBooking();
									bookingcount++;
								}
								else
									empty = "y";
							}
						}
							
						if(empty.equals("y"))
						{
							availableTimeSlot.add(new BookingDetails(updatedDay,updatedTime,updatedRoomNum));
							System.out.printf("%d. Day: %s\nTime: %s\nRoom Number: %s\n\n", 
									(availablecount+1), updatedDay, updatedTime, updatedRoomNum);	//add roomnum
							availablecount ++;
						}
					}
				}
				
				if(detailscount==bookingcount)
					System.out.println("Sorry! No available time slot");
				else
				{
					// ask for new day and time	
					int ans;
						
					do
					{
						System.out.print("Enter No.(Eg:1/2/3/...): ");
						ans = Integer.parseInt(input.nextLine());
							
						if(ans>availableTimeSlot.size())
							System.out.println("Wrong input!");
						else
						{
							BookingDetails list = availableTimeSlot.get(ans-1);
							updatedDay = list.getDay();
							updatedTime = list.getTime();
							updatedRoomNum = list.getRoomNum();
							System.out.println("Successfully updated");
						}
							
					}while(ans>availableTimeSlot.size());
					
					count = 0;
					// update booking
					for(int a=0; a<getNumberOfBooking(); a++)
					{
						BookingDetails[] bookinglist = getBookingList();			
						if(bookinglist[a].getName().equals(member.getMemberInfo().getName()) && 
								bookinglist[a].getId().equals(member.getMemberInfo().getId()) &&
								bookinglist[a].getSport().equals(sport))
							count ++;
							
						if(count == updatedindex)
						{
							bookinglist[a].setDay(updatedDay);
							bookinglist[a].setTime(updatedTime);
							bookinglist[a].setRoomNum(updatedRoomNum);
							a = getNumberOfBooking();
						}
					}

				}
			}
	        
		}
		
	}
	
	public void searchAMemberBooking()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a member's ID to search for his/her booking's information: ");
		String id = input.nextLine();
		 
		BookingDetails[] bookingList = getBookingList();
		ArrayList<BookingDetails> temp = new ArrayList<BookingDetails>(); 
		
		boolean found = false;
		int i = 0;
		int count = getNumberOfBooking();
		
		
		while(i < count && ! found)
		{
			if(bookingList[i].getId().equals(id))
				found = true;
			else 
				i++;
		}
		
		if(found)
		{	
			for(int j = 0; j < bookingList.length; j++)
			{
				 if(bookingList[j].getId().equals(id))
				 {
					 BookingDetails b = new BookingDetails(bookingList[j].getName(), bookingList[j].getId(), bookingList[j].getSport(), bookingList[j].getDay(), 
							 								bookingList[j].getTime(), bookingList[j].getRoomNum());
					 temp.add(b);
				 }
					 
			}
			
			System.out.println("The booking found is: ");
			for(int j = 0; j < temp.size(); j++)
			{
				System.out.print((j + 1 ) + ". ");
			 	System.out.printf("NAME: %-25s\tID: %-8sSPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s\n", temp.get(j).getName(),
			 						temp.get(j).getId(), temp.get(j).getSport(), temp.get(j).getDay(), temp.get(j).getTime(),
			 						temp.get(j).getRoomNum());
			}
		}	
		else
			System.out.println("Booking not found");
	}

	public void searchBooking(User member)
	{
		BookingDetails[] bookingList = getBookingList();
		String sportType = "null";
		
		ArrayList<BookingDetails> sportName = new ArrayList<BookingDetails>();	
		System.out.println("LIST OF SPORT'S TYPE: ");
		//Check how many sport type
		for(int i = 0; i < getNumberOfDetails(); i++)
		{
			if(detailsList.get(i) != null)
			{					
				if(!detailsList.get(i).getSport().equals(sportType))
				{
					sportType = detailsList.get(i).getSport(); 
					BookingDetails s = new BookingDetails(sportType);
					sportName.add(s);
				}	
			}	
		}
		
		//Check repeated sport name in sportDetails
		for(int i = 0; i < sportName.size(); i++)
		{
			for(int j = i + 1; j < sportName.size(); j++)
			{
				if(sportName.get(i).getSport().equals(sportName.get(j).getSport()))
					sportName.remove(j);
			}
		}
        
		//Display sport type name
		for(int i = 0; i < sportName.size() ; i++)
		{
			System.out.println((i + 1) + ". " + sportName.get(i).getSport());
		}
		
		String temp;
		char[] ch;
		boolean found;
		int index;
		
		Scanner input = new Scanner(System.in);
		do
        {
			//Ask user choose a sport to update
			do
			{	
				System.out.print("What sport's booking do you want to search for?: ");
		        temp = input.nextLine();
		        ch = temp.toCharArray();
		            
		        found = false;
		        for(int i = 0; i < ch.length; i++)
		        {
		        	if(Character.isDigit(ch[i]))
		        		found = false;
					else
					{
						found = true;
						System.out.println("Please enter valid digit characeters.");
					}	
		        }
		            
		            
			}while(found); 
				
			index = Integer.parseInt(temp);
				
			if(index < 0 || index > sportName.size())
				System.out.println("Please enter valid digit characeters.");
		}while(index < 0 || index > sportName.size());
			
		index = Integer.parseInt(temp) - 1;
		String sport = sportName.get(index).getSport();
			
		char exist;
		int bookedcount = 1;
		String bookedDay, bookedTime, bookedRoomNum;
			
        for(int i=0; i<bookingList.length; i++)
        {
        	if(bookingList[i].getId().equals(member.getMemberInfo().getId()) && bookingList[i].getName().equals(member.getMemberInfo().getName()) && bookingList[i].getSport().equals(sport))
        	{
        		exist = 'y';
                i = bookingList.length;
                    
                System.out.println("\nYOUR BOOKING FOR " + sport + " : ");
                    
                // display booked time slot for that sport
                for(int j=0; j<getNumberOfBooking(); j++)
                {
                 	if(bookingList[j].getSport().equals(sport) && bookingList[j].getName().equals(member.getMemberInfo().getName()))
                 	{
                 		bookedDay = bookingList[j].getDay();
                 		bookedTime = bookingList[j].getTime();
                 		bookedRoomNum = bookingList[j].getRoomNum();
                 		System.out.printf("%d. Day: %s\nTime: %s\nRoom Number: %s\n\n",
                 					bookedcount, bookedDay, bookedTime, bookedRoomNum);
                 		bookedcount++;
                 		
                 	}
                }
            }
        }
        if(bookedcount == 1)
        	System.out.println("NO booking found for " + sport + "\n");
	}	
	
	public void deleteABooking(User member) 
	{
		
		String num;
		int idx, tempCount, k = 0;
		char[] ch;
		boolean found, booking = false;
		Scanner input = new Scanner (System.in);
		BookingDetails[] book = getBookingList();
		ArrayList <BookingDetails> temp = new ArrayList<BookingDetails>();
		while(k < book.length && !booking)
		{
			if(book[k].getId().equals(member.getMemberInfo().getId()) && book[k].getName().equals(member.getMemberInfo().getName()))
				booking = true;
			else
			{
				booking = false;
				k++;
			}
		}
		
		if(booking)
		{
			for(int i = 0; i < book.length; i++)
			{
				if(book[i].getId().equals(member.getMemberInfo().getId()) && book[i].getName().equals(member.getMemberInfo().getName()))
				{
					BookingDetails b = new BookingDetails(book[i].getSport(), book[i].getDay(), book[i].getTime(), book[i].getRoomNum());
					temp.add(b);
				}
			}
			
			tempCount = temp.size();
			System.out.println("Your booking list is: ");
			for(int i = 0; i < temp.size(); i++)
			{
				if(temp.get(i) != null)
				{	
					System.out.print((i + 1) + ". ");
					System.out.printf("SPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s", temp.get(i).getSport(),
									temp.get(i).getDay(), temp.get(i).getTime(), temp.get(i).getRoomNum());
					System.out.println();
				}	
			}
			
			do
			{	
				do
				{
					found = false;
					int j = 0;
					System.out.println("\nEnter the booking to be deleted: ");
					num = input.nextLine();
					ch = num.toCharArray();
				
					while(j < ch.length && !found)
					{
						if(Character.isDigit(ch[j]))
						{
							found = false;
							j++;
						}
						else
						{
							found = true;
							System.out.println("Please enter valid digit characeters.\n");
						}
					}
				
				}while(found);
				
				idx = Integer.parseInt(num) - 1;
				if(idx < 0 || idx >= tempCount)
					System.out.println("Please enter valid digit characeters.\n");
			}while(idx < 0 || idx >= tempCount);	
			
			System.out.println("The deleted booking is: ");
			System.out.printf("SPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s", temp.get(idx).getSport(), temp.get(idx).getDay(), 
								temp.get(idx).getTime(), temp.get(idx).getRoomNum());
				
			for(int i = 0; i < book.length; i++)
			{
				if (book[i].getSport().equals(temp.get(idx).getSport()) && book[i].getDay().equals(temp.get(idx).getDay())
						&& book[i].getTime().equals(temp.get(idx).getTime()) && book[i].getRoomNum().equals(temp.get(idx).getRoomNum()))
				{

					bookingList.remove(i);
					System.out.println("\nSuccessfully delete.");	
					i = book.length;
				}
			}
			
			BookingDetails[] newList = getBookingList();
			System.out.println("\nYour new booking list is: ");
			int newIndex = 0;
			for(int i = 0; i < getNumberOfBooking(); i++)
			{
				if(temp.get(i) != null)
				{	
					if(newList[i].getId().equals(member.getMemberInfo().getId()) && newList[i].getName().equals(member.getMemberInfo().getName()))
					{	
						newIndex++;
						System.out.print(newIndex + ". ");
						System.out.printf("SPORT: %-15s\tDAY: %-12sTIME: %-20sROOM NUMBER: %-5s", newList[i].getSport(),
								newList[i].getDay(), newList[i].getTime(), newList[i].getRoomNum());
						System.out.println();
					}
				}	
			}
		}
		else
			System.out.println("No booking found. Please create a booking. ");
		
		
	}
	
	//Available slot
	public void recordASlot(BookingDetails slot)
	{
		availableSlot.add(slot);
	}
	
	public int getNumberOfSlot()
	{
		return availableSlot.size();
	}
	
	public BookingDetails[] getAvailableSlot()
	{
		BookingDetails[] s = new BookingDetails[availableSlot.size()];
		for(int i = 0; i < s.length; i++)
			s[i] = availableSlot.get(i);
		
		return s;
	}	
	
	public void clearSlotList()
	{
		availableSlot.clear();
	}
}
