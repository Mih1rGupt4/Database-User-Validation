<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Send an e-mail</title>
</head>
<!-- <script type="text/javascript"> -->

<!-- </script> -->
<body>

    <form action="EmailService" method="post">
        <table border="2" width="35%" align="center">
            <caption><h2 align = "left">Enter Email ID</h2></caption>
            <tr>
                <td width="20%">Enter e-mail id :</td>
                <td><input type="text" name="recipient" size="62"/></td>
                <td colspan="2" align="right"><input type="submit" value="Send"/></td>
            </tr>
        </table>
</body>
</html>