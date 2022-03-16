package models;

public class Appointment
{
	private String id;
	private String vaccine;
	private String zipcode;
	private String vaccineType;
	private String vaccineDose;
	private String name;
	private String age;
	private String email;
	private String location;
	private String date;
	private String timeSlot;
	
	public Appointment() { }

	public Appointment(String id, String vaccine, String zipcode, 
		String vaccineType, String vaccineDose, String name, String age, 
		String email, String location, String date, String timeSlot)
	{
		this.id = id;
		this.vaccine = vaccine;
		this.zipcode = zipcode;
		this.vaccineType = vaccineType;
		this.vaccineDose = vaccineDose;
		this.name = name;
		this.age = age;
		this.email = email;
		this.location = location;
		this.date = date;
		this.timeSlot = timeSlot;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getVaccine()
	{
		return vaccine;
	}

	public void setVaccine(String vaccine)
	{
		this.vaccine = vaccine;
	}

	public String getZipcode()
	{
		return zipcode;
	}

	public void setZipcode(String zipcode)
	{
		this.zipcode = zipcode;
	}

	public String getVaccineType()
	{
		return vaccineType;
	}

	public void setVaccineType(String vaccineType)
	{
		this.vaccineType = vaccineType;
	}

	public String getVaccineDose()
	{
		return vaccineDose;
	}

	public void setVaccineDose(String vaccineDose)
	{
		this.vaccineDose = vaccineDose;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age)
	{
		this.age = age;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getTimeSlot()
	{
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot)
	{
		this.timeSlot = timeSlot;
	}
}
