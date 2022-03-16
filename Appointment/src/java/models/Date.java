package models;

public class Date
{
	private String name;
	private String timeSlot1;
	private String timeSlot2;
	private String timeSlot3;
	private String timeSlot4;
	private String timeSlot5;

	public Date() { }

	public Date(String name, String timeSlot1, String timeSlot2, String timeSlot3, 
		String timeSlot4, String timeSlot5)
	{
		this.name = name;
		this.timeSlot1 = timeSlot1;
		this.timeSlot2 = timeSlot2;
		this.timeSlot3 = timeSlot3;
		this.timeSlot4 = timeSlot4;
		this.timeSlot5 = timeSlot5;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTimeSlot1()
	{
		return timeSlot1;
	}

	public void setTimeSlot1(String timeSlot1)
	{
		this.timeSlot1 = timeSlot1;
	}

	public String getTimeSlot2()
	{
		return timeSlot2;
	}

	public void setTimeSlot2(String timeSlot2)
	{
		this.timeSlot2 = timeSlot2;
	}

	public String getTimeSlot3()
	{
		return timeSlot3;
	}

	public void setTimeSlot3(String timeSlot3)
	{
		this.timeSlot3 = timeSlot3;
	}

	public String getTimeSlot4()
	{
		return timeSlot4;
	}

	public void setTimeSlot4(String timeSlot4)
	{
		this.timeSlot4 = timeSlot4;
	}

	public String getTimeSlot5()
	{
		return timeSlot5;
	}

	public void setTimeSlot5(String timeSlot5)
	{
		this.timeSlot5 = timeSlot5;
	}

	
}

/* This uses a list to keep timeslots but how will we keep that list in the database?

package models;

import java.util.ArrayList;
import java.util.List;

public class Date
{
	private String name;
	private List<Boolean> timeSlots = new ArrayList<>();

	public Date() { }

	public Date(String name, List<Boolean> timeSlots)
	{
		this.name = name;
		this.timeSlots = timeSlots;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Boolean> getTimeSlots()
	{
		return timeSlots;
	}

	public void setTimeSlots(List<Boolean> timeSlots)
	{
		this.timeSlots = timeSlots;
	}
}

*/