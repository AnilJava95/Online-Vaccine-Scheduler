package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AppointmentDao;
import models.Appointment;
import models.Date;

public class deleteAppointment extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		Appointment apt = AppointmentDao.find(id);
		Date date = AppointmentDao.getDate(apt.getDate());
		String timeSlot = apt.getTimeSlot();

		int status = AppointmentDao.delete(id);

		if (status > 0) {
			switch (timeSlot) {
				case "0": date.setTimeSlot1("true"); break;
				case "1": date.setTimeSlot2("true"); break;
				case "2": date.setTimeSlot3("true"); break;
				case "3": date.setTimeSlot4("true"); break;
				case "4": date.setTimeSlot5("true"); break;
			}
			AppointmentDao.editDate(date);
			
			request.getRequestDispatcher("findAppointmentForm.jsp").include(request, response);
			out.print("----------------------------- Appointment was deleted.");
		}
		else {
			request.getRequestDispatcher("findAppointmentForm.jsp").include(request, response);
			out.print("----------------------------- Appointment was unable to be deleted.");
		}
	}
}
