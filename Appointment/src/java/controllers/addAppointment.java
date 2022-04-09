package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Appointment;
import models.AppointmentDao;
import models.Date;
import java.util.UUID;

public class addAppointment extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String timeSlot = request.getParameter("timeSlot");

		if (timeSlot == null) {
			request.getRequestDispatcher("chooseTime.jsp").forward(request, response);
		}
		else {
			String id = UUID.randomUUID().toString();
			Appointment apt = new Appointment(id, request.getParameter("vaccine"), 
				request.getParameter("zipcode"), request.getParameter("vaccineType"), 
				request.getParameter("vaccineDose"), request.getParameter("name"), 
				request.getParameter("age"), request.getParameter("email"), 
				request.getParameter("location"), request.getParameter("date"), 
				request.getParameter("timeSlot"));

			int status = AppointmentDao.add(apt);

			if (status > 0) {
				Date date = AppointmentDao.getDate(request.getParameter("date"));
				switch (timeSlot) {
					case "1": date.setTimeSlot1("false"); break;
					case "2": date.setTimeSlot2("false"); break;
					case "3": date.setTimeSlot3("false"); break;
					case "4": date.setTimeSlot4("false"); break;
					case "5": date.setTimeSlot5("false"); break;
				}
				AppointmentDao.editDate(date);

				request.getRequestDispatcher("findAppointmentResult.jsp?id=" + id).include(request, response);
				out.print("<br> ----------------------------- Appointment was scheduled. "
					+ "<b style=\"color:red\"> Save your appointment ID </b> to "
					+ "view, edit, and delete your appointment later.");
			}
			else {
				request.getRequestDispatcher("addAppointmentForm.jsp").include(request, response);
				out.println("----------------------------- Appointment was not able to be scheduled.");
			}
		}

		out.close();
	}
}
