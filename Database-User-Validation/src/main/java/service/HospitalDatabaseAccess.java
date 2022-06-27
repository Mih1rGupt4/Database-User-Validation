package service;

import java.util.ArrayList;
import java.util.List;
import dto.HospitalDto;

public abstract class HospitalDatabaseAccess {
	public abstract void getPassword();
	public abstract void updateOTP();
	public abstract List<HospitalDto> get_Patient_Details();
}
