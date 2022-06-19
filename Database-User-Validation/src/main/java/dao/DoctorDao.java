package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import bo.DoctorBo;
import dto.DoctorDto;
import util.DataBaseConnection;
//import java.util.*;

public class DoctorDao {
	
	private final String VALIDATE_PASSWORD = "select dPassword from doctor where dId=?";
//	private final String SAVE_STUDENT = "insert into doctor(did, dname, password, specialty) values(?,?,?,?)";
//	private final String VIEW_STUDENT = "select roll_number, name, gender, course from student";
	//private final String DELETE_STUDENT = "delete from student where roll_number=?";
	//private final String SEARCH_STUDENT = "select roll_number, name, gender, course from student where roll_number=?";
	//private final String UPDATE_STUDENT = "update student set name=?, gender=?, course=? where roll_number=?";
	DoctorDto dto = null;
	public String getPassword(String d_id) {
		// do database operation logic 
		String password = "";
		Connection connect = null;
		try {
			connect = DataBaseConnection.getConnection(); 
			PreparedStatement ps = connect.prepareStatement(VALIDATE_PASSWORD);
			ps.setString(1, d_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				password = rs.getString(1);
			}
			else {
				System.out.println("else");
			}
		}
		catch (Exception e) {
			System.out.println("Error in Dao try "+e);
		}
		return password;
	}
	
//	public List<DoctorDto> viewStudents(){
//		DoctorDto dto = null;
//		List<DoctorDto> studentList = new ArrayList<DoctorDto>();
//		
//		try {
//			Connection connect = DataBaseConnection.getConnection(); 
//			PreparedStatement ps = connect.prepareStatement(VIEW_STUDENT);
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				 dto = new DoctorDto();
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
//	
//	public boolean delete(int rollNumber) {
//		boolean status = true;
//		try {
//			Connection connect = DataBaseConnection.getConnection(); 
//			PreparedStatement ps = connect.prepareStatement(DELETE_STUDENT);
//			ps.setInt(1, rollNumber);
//			status = ps.execute();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		return status;
//	}
//	
//	public DoctorDto getDetails(int rollNumber) {
//		DoctorDto dto = null;
//		try {
//			Connection connect = DataBaseConnection.getConnection(); 
//			PreparedStatement ps = connect.prepareStatement(SEARCH_STUDENT);
//			ps.setInt(1, rollNumber);
//			ResultSet rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				 dto = new DoctorDto();
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
//	
//	public int updateDoctor(DoctorBo doctorBo) {
//		int i = 0;
//		try {
//			Connection connect = DataBaseConnection.getConnection(); 
//			PreparedStatement ps = connect.prepareStatement(UPDATE_STUDENT);
//			ps.setString(1, doctorBo.getStudentName());
//			ps.setString(2, doctorBo.getStudentGender());
//			ps.setString(3, doctorBo.getStudentCourse());
//			ps.setInt(4, doctorBo.getStudentRollNumber());
//			i = ps.executeUpdate();
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		return i;
//	}
}