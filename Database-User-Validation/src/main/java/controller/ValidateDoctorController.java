package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bo.HospitalBo;
import dto.HospitalDto;
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
		
//		read form fields
		vo.setD_id(request.getParameter("d_id"));
		vo.setdPassword(request.getParameter("d_pass"));
		int key;
		try {
			key = Integer.parseInt(request.getParameter("radio_key"));
		}catch (Exception e) {
			key = 0;
		}
		
		try {
//			initiate logic to execute query to get doctor password
//			from the database and verify
			service.doc_password(key);
			
//			check if such doctor id exists which has password same as the input
			
			if(bo.getdCount() > 0 && key == 1) {
				request.getRequestDispatcher("./enter_email.jsp").forward(request, response);
			}
			else if(bo.getdCount() > 0 && key == 0){
				service = new HospitalService();
				List<HospitalDto> list = service.view_patients();
				request.setAttribute("patientList", list);
				getServletContext().getRequestDispatcher("/view_patients.jsp").forward(
		        		request, response);
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
