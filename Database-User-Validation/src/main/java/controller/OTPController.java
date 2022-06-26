package controller;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Random;

import dto.HospitalDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.HospitalService;

@WebServlet("/OTPController")
public class OTPController extends HttpServlet{
	// Logic to generate and verify the otp
	private static String otp;
	private static String user_otp;
	private static long timestamp;
	
	HospitalService service = null;
	
	public static String getOTP() {
		return otp;
	}
	public static void setOTP(String pass) {
		otp = pass; 
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
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
		
		// store sever time in unix timestamp
		Instant t1 = Instant.now();
        long cur_timestamp = t1.getEpochSecond();

        // check if user took more than 60 seconds to enter OTP
        if(cur_timestamp - timestamp > 61) {
        	getServletContext().getRequestDispatcher("/enter_email.jsp").forward(
	        		request, response);
        }
		
        // Verifying if user otp input matches
		if(otp.equals(user_otp)) {
//			resultMessage = "OTP verified";
//			request.setAttribute("msg", resultMessage);
			service = new HospitalService();
			List<HospitalDto> list = service.view_patients();
			request.setAttribute("patientList", list);
			getServletContext().getRequestDispatcher("/view_patients.jsp").forward(
	        		request, response);
		}
		else {
			getServletContext().getRequestDispatcher("/enter_email.jsp").forward(
	        		request, response);
		}
    }
}