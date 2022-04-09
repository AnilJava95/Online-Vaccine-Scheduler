package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

public class AppointmentDao
{
	public static Connection getConnection()
	{
		Connection con = null;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

		return con;
	}

	public static int add(Appointment apt)
	{
		int status = 0;
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"insert into appointment(id,vaccine,zipcode,vaccineType,vaccineDose,"
					+ "name,age,email,location,date,timeSlot) values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, apt.getId());
			ps.setString(2, apt.getVaccine());
			ps.setString(3, apt.getZipcode());
			ps.setString(4, apt.getVaccineType());
			ps.setString(5, apt.getVaccineDose());
			ps.setString(6, apt.getName());
			ps.setString(7, apt.getAge());
			ps.setString(8, apt.getEmail());
			ps.setString(9, apt.getLocation());
			ps.setString(10, apt.getDate());
			ps.setString(11, apt.getTimeSlot());
			

			status = ps.executeUpdate();

			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return status;
	}

	public static Appointment find(String id)
	{
		Appointment apt = new Appointment();
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from appointment where id=?");
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				apt = new Appointment(rs.getString(1), rs.getString(2), rs.getString(3) 
				, rs.getString(4) , rs.getString(5) , rs.getString(6) , rs.getString(7) 
				, rs.getString(8) , rs.getString(9) , rs.getString(10) , rs.getString(11));
			}

			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return apt;
	}

	/*public static int edit(Appointment apt)
	{
		int status = 0;
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"update appointment set id=?,name=?,email=? where id=?");
			ps.setString(1, apt.getId());
			ps.setString(2, apt.getName());
			ps.setString(3, apt.getEmail());
			ps.setString(4, apt.getId());

			status = ps.executeUpdate();

			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return status;
	}*/

	public static int delete(String id)
	{
		int status = 0;
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from appointment where id=?");
			ps.setString(1, id);

			status = ps.executeUpdate();

			con.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return status;
	}

	public static List<Location> getLocations(String zipcode)
	{
		List<Location> locations = new ArrayList<>();
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from location where zipcode=?");
			ps.setString(1, zipcode);

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Location location = new Location(rs.getString(1), rs.getString(2), rs.getString(3));
				locations.add(location);
			}

			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return locations;
	}
	
	public static List<Date> getDates()
	{
		List<Date> dates = new ArrayList<>();
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from date");

			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				Date date = new Date(rs.getString(1), rs.getString(2), rs.getString(3),
				   rs.getString(4), rs.getString(5), rs.getString(6));
				// Check if at least one timeSlot if available (true)
				if ("true".equals(date.getTimeSlot1()) || "true".equals(date.getTimeSlot2()) 
					|| "true".equals(date.getTimeSlot3()) || "true".equals(date.getTimeSlot4()) 
					|| "true".equals(date.getTimeSlot5()))
				dates.add(date);
			}

			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return dates;
	}
	
		public static Date getDate(String name)
	{
		Date date = new Date();
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from date where name=?");
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			if (rs.next())
			{
				date = new Date(rs.getString(1), rs.getString(2), rs.getString(3),
				   rs.getString(4), rs.getString(5), rs.getString(6));
			}

			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return date;
	}
		
	public static int editDate(Date date)
	{
		int status = 0;
		try
		{
			Connection con = AppointmentDao.getConnection();
			PreparedStatement ps = con.prepareStatement(
				"update date set name=?,timeSlot1=?,timeSlot2=?,timeSlot3=?"
					+ ",timeSlot4=?,timeSlot5=? where name=?");
			ps.setString(1, date.getName());
			ps.setString(2, date.getTimeSlot1());
			ps.setString(3, date.getTimeSlot2());
			ps.setString(4, date.getTimeSlot3());
			ps.setString(5, date.getTimeSlot4());
			ps.setString(6, date.getTimeSlot5());
			ps.setString(7, date.getName());

			status = ps.executeUpdate();

			con.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return status;
	}
}
