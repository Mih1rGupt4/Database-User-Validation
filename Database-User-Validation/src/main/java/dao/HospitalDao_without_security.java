package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.OTPController;
import vo.HospitalVo;
import dto.HospitalDto;
import util.DataBaseConnection;
import service.HospitalDatabaseAccess;

public class HospitalDao_without_security extends HospitalDatabaseAccess {

	private String PASSWORD_VALIDATE_QUERY = "select dPassword from doctor where dId=";
	private String UPDATE_OTP_QUERY = "update doctor set otp = ";
	private String VIEW_PATIENT_DETAILS_QUERY = "select pid, pname, pprob, pbgrp from patient;";
	HospitalDto dto = null;
	HospitalVo vo = null;
	Connection connect = null;
	Statement stmt = null;  
    PreparedStatement psmt = null;
    
    @Override
	public void updateOTP() {
		try {
			connect = DataBaseConnection.getConnection(); 
			stmt = connect.createStatement();
			UPDATE_OTP_QUERY = "update doctor set otp = " + Integer.parseInt(OTPController.getOTP().trim())+ " where dId = '" + vo.getD_id()+"';";
			
			ResultSet rs = stmt.executeQuery(UPDATE_OTP_QUERY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
	@Override
	public void getPassword() {
		// do database operation logic 
		dto = new HospitalDto();
		vo = new HospitalVo();
		try {
			// connection to database
			// and execute given SQL query
			PASSWORD_VALIDATE_QUERY = "select count(dId) from doctor where dId = '" + vo.getD_id() + "' and dPassword ='"+ vo.getdPassword() + "';";
			
			connect = DataBaseConnection.getConnection(); 
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(PASSWORD_VALIDATE_QUERY);
			
			//storing the resultant table values in the model class
			if(rs.next()) {
				dto.setdCount(rs.getInt(1));
			}
			else {
				System.out.println("else from unsecure");
			}
		}
		catch (Exception e) {
			System.out.println("Error in Dao w/t sec"+e);
		}
	}
	
	@Override
	public ArrayList<HospitalDto> get_Patient_Details() {
		HospitalDto dto = null;
		ArrayList<HospitalDto> patients_List = new ArrayList<HospitalDto>();
		
		try {
			dto = new HospitalDto();
			vo = new HospitalVo();
			
			// connection to database
			// and execute given SQL query
			connect = DataBaseConnection.getConnection(); 
			stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery(VIEW_PATIENT_DETAILS_QUERY);
			
			//storing the resultant table values in the model dto class
			while(rs.next()) {
				dto = new HospitalDto();
				dto.setpid(rs.getString(1));
				dto.setpName(rs.getString(2));
				dto.setpProblem(rs.getString(3));
				dto.setpBloodGroup(rs.getString(4));
				patients_List.add(dto);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return patients_List;
	}
}
