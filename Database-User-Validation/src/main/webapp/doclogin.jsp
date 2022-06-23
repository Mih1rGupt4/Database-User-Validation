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
        <link rel="stylesheet" type="text/css" href="resources/doccss.css"> <!-- this is used to link the doc html file to its css counter part -->
                                                                  <!-- link as the name suggests is self explanatory and rel is used to define the link between the given file and the specified file -->
                                                                  <!-- style sheet refers to the css file -->
        <body>
            <div class = "doclogin">  <!-- name of the div section to be used in the css file -->
                <img src="resources/doclogo.png" class="icon">
                <h1>Danmix Hospitals <br> Welcome Doctor!!!!!</h1>
                <form action="ValidateDoctorController" method="post">
                        <p>Doctor ID</p>
                        <input type = "text" placeholder="Enter Doc ID" name = "did">       <!-- Input for doc id -->
                        <p>Password</p>                                                     <!-- Input for doc password -->
                        <input type = "password" placeholder="Enter Password" name = "passw">
                        <input type = "button" value = "login" id= "log" onclick="openpopup()"><br><br>
                </form>
            </div>
            <div class="verification" id="verificat">
                <form action="EmailService" id="formy" method = "post">
                <h3 font="sans-serif" color="White"> Email</h3>
                <input type = "Email" placeholder="Enter Email" name = "docmail"><br>
                <button type = "sendotp">SEND OTP</button><br>
                </form>
                <form action="OTPController" id="formy" method = "post">
                <h3 font="sans-serif" color = "White">OTP</h3>
                <input type = "OTP" placeholder="Enter OTP" name = "otp"><br><br>
                <button type = "button" id ="con" onclick="closepop()">CONFIRM</button>
                </form>
            </div>
        </body>
        <script>
        function openpopup(){
        document.getElementById("verificat").style.top= "50%";
        document.getElementById("verificat").style.transform= "translate(-50%,-50%) scale(1)";
        document.getElementById("verificat").style.visibility= "visible";
        }

        function closepop(){
        document.getElementById("verificat").style.top= "0";
        document.getElementById("verificat").style.transform= "translate(-50%,-50%) scale(0.1)";
        document.getElementById("verificat").style.visibility= "hidden";
        }
    </script>
    </head>
</html>