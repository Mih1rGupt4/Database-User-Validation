<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
        <title>Patients</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <header>
           <img src="doclogo.png">
            <nav>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Patients</a></li>
                    <li><a href="#">Doctors</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>
            </nav>
        </header>
            <div class = "doctor">
                <img src="">
                <h1> Doctor</h1>
                <h3>Name:</h3><h4></h4><br><br>
                <h3>DOB:</h3><h4></h4><br><br>
                <h3>Blood Group:</h3><h4></h4><br><br>
                <h3>Speciality:</h3><h4></h4><br><br>
                </div>
            <div class = "patients">
                <img src="">
                <h1>Patient Details</h1>
                <table>
                    <tr>
                        <th>Name</th>
                        <th>DOB</th>
                        <th>Blood Group</th>
                        <th>Medical Issue</th>
                    </tr>
                    <tr>
                        <!-- FETCHING DATA FROM EACH
                            ROW OF EVERY COLUMN -->
                        <td>James</td>
                        <td>1999</td>
                        <td>0</td>
                        <td>Diabetes</td>
                    </tr>
                </table>
            </div>
    </body>
</html>