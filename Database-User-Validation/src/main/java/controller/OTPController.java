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
	protected static String user_otp;
	public void OTPGenerator() {
		
	}
	public static String generateOTP() {
	      String numbers = "1234567890";
	      Random random = new Random();
	      String gen_otp = "";

	      for(int i = 0; i< 4 ; i++) {
	         gen_otp += numbers.charAt(random.nextInt(numbers.length()));
	      }
	      otp = gen_otp;
	      return gen_otp;
	}
	
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // reads form fields
		String resultMessage = "";
		user_otp = request.getParameter("otp");
		
		if(otp.equals(user_otp)) {
			resultMessage = "OTP verified";
		}
		else {
			resultMessage = "OTP Failed";
		}
		request.setAttribute("msg", resultMessage);
        getServletContext().getRequestDispatcher("/success.jsp").forward(
        		request, response);
//		try {
//			
//			
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            System.out.print("SOME ERROR ==="+ex);
//            resultMessage = "There were an error: " + ex.getMessage();
//        } finally {
//            
//        }
    }
}