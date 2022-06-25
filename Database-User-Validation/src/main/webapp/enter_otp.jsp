<!-- comments have been written in the necessary places so that it becomes easier for you to understand in case you have any queries dm me -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
        <title>
            Doctor Login Page
        </title>
        <link rel="stylesheet" type="text/css" href="resources/hospital.css"> <!-- this is used to link the doc html file to its css counter part -->
                                                                  <!-- link as the name suggests is self explanatory and rel is used to define the link between the given file and the specified file -->
                                                                  <!-- style sheet refers to the css file -->
        <body>
            <div class = "doclogin">  <!-- name of the div section to be used in the css file -->
                <img src="resources/doclogo.png" class="icon">
                <h1>Danmix Hospitals<br> Welcome Doctor!!!!!</h1>
                <form action="OTPController" method="post">
                        <p>Enter OTP</p>                                               
                        <input type = "text" placeholder="Enter OTP" name = "otp">
                        <input type = "submit" value = "Login" id= "otp">
                </form>
            </div>
    </body>
    </head>
</html>