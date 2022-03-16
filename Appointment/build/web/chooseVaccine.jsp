<%@ include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="radioButton.css">
    </head>

    <body>
        <div style="margin-left:200px; padding-left:20px">
            <h2>Choose Vaccine</h2> <br>

            <form action="chooseZipcode.jsp" method="post">
                <label class="container"> Coronavirus
                <input type="radio" name="vaccine" value="Coronavirus">
                <span class="checkmark"></span>
                </label>
                
                <label class="container"> Flu 
                <input type="radio" name="vaccine" value="Flu">
                <span class="checkmark"></span>
                </label>

                <label class="container"> Shingles 
                <input type="radio" name="vaccine" value="Shingles">
                <span class="checkmark"></span>
                </label>
                
                <label class="container"> Tetanus 
                <input type="radio" name="vaccine" value="Tetanus">
                <span class="checkmark"></span>
                </label>
                
                <label class="container"> Pneumonia
                <input type="radio" name="vaccine" value="Pneumonia">
                <span class="checkmark"></span>
                </label> <br>

                <input type="submit" value="Continue">
            </form>
        </div>
    </body>
</html>
