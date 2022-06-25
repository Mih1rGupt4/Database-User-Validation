package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bo.HospitalBo;
import service.HospitalService;
import vo.HospitalVo;

@WebServlet("/ValidateDoctorController")
public class ValidateDoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HospitalService service = null;
    HospitalVo vo = null;
    HospitalBo bo = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service = new HospitalService();
		vo = new HospitalVo();
		bo = new HospitalBo();
		
		vo.setD_id(request.getParameter("d_id").toString());
		vo.setdPassword(request.getParameter("d_pass").toString());
		int key = Integer.parseInt(request.getParameter("radio_key"));
		
		try {
			service.doc_password(key);
			
			System.out.println("count: " + bo.getdCount());
			if(bo.getdCount() > 0) {
				request.getRequestDispatcher("./enter_email.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("./hospital_login.jsp").forward(request, response);
			}
		}
		catch (Exception e) {
			System.out.println("ERROR in VaidateController");
			System.out.println(e);
		}
	}
}
