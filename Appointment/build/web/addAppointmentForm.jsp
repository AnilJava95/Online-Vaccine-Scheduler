<%@ include file="header.jsp" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="models.Location" import="models.Date" 
         import="models.AppointmentDao" import="java.util.List"%>

<%
    String zipcode = request.getParameter("zipcode");
    if ("".equals(zipcode))
        request.getRequestDispatcher("chooseZipcode.jsp").forward(request, response);
    
    List<Location> locations = AppointmentDao.getLocations(zipcode);
    if (locations.size() == 0) {
        request.setAttribute("invalidZipcode", "true");
        request.getRequestDispatcher("chooseZipcode.jsp").forward(request, response);
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="radioButton.css">
    </head>
    <body>
        <div style="margin-left:200px; padding-left:20px">
            <h2>Appointment Details</h2> <br>
            <form action="chooseTime.jsp" method="post">
                <input type="hidden" name="vaccine" value="<%= request.getParameter("vaccine") %>"/>
                <input type="hidden" name="zipcode" value="<%= zipcode %>"/>

                <h3>Vaccine Type</h3>
                <table style="border-spacing: 20px;">
                    <tr>
                        <td>
                            <label class="container"> Pfizer
                                <input type="radio" name="vaccineType" value="Pfizer">
                                <span class="checkmark"></span>
                            </label>
                        </td>
                        <td>
                            <label class="container"> Moderna
                                <input type="radio" name="vaccineType" value="Moderna">
                                <span class="checkmark"></span>
                            </label>
                        </td>
                        <td>
                            <label class="container"> J&J
                                <input type="radio" name="vaccineType" value="J&J">
                                <span class="checkmark"></span>
                            </label>
                        </td>
                    </tr>
                </table>

                <h3>Vaccine Dose</h3>
                <table style="border-spacing: 20px;">
                    <tr>
                        <td>
                            <label class="container"> Dose 1
                                <input type="radio" name="vaccineDose" value="Dose 1">
                                <span class="checkmark"></span>
                            </label>
                        </td>
                        <td>
                            <label class="container"> Dose 2
                                <input type="radio" name="vaccineDose" value="Dose 2">
                                <span class="checkmark"></span>
                            </label>
                        </td>
                        <td>
                            <label class="container"> Booster Dose
                                <input type="radio" name="vaccineDose" value="Booster Dose">
                                <span class="checkmark"></span>
                            </label>
                        </td>
                    </tr>
                </table>

                <h3>Personal Information</h3>
                <table style="border-spacing: 10px;">
                    <tr> <td>Name:</td><td><input type="text" name="name"/></td> </tr>
                    <tr> <td>Age:</td><td><input type="text" name="age"/></td> </tr>
                    <tr> <td>Email:</td><td><input type="email" name="email"/></td> </tr>
                </table> <br>

                <h3>Location</h3> <br>
                <table>
                <%  for (Location location : locations) { %>
                    <tr>
                        <td>
                            <label class="container"> <%= location.getName() + ": " + location.getAddress() %>
                                <input type="radio" name="location" value="<%= location.getAddress() %>">
                                <span class="checkmark"></span>
                            </label>
                        </td>
                    </tr>
                <%  } %>
                </table> <br>
                
                <h3>Date</h3>
                <table style="border-spacing: 20px;">
                    <tr>
                        <%
                            List<Date> dates = AppointmentDao.getDates();
                            for (Date date : dates) {
                        %>
                            <td>
                                <label class="container"> <%= date.getName()%>
                                    <input type="radio" name="date" value="<%= date.getName()%>">
                                    <span class="checkmark"></span>
                                </label>
                            </td>
                        <%  } %>
                    </tr>
                </table>
                
                <input type="submit" value="Continue"/>
            </form>
        </div>
    </body>
</html>
