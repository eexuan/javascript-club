
public class BookingList 
{
	private String name;
	private String id;
	private String sport;
	private String day;
	private String time;
	private String roomNum;
	
	//constructor
	public BookingList(String name, String id, String sport, String day, String time, String roomNum)
	{
		this.name = name;
		this.id = id;
		this.sport = sport;
		this.day = day;
		this.time = time;
		this.roomNum = roomNum;
	}
	
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
	
	public void setDay(String aDay)
	{
		day = aDay;
	}
	
	public void setTime(String aTime)
	{
		time = aTime;
	}
	
	public void setRoomNum(String aRoomNum)
	{
		roomNum = aRoomNum;
	}

}
