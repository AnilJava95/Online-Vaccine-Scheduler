<%@ include file="header.jsp" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="models.Date" import="models.AppointmentDao"
         import="java.util.List"%>

<%
    String vaccineType = request.getParameter("vaccineType");
    String vaccineDose = request.getParameter("vaccineDose");
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String email = request.getParameter("email");
    String location = request.getParameter("location");
    String dateName = request.getParameter("date");

    if (null == vaccineType || null == vaccineDose || "" == name || "" == age 
       || "" == email || null == location || null == dateName)
        request.getRequestDispatcher("addAppointmentForm.jsp").forward(request, response);
%>

<!DOCTYPE html>
<html>
    <head> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="radioButton.css">
    </head>
    <body>
        <div style="margin-left:200px; padding-left:20px">
            <h2>Choose Time</h2> <br>
            <form action="addAppointment" method="post">
                <input type="hidden" name="vaccine" value="<%= request.getParameter("vaccine") %>"/>
                <input type="hidden" name="zipcode" value="<%= request.getParameter("zipcode") %>"/>
                <input type="hidden" name="vaccineType" value="<%= vaccineType %>"/>
                <input type="hidden" name="vaccineDose" value="<%= vaccineDose %>"/>
                <input type="hidden" name="name" value="<%= name %>"/>
                <input type="hidden" name="age" value="<%= age %>"/>
                <input type="hidden" name="email" value="<%= email %>"/>
                <input type="hidden" name="location" value="<%= location %>"/>
                <input type="hidden" name="date" value="<%= dateName %>"/>
        
                <table style="border-spacing: 20px;">
                    <tr>
                        <%
                            Date date = AppointmentDao.getDate(dateName);
                            String timeSlots[] = { date.getTimeSlot1(), date.getTimeSlot2(), 
                            date.getTimeSlot3(), date.getTimeSlot4(), date.getTimeSlot5() };
                            
                            for (int timeSlotIndex = 0; timeSlotIndex <= 4; timeSlotIndex++) {
                                if ("true".equals(timeSlots[timeSlotIndex])) {
                        %>

                        <td>
                            <label class="container"> <%= timeSlotIndex + 8 + ":00"%>
                                <input type="radio" name="timeSlot" value="<%= timeSlotIndex + 1 %>">
                                <span class="checkmark"></span>
                            </label>
                        </td>

                        <%      }
                            }
                        %>
                    </tr>
                </table>

                <input type="submit" value="Submit Form"/>
            </form>
        </div>
    </body>
</html>
