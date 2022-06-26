<%@page import="java.util.ArrayList"%>
<%@page import="dto.HospitalDto"%>
<%@page import="vo.HospitalVo"%>
<%@page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
        <title>Patients</title>
        <link rel="stylesheet" href="resources/style.css">
    </head>
    <body>
    	<%
			List<HospitalDto> list = (ArrayList<HospitalDto>)request.getAttribute("patientList");
		%>
        <header>
           <img src="resources/doclogo.png">
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
                <h1>Patient Details</h1>
                
                <table style="padding:5px" border="1px">
					<thead> 
						<tr> 
							 <td>Patient ID</td>
							 <td>Patient Name</td>
							 <td>Problem</td>
							 <td>Blood Group</td>
						</tr>		
					</thead>
					<% for(HospitalDto d : list) { %>
							<tr>
								<td> <%=d.getpid() %> </td>
								<td> <%=d.getpName() %> </td>
								<td> <%=d.getpProblem() %> </td>
								<td> <%=d.getpBloodGroup() %> </td>
							</tr>
					 <%}%>
					
				</table>
            </div>
    </body>
</html>