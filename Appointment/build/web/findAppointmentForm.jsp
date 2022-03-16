<%@ include file="header.jsp" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head> <meta name="viewport" content="width=device-width, initial-scale=1.0"> </head>
    <body>
        <div style="margin-left:200px; padding-left:20px">
            <h2>Find Appointment</h2>
            
            <form action="findAppointmentResult.jsp" method="post">
                <table>
                    <tr> <td>Appointment ID:</td> <td><input type="text" name="id" size="40"/></td> </tr>
                    <tr> <td><input type="submit" value="Find Appointment"/></td> </tr>
                </table>
            </form> <br> <br>
            
            <% if ("true".equals(request.getAttribute("invalidId"))) {
               out.print("Invalid ID.");
            } %>
        </div>
    </body>
</html>
