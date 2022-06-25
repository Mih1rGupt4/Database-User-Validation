package controller;

import java.util.Random;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/OTPController")
public class OTPController extends HttpServlet{
	// Logic to generate and verify the otp
	private static String otp;
	private static String user_otp;
	
	public static String getOTP() {
		return otp;
	}
	public static void setOTP(String pass) {
		otp = pass; 
	}
	
	// function that generates OTP
	public static void generateOTP() {
	      String numbers = "1234567890";
	      Random random = new Random();
	      String gen_otp = "";

	      for(int i = 0; i< 4 ; i++) {
	         gen_otp += numbers.charAt(random.nextInt(numbers.length()));
	      }
	      OTPController.setOTP(gen_otp);
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		
		String resultMessage = "";
        
		// read form fields
		user_otp = request.getParameter("otp").toString();
		
		// Verifying if user otp input matches
		if(otp.equals(user_otp)) {
			resultMessage = "OTP verified";
			request.setAttribute("msg", resultMessage);
			getServletContext().getRequestDispatcher("/view_patients.jsp").forward(
	        		request, response);
		}
		else {
			getServletContext().getRequestDispatcher("/failure.jsp").forward(
	        		request, response);
		}
    }
}