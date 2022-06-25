package service;

import dao.*;
public class SecurityService {
	 public static HospitalDatabaseAccess getDaoObject(int key) {
		 if(key == 0) {
			return new HospitalDao_without_security();
			
		 }
		 else if (key == 1){
			 return new HospitalDao_with_security();
		}
		 else {
			 return null;
		 }
	 }
}
