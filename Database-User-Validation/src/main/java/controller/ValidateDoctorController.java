package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dto.DoctorDto;
import service.DoctorService;

@WebServlet("/ValidateDoctorController")
public class ValidateDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    DoctorService service = null;  
    DoctorDto dto = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String doctor_id = request.getParameter("did");
		String doctor_pass = (String)request.getParameter("pass");
		service = new DoctorService();
		String password = "";
		try {
			password = service.password(doctor_id);
			if(doctor_pass.equals(password)) {
				request.getRequestDispatcher("./success.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("./failure.jsp").forward(request, response);
			}
		}
		catch (Exception e) {
			System.out.println("ERROR!!!!!!!!!!");
			System.out.println(e);
		}
	}
}
