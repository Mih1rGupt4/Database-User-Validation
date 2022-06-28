package service;

import dao.*;
public class SecurityService {
//	return object of the DatabaseAccess class 
//	based on security option selected
	public static HospitalDatabaseAccess getDaoObject(int key) {
		 if(key == 0) {
			return new HospitalDao_without_security();
			
		 }
		 return new HospitalDao_with_security();
	 }
}
