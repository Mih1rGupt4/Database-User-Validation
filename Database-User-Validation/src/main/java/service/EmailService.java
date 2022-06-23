package service;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import util.EmailUtility;
import controller.OTPController;

@WebServlet("/EmailService")
public class EmailService extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
    	ServletContext contex = getServletContext();
        host = contex.getInitParameter("host");
        port = contex.getInitParameter("port");
        user = contex.getInitParameter("user");
        pass = contex.getInitParameter("pass");
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
        String recipient = request.getParameter("docmail");
//        String subject = request.getParameter("subject");
//        String content = request.getParameter("content");
        String subject = "Database User Validation OTP : ";
        String content = "Your otp is : " + OTPController.generateOTP();
 
//        String resultMessage = "";
 
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
//            resultMessage = "The e-mail was sent successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
//            resultMessage = "There were an error: " + ex.getMessage();
        } 
//        finally {
//            getServletContext().getRequestDispatcher("/Result.jsp").forward(
//                    request, response);
//        }
    }
}