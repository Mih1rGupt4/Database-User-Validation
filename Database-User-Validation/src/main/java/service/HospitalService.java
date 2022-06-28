package service;

import java.util.List;

import bo.HospitalBo;
import dto.HospitalDto;
import dao.HospitalDao_with_security;

public class HospitalService {
	HospitalDatabaseAccess dao = null;
	HospitalDto dto = null;
    HospitalBo bo = null;
	
	public void doc_password(int key) {
		bo = new HospitalBo();
		dto = new HospitalDto();
		
//		get object of databaseaccess class
//		as the security option selected  
		dao = SecurityService.getDaoObject(key);
		dto = dao.getPassword();
		
//		transfer data from databaseaccessobject to the controller
		bo.setdCount(dto.getdCount());
	}
	
	public List<HospitalDto> view_patients(){
		dao = new HospitalDao_with_security();
		return dao.get_Patient_Details();
	}
	
}