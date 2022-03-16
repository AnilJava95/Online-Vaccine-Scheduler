<%@ include file="header.jsp" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="models.Appointment" import="models.AppointmentDao"%>

<%
    String id = request.getParameter("id");
    Appointment apt = AppointmentDao.find(id);
%>

<!DOCTYPE html>
<html>
    <head> <meta name="viewport" content="width=device-width, initial-scale=1.0"> </head>
    <body>
        <div style="margin-left:200px; padding-left:20px">
            <% if (apt.getId() != null) { %>
            <h2>Your appointment</h2>
            <table border='1' width='100%'>
                <tr> <th>ID</th> <th>Vaccine</th> <th>Vaccine Type</th> 
                    <th>Vaccine Dose</th> <th>Name</th> <th>Age</th> </tr>
                
                <tr> <td><%= apt.getId()%></td> <td><%= apt.getVaccine()%></td> 
                    <td><%= apt.getVaccineType()%></td> <td><%= apt.getVaccineDose()%></td> 
                    <td><%= apt.getName()%></td>  <td><%= apt.getAge()%></td> </tr>
                
                <tr> <th>Email</th> <th>Zip Code</th> <th>Location</th> 
                    <th>Date</th> <th>Time</th> <td><form action="editAppointment" method="post">
                        <input type="hidden" name="id" value="<%= id %>"/>
                        <input type="submit" value="Edit"/></form></td> </tr>
                
                <tr>  <td><%= apt.getEmail()%></td> 
                    <td><%= apt.getZipcode()%></td> <td><%= apt.getLocation()%></td> 
                    <td><%= apt.getDate()%></td> <td>
                        <%= Integer.valueOf(apt.getTimeSlot()) + 8 + ":00"%></td>
                    <td><form action="deleteAppointment" method="post">
                        <input type="hidden" name="id" value="<%= id %>"/>
                        <input type="submit" value="Delete"/></form></td> </tr>
            </table>
        <% } %>
        
        <% if (apt.getId() == null) { 
            request.setAttribute("invalidId", "true"); %>
            <jsp:forward page="findAppointmentForm.jsp"/>
        <% } %>
        </div>
    </body>
</html>
