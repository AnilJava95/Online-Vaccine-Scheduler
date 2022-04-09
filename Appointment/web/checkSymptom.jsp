<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head> <meta name="viewport" content="width=device-width, initial-scale=1.0"> </head>
    <body>
        <div style="margin-left:200px; padding-left:20px">
            <h2>Symptom Check</h2>
            
            <p> Vaccine appointments are unavailable for people with symptoms. <br>
                Do you have any symptoms of coronavirus?</p>
            
            <button style="margin:10px"> <a href="findAppointmentForm.jsp" style="text-decoration: none"> Yes </a> </button>
            <button style="margin:10px"> <a href="chooseVaccine.jsp" style="text-decoration: none"> No </a> </button>
        </div>
    </body>
</html>
