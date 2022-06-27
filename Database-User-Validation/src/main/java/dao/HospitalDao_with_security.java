package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import controller.OTPController;
import dto.HospitalDto;
import service.HospitalDatabaseAccess;
import util.DataBaseConnection;
import vo.HospitalVo;

public class HospitalDao_with_security extends HospitalDatabaseAccess {
	
	private final String PASSWORD_VALIDATE_QUERY = "select count(dId) from doctor where dId= ? and dPassword= ?;";
	private final String UPDATE_OTP_QUERY = "update doctor set otp = ? where dId = ?";
	private final String VIEW_PATIENT_DETAILS_QUERY = "select pid, pname, pprob, pbgrp from patient";
	private final String VIEW_DOCTOR_DETAILS_QUERY = "select dName, dspecialtly, dbgrp from doctor";
	HospitalDto dto = null;
	HospitalVo vo = null;
	Connection connect = null;
	
	@Override
	public void updateOTP() {
		try {
			connect = DataBaseConnection.getConnection(); 
			PreparedStatement ps = connect.prepareStatement(UPDATE_OTP_QUERY);
			ps.setInt(1, Integer.parseInt(OTPController.getOTP().trim()));
			ps.setString(2, vo.getD_id().trim());
			
			ResultSet rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void getPassword() {
		// database operation logic
		try {
			dto = new HospitalDto();
			vo = new HospitalVo();
			
			// connection to database
			// and execute given SQL query
			connect = DataBaseConnection.getConnection(); 
			PreparedStatement ps = connect.prepareStatement(PASSWORD_VALIDATE_QUERY);
			
			// typecaste values to SQL datatypes
			// String to varchar()
			// the entire string will be read as a varchar by the database
			ps.setString(1, vo.getD_id().trim());
			ps.setString(2, vo.getdPassword().trim());
			ResultSet rs = ps.executeQuery();
			
			//storing the resultant table values in the model dto class
			if(rs.next()) {
				dto.setdCount(rs.getInt(1));
			}
			else {
				dto.setdCount(-1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<HospitalDto> get_Patient_Details() {
		HospitalDto dto = null;
		List<HospitalDto> patients_List = new ArrayList<HospitalDto>();
		
		try {
			dto = new HospitalDto();
			vo = new HospitalVo();
			
			// connection to database
			// and execute given SQL query
			connect = DataBaseConnection.getConnection(); 
			PreparedStatement ps = connect.prepareStatement(VIEW_PATIENT_DETAILS_QUERY);
			ResultSet rs = ps.executeQuery();
			
			//storing the resultant table values in the model dto class
			while(rs.next()) {
				dto = new HospitalDto();
				dto.setpid(rs.getString(1));
				dto.setpName(rs.getString(2));
				dto.setpProblem(rs.getString(3));
				dto.setpBloodGroup(rs.getString(4));
				patients_List.add(dto);
//				System.out.println(patients_List);
			}
			
			for(HospitalDto d: patients_List) {
				System.out.println("id" + d.getpid());
			}
			
			PreparedStatement ps1 = connect.prepareStatement(VIEW_DOCTOR_DETAILS_QUERY);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				vo.setdName(rs1.getString(1));
				vo.setdSpecialty(rs1.getString(2));
				vo.setdBloodGrp(rs1.getString(3));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return patients_List;
	}
}