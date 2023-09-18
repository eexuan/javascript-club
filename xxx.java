/*
import java.util.Scanner;

public static void deleteBooking(Booking details) {
		
		String num;
		int idx;
		
		Scanner input = new Scanner(System.in);
		
		BookingList[] bookingList = details.getBookingList();
		do {
			
			System.out.println("Your booking list now is: "); //display the original booking list
			
			for(BookingList b: bookingList)
			{
				if(b != null)
				{
					System.out.println((i + 1) + "SPORT : " + b.getSport() + 
							"\tDAY : " + b.getDay() + 
							"\tTIME : " + b.getTime() + 
							"\tROOM NUMBER : " + b.getRoomNum());
				}
			}
			
			System.out.println();
			System.out.print("Please enter the booking to be deleted: "); //ask which booking to be deleted
			num = input.nextLine();
			idx = Integer.parseInt(num);
			
			for (int i = 0; i <= bookingList.length; i++) {
				
				if (idx <= bookingList.length) {
					
					bookingList = removeElement(bookingList, idx-1); // delete the booking
					
					System.out.print(bookingList); // display the new booking list?
					
					System.out.println();
					System.out.println("Your booking deletion is done. ");
					
				} else {
					
					System.out.println("The booking cannot be found. Please enter a valid booking.");
				}
				
				System.out.print(bookingList);
			}
		} while (bookingList == null);
		
	// System.out.println("The booking deletion cannot be done. ");	
	}
	
/*
public static void deleteBooking(Booking details) {
	
	Scanner input = new Scanner (System.in);
	BookingList[] bookingList = details.getBookingList();
	
	System.out.println();
	
	System.out.print("Enter your id: \n");
	String id = input.nextLine();
	
	for (int i = 0; i < details.getBookingList().length; i++) {
		
		if (bookingList[i] != null) {
			
			if (bookingList[i].getId().equals(id)) {
				
				System.out.println("Your booking list now is: ");
				System.out.println((i + 1) + "SPORT: " + bookingList[i].getSport() + 
						"\tDAY: " + bookingList[i].getDay() + 
						"\tTIME: " + bookingList[i].getTime() + 
						"\tROOM NUMBEr: " + bookingList[i].getRoomNum());
				System.out.println();
			}
		}
		
		System.out.println("Enter the booking to be deleted: ");
		String num = input.nextLine();
		int idx = Integer.parseInt(num);
		
		for (int j = 0; j <= bookingList.length; j++) {
			
			if (idx <= bookingList.length) {
				
				bookingList = removeElement (bookingList, idx-1);
				
				System.out.println("Your booking deletion is done.");
				System.out.println();
				System.out.println("Your new booking list is: ");
				System.out.println(bookingList);
				System.out.println();
			} else {
				
				System.out.println("The booking deletion cannot be done.");
				System.out.println();
			}
		}
	}
}
*/

