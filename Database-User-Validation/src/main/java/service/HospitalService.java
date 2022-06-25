package service;

//import java.util.List;
import bo.HospitalBo;
import dto.HospitalDto;

public class HospitalService {
	HospitalDatabaseAccess dao = null;
	HospitalDto dto = null;
    HospitalBo bo = null;
	
	public void doc_password(int key) {
		bo = new HospitalBo();
		dto = new HospitalDto();
		
		// get object of databaseaccess class
		// as the security opetion selected  
		dao = SecurityService.getDaoObject(key);
		dao.getPassword();
		
		// transfer data from databaseaccessobject to the controller
		bo.setdCount(dto.getdCount());
	}
	
}