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
	
	private static String otp;
	private static String user_otp;
	public void OTPGenerator() {
		
	}
	
	public static String getOTP() {
		return otp;
	}
	
	public static void setOTP(String pass) {
		otp = pass; 
	}
	
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
        // reads form fields
		String resultMessage = "";
		user_otp = request.getParameter("otp").toString();
		if(otp.equals(user_otp)) {
			resultMessage = "OTP verified";
		}
		else {
			resultMessage = "OTP Failed";
		}
		try {
			request.setAttribute("msg", resultMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print("OTP POST ERROR ="+ex);
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	getServletContext().getRequestDispatcher("/success.jsp").forward(
	        		request, response);
        }
    }
}