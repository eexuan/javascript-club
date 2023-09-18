import java.util.Scanner;

public class User 
{
	private MemberProfile[] memberList;
	private int numberOfMembers;
	private static int MAX_NUMBER_OF_MEMBERS = 100;
	
	private AdminProfile admin;
	private MemberProfile member;
	
	//constructor
	public User()
	{
		numberOfMembers = 0;
		memberList = new MemberProfile[MAX_NUMBER_OF_MEMBERS];
		
		admin = new AdminProfile();
	}
	
	public MemberProfile[] getMemberList()
	{
		return memberList;
	}
	
	public int getNumberOfMembers()
	{
		return numberOfMembers;
	}
	
	public void register(MemberProfile m)
	{
		if(numberOfMembers < MAX_NUMBER_OF_MEMBERS)
		{
			memberList[numberOfMembers] = m;
			numberOfMembers++;			
		}
		else
			System.out.println("Our club is full");
	}
	
	public AdminProfile getAdminInfo()
	{
		return admin;
	}
	
	public MemberProfile getMemberInfo()
	{
		return member;
	}
	
	public MemberProfile getMemberInfo(MemberProfile mem)
	{
		return member = mem;
	}

}