//new booking list store
	
	/*
	 * for(int k = 0; k < bookList.size(); k++)
			{
				for(int j = 0; j < details.getNumberOfBooking(); j++)
				{
					if(bookList.get(idx).getSport().equals(bookingList[j].getSport()) 
						&& bookList.get(i).getDay().equals(bookingList[j].getDay())
						&& bookList.get(i).getTime().equals(bookingList[j].getTime())
						&& bookList.get(i).getRoomNum().equals(bookingList[j].getRoomNum()))
					{
						bookList.remove(idx);
					}				
				}
				
				details.clearBookingList();
				
				for(int l = 0; l < bookList.size(); l++)
				{
					BookingList booking = new BookingList(name, id, bookList.get(l).getSport(), bookList.get(l).getDay(),
							bookList.get(l).getTime(), bookList.get(l).getRoomNum());
					
					details.recordABooking(booking);
				}
			}
			
	 */
	
	/*
	 * 
	 * for(int k = 0; k < bookList.size(); k++)
			{
				for(int j = 0; j < details.getNumberOfBooking(); j++)
				{
					if(bookList.get(i).getSport().equals(bookingList[j].getSport()) 
						&& bookList.get(i).getDay().equals(bookingList[j].getDay())
						&& bookList.get(i).getTime().equals(bookingList[j].getTime())
						&& bookList.get(i).getRoomNum().equals(bookingList[j].getRoomNum()))
					{
						bookList.remove(i);
					}				
				}
			}
			
			for(int l = 0; l < bookList.size(); l++)
			{
				BookingList booking = new BookingList(bookList.get(l).getSport(), bookList.get(l).getDay(),
						bookList.get(l).getTime(), bookList.get(l).getRoomNum());
				
				details.recordABooking(booking);
			}
	 * 
	 * for(int i = 0; i < bookList.size(); i++)
		{
			for(int j = 0; j < details.getNumberOfBooking(); j++)
			{
				if(bookList.get(i).getSport().equals(bookingList[j].getSport()) 
					&& bookList.get(i).getDay().equals(bookingList[j].getDay())
					&& bookList.get(i).getTime().equals(bookingList[j].getTime())
					&& bookList.get(i).getRoomNum().equals(bookingList[j].getRoomNum()))
				{
					bookList.remove(i);
				}				
			}
		}
		
		public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
		int i = 0;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		BookingDetails[] detailsList = details.getDetailsList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		if (!bookingList[i].getId().equals(id)) {
			
			System.out.print("Your booking list is empty. \n");
			
		} else {
			
			System.out.println();
			System.out.print("Your booking list now is: \n");
			
			for (int j = 0; j < details.getBookingList().length; j++) {
				
				if (bookingList[j] != null) {
					
					System.out.print((j + 1) + ". " + "SPORT: " + bookingList[j].getSport()
							+ "\tDAY: " + bookingList[j].getDay()
							+ "\tTIME: " + bookingList[j].getTime()
							+ "\t ROOM NUMBER: " + bookingList[j].getRoomNum());
					
					System.out.println();
					
				} 
			}
			
			System.out.println("\nEnter the booking to be deleted: ");
			num = input.nextLine();
			idx = Integer.parseInt(num);
			
			System.out.println("\nThe booking to be deleted is: " + num + ". ");
			System.out.println("SPORT: " + bookingList[idx-1].getSport()
					+ "\tDAY: " + bookingList[idx-1].getDay()
					+ "\tTIME: " + bookingList[idx-1].getTime()
					+ "\t ROOM NUMBER: " + bookingList[idx-1].getRoomNum());
			System.out.println();
			
			if (!bookingList[i].getNumberOfBooking().equals(id)) {
				
				bookingList = removeElement(bookingList, idx-1);
				
				System.out.println("The booking cannot be found. Please enter a valid booking. ");
				
				
				
			} else {
				
				
				System.out.println("Your booking deletion is done. \n");
				System.out.println("Your new booking list is: ");
			
				System.out.println();
			}
		}
		
	}
	*/
	
	/*
	public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
	//	int i = 0;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		if (id != null) {
				
				System.out.println();
				System.out.print("Your booking list now is: \n");
				
				for (int j = 0; j < details.getBookingList().length; j++) {
					
					if (bookingList[j] != null) {
						
						if (bookingList[j].getId().equals(id)) {
							
							System.out.print((j + 1) + ". " + "SPORT: " + bookingList[j].getSport()
									+ "\tDAY: " + bookingList[j].getDay()
									+ "\tTIME: " + bookingList[j].getTime()
									+ "\t ROOM NUMBER: " + bookingList[j].getRoomNum());
							
							System.out.println();
							
						} 
						}
					}
				
				
				System.out.println("\nEnter the booking to be deleted: ");
				num = input.nextLine();
				idx = Integer.parseInt(num);
					
				System.out.println("\nThe booking to be deleted is: " + num + ". ");
				System.out.println("SPORT: " + bookingList[idx-1].getSport()
						+ "\tDAY: " + bookingList[idx-1].getDay()
						+ "\tTIME: " + bookingList[idx-1].getTime()
						+ "\t ROOM NUMBER: " + bookingList[idx-1].getRoomNum());
				System.out.println();
				
				if (idx <= details.getBookingList().length) {
					
					bookingList = removeElement(bookingList, idx-1);
					
					System.out.println("Your booking deletion is done. \n");
					System.out.println("Your new booking list is: ");
				
					System.out.println();
					
				} else {
					
				System.out.println("The booking cannot be found. Please enter a valid booking. ");
				System.out.println();
				
				}
				
			} else {
				
				System.out.println("The id cannot be found. Please enter a valid id. ");

			}
	}
	*/
	
	/*
	public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		if (id != null) {
			
			System.out.println();
			System.out.print("Your booking list now is: \n");
			
			for (int i = 0; i < details.getBookingList().length; i++) {
				
				if (bookingList[i] != null) {
					
					if (bookingList[i].getId().equals(id)) {
						
						System.out.print((i + 1) + ". " + "SPORT: " + bookingList[i].getSport()
								+ "\tDAY: " + bookingList[i].getDay()
								+ "\tTIME: " + bookingList[i].getTime()
								+ "\t ROOM NUMBER: " + bookingList[i].getRoomNum());
						
						System.out.println();
						
					} else {
						
						System.out.println("The id cannot be found. Please enter again. ");
					}
				}
			}
			
			System.out.println("\nEnter the booking to be deleted: ");
			num = input.nextLine();
			idx = Integer.parseInt(num);
				
			System.out.println("\nThe booking to be deleted is: " + num + ". ");
			System.out.println("SPORT: " + bookingList[idx-1].getSport()
					+ "\tDAY: " + bookingList[idx-1].getDay()
					+ "\tTIME: " + bookingList[idx-1].getTime()
					+ "\t ROOM NUMBER: " + bookingList[idx-1].getRoomNum());
			System.out.println();
			
			if (idx <= details.getBookingList().length) {
				
				bookingList = removeElement(bookingList, idx-1);
				
				System.out.println("Your booking deletion is done. \n");
				System.out.println("Your new booking list is: ");
					
				for (int j = 0; j < details.getBookingList().length; j++) {
						
					System.out.print((j + 1) + ". " + "SPORT: " + bookingList[j].getSport()
							+ "\tDAY: " + bookingList[j].getDay()
							+ "\tTIME: " + bookingList[j].getTime()
							+ "\tROOM NUMBER: " + bookingList[j].getRoomNum());
					System.out.println();
					
				}
					
				System.out.println();
				
			} else {
				
			System.out.println("The booking cannot be found. Please enter a valid booking. ");
			System.out.println();
			
			}
		} else {
			
			System.out.print("The booking deletion cannot be done. ");
			
		}
		
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
	*/
	
	/*
	public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		if (id != null) {
			
			System.out.println();
			System.out.print("Your booking list now is: \n");
			
			for (int i = 0; i < details.getBookingList().length; i++) {
				
				if (bookingList[i] != null) {
					
					if (bookingList[i].getId().equals(id)) {
						
						System.out.print((i + 1) + ". " + "SPORT: " + bookingList[i].getSport()
								+ "\tDAY: " + bookingList[i].getDay()
								+ "\tTIME: " + bookingList[i].getTime()
								+ "\t ROOM NUMBER: " + bookingList[i].getRoomNum());
						
						System.out.println();
						
					} else {
						
						System.out.println("The id cannot be found. Please enter again. ");
					}
				}
			}
			
			System.out.println("\nEnter the booking to be deleted: ");
			num = input.nextLine();
			idx = Integer.parseInt(num);
				
			System.out.println("\nThe booking to be deleted is: " + num + ". ");
			System.out.println("SPORT: " + bookingList[idx-1].getSport()
					+ "\tDAY: " + bookingList[idx-1].getDay()
					+ "\tTIME: " + bookingList[idx-1].getTime()
					+ "\t ROOM NUMBER: " + bookingList[idx-1].getRoomNum());
			System.out.println();
				
			if (idx <= details.getBookingList().length) {
					
				bookingList = removeElement(bookingList, idx-1);
					
				System.out.println("Your booking deletion is done. \n");
				System.out.println("Your new booking list is: ");
					
				for (int j = 0; j < details.getBookingList().length; j++) {
						
					System.out.print((j + 1) + ". " + "SPORT: " + bookingList[j].getSport()
							+ "\tDAY: " + bookingList[j].getDay()
							+ "\tTIME: " + bookingList[j].getTime()
							+ "\tROOM NUMBER: " + bookingList[j].getRoomNum());
					System.out.println();
				}
					
				System.out.println();
				
					
			} else {
					
				System.out.println("The booking cannot be found. Please enter a valid booking. ");
				System.out.println();
			}
			
		} else {
			
			System.out.print("The booking deletion cannot be done. ");
			
		}
	}
	*/
	
	/*
	 * for(int i=0; i<getNumberOfBooking(); i++)
			{
				BookingList[] bookinglist = getBookingList();			
				if(bookinglist[i].getName().equals(name) && bookinglist[i].getId().equals(id))
				{
					bookinglist[i].setDay(day);
					bookinglist[i].setTime(time);
					bookinglist[i].setRoomNum(roomNum);
				}
			}
	 */
	
	/*
	public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		do {
			
			for (int i = 0; i < details.getBookingList().length; i++) {
				
				if (bookingList[i] != null) {
					
					if (bookingList[i].getId().equals(id)) {
						
						System.out.println();
						System.out.print("Your booking list now is: ");
						
						System.out.println((i + 1) + ". " + "SPORT: " + bookingList[i].getSport()
								+ "\tDAY: " + bookingList[i].getDay()
								+ "\tTIME: " + bookingList[i].getTime()
								+ "\t ROOM NUMBER: " + bookingList[i].getRoomNum());
						
						System.out.println();
						
					} else {
						
						System.out.println("The id cannot be found. Please enter again. ");
					}
				}
				
				System.out.println("Enter the booking to be deleted: ");
				num = input.nextLine();
				idx = Integer.parseInt(num);
				
				System.out.println("\nThe booking to be deleted is: " + num + ". ");
				System.out.println("SPORT: " + bookingList[idx-1].getSport()
						+ "\tDAY: " + bookingList[idx-1].getDay()
						+ "\tTIME: " + bookingList[idx-1].getTime()
						+ "\t ROOM NUMBER: " + bookingList[idx-1].getRoomNum());
				System.out.println();
				
				if (idx <= details.getBookingList().length) {
					
					bookingList = removeElement(bookingList, idx-1);
					
					System.out.println("Your booking deletion is done. \n");
					System.out.println("Your new booking list is: ");
					
					for (int j = 0; j < details.getBookingList().length; j++) {
						
						System.out.print((j + 1) + ". " + "SPORT: " + bookingList[j].getSport()
								+ "\tDAY: " + bookingList[j].getDay()
								+ "\tTIME: " + bookingList[j].getTime()
								+ "\tROOM NUMBER: " + bookingList[j].getRoomNum());
						System.out.println();
					}

					System.out.println();
					
					
				} else {
					
					System.out.println("The booking cannot be found. Please enter a valid booking. ");
					System.out.println();
				}
			} 
		} while (bookingList == null);
		
		System.out.print("The booking deletion cannot be done. ");
	}
	*/
	
	/*
	public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		System.out.println();
		System.out.print("Your booking list now is: \n");
		
		do {
			
			for (int i = 0; i < details.getBookingList().length; i++) {
				
				if (bookingList[i] != null) {
					
					if (bookingList[i].getId().equals(id)) {
						
						System.out.println((i + 1) + ". " + "SPORT: " + bookingList[i].getSport()
								+ "\tDAY: " + bookingList[i].getDay()
								+ "\tTIME: " + bookingList[i].getTime()
								+ "\t ROOM NUMBER: " + bookingList[i].getRoomNum());
						System.out.println();
						
					} else {
						
						System.out.println("The id cannot be found. Please enter again. ");
					}
				}
				
			}
			
			System.out.println("Enter the booking to be deleted: ");
			num = input.nextLine();
			idx = Integer.parseInt(num);
			
			System.out.println("\nThe booking to be deleted is: " + num + ". ");
			System.out.println("SPORT: " + bookingList[idx-1].getSport()
					+ "\tDAY: " + bookingList[idx-1].getDay()
					+ "\tTIME: " + bookingList[idx-1].getTime()
					+ "\t ROOM NUMBER: " + bookingList[idx-1].getRoomNum());
			System.out.println();
			
			for (int i = 0; i <= details.getBookingList().length; i++) {
				
				if (idx <= details.getBookingList().length) {
					
					bookingList = removeElement(bookingList, idx-1);
					
					System.out.println("Your booking deletion is done. \n");
					System.out.println("Your new booking list is: ");
					
					for (int j = 0; j < details.getBookingList().length; j++) {
						
						System.out.print((j + 1) + ". " + "SPORT: " + bookingList[j].getSport()
								+ "\tDAY: " + bookingList[j].getDay()
								+ "\tTIME: " + bookingList[j].getTime()
								+ "\tROOM NUMBER: " + bookingList[j].getRoomNum());
						System.out.println();
					}

					System.out.println();
					
					
				} else {
					
					System.out.println("The booking cannot be found. Please enter a valid booking. ");
					System.out.println();
				}
			}
			
		} while (bookingList == null);
		
		System.out.print("The booking deletion cannot be done. ");
		
	}
	*/
	
	/*
	public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
		int i = 0;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		System.out.println();
		System.out.print("Your booking list now is: \n");
		
		if (bookingList[i] != null) {
			
			for (int j = 0; j < details.getBookingList().length; j++) {
				
					if (bookingList[j].getId().equals(id)){
					
					System.out.print((j + 1) + ". " + "SPORT: " + bookingList[j].getSport()
							+ "\tDAY: " + bookingList[j].getDay()
							+ "\tTIME: " + bookingList[j].getTime()
							+ "\tROOM NUMBER: " + bookingList[j].getRoomNum());
					System.out.println();
				} else {
					
					System.out.print("The id cannot be found. Please enter a valid id. ");
				}
			}
			
			System.out.println("\nEnter the booking to be deleted: ");
			num = input.nextLine();
			idx = Integer.parseInt(num);
			
			System.out.print("The booking to be deleted is: " + num + ". \n");
			System.out.print("SPORT: " + bookingList[idx-1].getSport() +
					"\tDAY: " + bookingList[idx-1].getDay() + 
					"\tTIME: " + bookingList[idx-1].getTime() + 
					"\tROOM NUMBER: " + bookingList[idx-1].getRoomNum());
			System.out.println();
			
			for (int j = 0; j < bookingList.length; j++) {
				
				if ( idx <= bookingList.length) {
					
					bookingList = removeElement (bookingList, idx-1);
					
					System.out.print("\nYour booking deletion is done. ");
					System.out.print("\nYour booking list now is: ");
					
					for (int k = 0; k < details.getBookingList().length; k++) {
						
						System.out.print((j + 1) + ". " + "SPORT: " + bookingList[k].getSport()
								+ "\tDAY: " + bookingList[k].getDay()
								+ "\tTIME: " + bookingList[k].getTime()
								+ "\tROOM NUMBER: " + bookingList[k].getRoomNum());
						System.out.println();
					}
					
					System.out.println();
				} else {
					
					System.out.print("The booling deletion cannot be done. Please enter a valid booking. \n");
					
				}
			}
		} else {
			
			System.out.print("The booking deletion cannot be done. Please enter a valid booking. \n");
			
		}
	}
	*/
	
	/*
	public static void deleteBooking(Booking details) {
		
		String num, id;
		int idx;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter id: ");
		id = input.nextLine();
		
		System.out.println();
		System.out.print("Your booking list now is: ");
		
		for (int i = 0; i < details.getBookingList().length; i++) {
			
			if (bookingList[i] != null) {
				
				if (bookingList[i].getId().equals(id)){
					
					System.out.print((i + 1) + ". " + "SPORT: " + bookingList[i].getSport()
							+ "\tDAY: " + bookingList[i].getDay()
							+ "\tTIME: " + bookingList[i].getTime()
							+ "\tROOM NUMBER: " + bookingList[i].getRoomNum());
					System.out.println();
				} else {
					
					System.out.print("The id cannot be found. Please enter a valid id. ");
				}
				
				System.out.println("Enter the booking to be deleted: ");
				num = input.nextLine();
				idx = Integer.parseInt(num);
				
				System.out.print("The booking to be deleted is: " + num + ". ");
				System.out.print("SPORT: " + bookingList[idx-1].getSport() +
						"\tDAY: " + bookingList[idx-1].getDay() + 
						"\tTIME: " + bookingList[idx-1].getTime() + 
						"\tROOM NUMBER: " + bookingList[idx-1].getRoomNum());
				System.out.println();
				
				for (int j = 0; j < bookingList.length; j++) {
					
					if ( idx <= bookingList.length) {
						
						bookingList = removeElement (bookingList, idx-1);
						
						System.out.print("Your booking deletion is done. \n");
						System.out.print("Your booking list now is: ");
						
						System.out.println();
					} else {
						
						System.out.print("The booling deletion cannot be done. Please enter a valid booking. \n");
						
					}
				}
			}
		}
	}
	*/
	
	/*
	public static void deleteBooking (Booking details) {
		
		String num, id;
		int idx;
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter your id: ");
		id = input.nextLine();
		
		System.out.println();
		System.out.println("Your booking list now is: ");
		
		do {
			
			for (int i = 0; i < details.getBookingList().length; i++) {
				
				if (bookingList[i] != null) {
					
					if (bookingList[i].getId().equals(id)) {
						
						System.out.println((i + 1) + ". " + "SPORT: " + bookingList[i].getSport()
								+ "\tDAY: " + bookingList[i].getDay()
								+ "\tTIME: " + bookingList[i].getTime()
								+ "\t ROOM NUMBER: " + bookingList[i].getRoomNum());
						System.out.println();
						
					} else {
						
						System.out.println("The id cannot be found. Please enter again. ");
					}
				}
				
			}
			
			System.out.println("Enter the booking to be deleted: ");
			num = input.nextLine();
			idx = Integer.parseInt(num);
			
			System.out.println("The booking to be deleted is: " + num + ". ");
			System.out.println("SPORT: " + bookingList[idx-1].getSport()
					+ "\tDAY: " + bookingList[idx-1].getDay()
					+ "\tTIME: " + bookingList[idx-1].getTime()
					+ "\t ROOM NUMBER: " + bookingList[idx-1].getRoomNum());
			System.out.println();
			
			for (int j = 0; j <= bookingList.length; j++) {
				
				if (idx <= details.getBookingList().length) {
					
					bookingList = removeElement(bookingList, idx-1);
					
					System.out.println("Your booking deletion is done. \n");
					System.out.println("Your new booking list is: ");
					System.out.println();
					//System.out.print(Arrays.toString(bookingList));
					
				} else {
					
					System.out.println("The booking cannot be found. Please enter a valid booking. ");
					System.out.println();
				}
			}
		} while (bookingList == null);
		
		System.out.println("The booking deletion cannot be done. ");
	}
	*/
	
	/*
	public static void deleteBooking(Booking details) {
		
		Scanner input = new Scanner (System.in);
		BookingList[] bookingList = details.getBookingList();
		
		System.out.println();
		
		System.out.print("Enter your id: \n");
		String id = input.nextLine();
		
		for (int i = 0; i < details.getBookingList().length; i++) {
			
			if (bookingList[i] != null) {
				
				if (bookingList[i].getId().equals(id)) {
					
					System.out.println("Your booking list now is: ");
					System.out.println((i + 1) + "SPORT: " + bookingList[i].getSport() + 
							"\tDAY: " + bookingList[i].getDay() + 
							"\tTIME: " + bookingList[i].getTime() + 
							"\tROOM NUMBEr: " + bookingList[i].getRoomNum());
					System.out.println();
				}
			}
			
			System.out.println("Enter the booking to be deleted: ");
			String num = input.nextLine();
			int idx = Integer.parseInt(num);
			
			for (int j = 0; j <= bookingList.length; j++) {
				
				if (idx <= bookingList.length) {
					
					bookingList = removeElement (bookingList, idx-1);
					
					System.out.println("Your booking deletion is done.");
					System.out.println();
					System.out.println("Your new booking list is: ");
					System.out.println(bookingList);
					System.out.println();
				} else {
					
					System.out.println("The booking deletion cannot be done.");
					System.out.println();
				}
			}
		}
	}
	*/