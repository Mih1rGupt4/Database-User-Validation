package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.HospitalVo;
import dto.HospitalDto;
import util.DataBaseConnection;
import service.HospitalDatabaseAccess;

public class HospitalDao_with_security extends HospitalDatabaseAccess {
	
	private final String VALIDATE_PASSWORD = "select count(dId) from doctor where dId= ? and dPassword= ?;";
//	private final String SAVE_STUDENT = "insert into doctor(did, dname, password, specialty) values(?,?,?,?)";
//	private final String VIEW_STUDENT = "select roll_number, name, gender, course from student";
//	private final String DELETE_STUDENT = "delete from student where roll_number=?";
//	private final String SEARCH_STUDENT = "select roll_number, name, gender, course from student where roll_number=?";
//	private final String UPDATE_STUDENT = "update student set name=?, gender=?, course=? where roll_number=?";
	HospitalDto dto = null;
	HospitalVo vo = null;
	Connection connect = null;
	
	@Override
	public void getPassword() {
		// do database operation logic
		try {
			dto = new HospitalDto();
			vo = new HospitalVo();
			connect = DataBaseConnection.getConnection(); 
			PreparedStatement ps = connect.prepareStatement(VALIDATE_PASSWORD);
			ps.setString(1, vo.getD_id().trim());
			ps.setString(2, vo.getdPassword().trim());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto.setdCount(rs.getInt(1));
			}
			else {
				System.out.println("else block from secure");
			}
		}
		catch (Exception e) {
			System.out.println("Error in Dao try "+e);
		}
	}
	
//	public List<HospitalDto> viewStudents(){
//		HospitalDto dto = null;
//		List<HospitalDto> studentList = new ArrayList<HospitalDto>();
//		
//		try {
//			Connection connect = DataBaseConnection.getConnection(); 
//			PreparedStatement ps = connect.prepareStatement(VIEW_STUDENT);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				 dto = new HospitalDto();
//				 dto.setStudentRollNumber(rs.getInt(1));
//				 dto.setStudentName(rs.getString(2));
//				 dto.setStudentGender(rs.getString(3));
//				 dto.setStudentCourse(rs.getString(4));
//				 studentList.add(dto);
//			}
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		
//		return studentList;
//	}

//	public HospitalDto getDetails(int rollNumber) {
//		HospitalDto dto = null;
//		try {
//			Connection connect = DataBaseConnection.getConnection(); 
//			PreparedStatement ps = connect.prepareStatement(SEARCH_STUDENT);
//			ps.setInt(1, rollNumber);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				 dto = new HospitalDto();
//				 dto.setStudentRollNumber(rs.getInt(1));
//				 dto.setStudentName(rs.getString(2));
//				 dto.setStudentGender(rs.getString(3));
//				 dto.setStudentCourse(rs.getString(4));
//				 
//			}
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		
//		return dto;
//	}

}