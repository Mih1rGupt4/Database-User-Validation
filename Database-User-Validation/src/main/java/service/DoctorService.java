package service;

import java.util.List;

import bo.DoctorBo;
import dao.DoctorDao;
import dto.DoctorDto;
import vo.DoctorVo;

public class DoctorService {
	DoctorDao doctorDao = null;
//	DoctorBo doctorBo = null;
	
//	public int saveStudent(DoctorVo doctorvo) {
//		// business operation
//		doctorDao = new DoctorDao();
//		doctorBo = new DoctorBo();
//		
//		doctorBo.set_did(doctorvo.get_did());
//		doctorBo.setdName(doctorvo.getdName());
//		doctorBo.setdPassword(doctorvo.getdPassword());
//		doctorBo.setdSpecialty(doctorvo.getdSpecialty());
//		doctorBo.setpid(doctorvo.getpid());
//		
//		
//		int i = doctorDao.addStudent(doctorBo);
//		return i;
//	}
	
//	public List<DoctorDto> getAllStudents() {
//		doctorDao = new DoctorDao();
//		return doctorDao.viewStudents();
//	}
//	
//	public boolean removeStudent(int rollNumber) {
//		doctorDao = new DoctorDao();
//		return doctorDao.delete(rollNumber);
//	}
//	
//	public DoctorDto searchStudent(int rollNumber) {
//		doctorDao = new DoctorDao();
//		return doctorDao.getDetails(rollNumber);
//	}
	
	public String password(String d_id) {
		doctorDao = new DoctorDao();
		return doctorDao.getPassword(d_id);
	}
	
}