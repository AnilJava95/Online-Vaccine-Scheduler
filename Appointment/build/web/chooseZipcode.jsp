<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String vaccine = request.getParameter("vaccine");
    if (vaccine == null)
        request.getRequestDispatcher("chooseVaccine.jsp").forward(request, response);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" href="radioButton.css">
    </head>

    <body>
        <div style="margin-left:200px; padding-left:20px">
            <h2>Enter Zip Code</h2>

            <form action="addAppointmentForm.jsp" method="post">
                <input type="hidden" name="vaccine" value="<%= vaccine %>"/>
                <input type="text" name="zipcode" style="margin: 10px;">
                <input type="submit" value="Continue">
            </form>
            
            <% if ("true".equals(request.getAttribute("invalidZipcode"))) {
                out.print("<br> There are no vaccination locations for this zipcode.");
            } %>
        </div>
    </body>
</html>
