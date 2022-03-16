package models;

public class Location
{
	private String name;
	private String address;
	private String zipcode;
	
	public Location() { }
	
	public Location(String name, String address, String zipcode)
	{
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getZipcode()
	{
		return zipcode;
	}

	public void setZipcode(String zipcode)
	{
		this.zipcode = zipcode;
	}
}
