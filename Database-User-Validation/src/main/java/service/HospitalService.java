package service;

//import java.util.List;
import bo.HospitalBo;
import dto.HospitalDto;

public class HospitalService {
	HospitalDatabaseAccess dao = null;
	HospitalDto dto = null;
    HospitalBo bo = null;
    
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
	
	public void doc_password(int key) {
		bo = new HospitalBo();
		dto = new HospitalDto();
		
		dao = SecurityService.getDaoObject(key);
		dao.getPassword();
		
		bo.setdCount(dto.getdCount());
	}
	
}