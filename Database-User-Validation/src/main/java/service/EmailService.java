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
        
    	String recipient = request.getParameter("mail").toString();
        String subject = "Database Login OTP";
        
        OTPController.generateOTP();
        String otp = OTPController.getOTP().toString();
        String content = "Your otp is : " + otp;
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            getServletContext().getRequestDispatcher("/enter_otp.jsp").forward(
                    request, response);
        } catch (Exception ex) {
            //ex.printStackTrace();
            System.out.println("EmailService doPost Error: " + ex);
            ex.printStackTrace();
        } 
        finally {
            
        }
    }
}