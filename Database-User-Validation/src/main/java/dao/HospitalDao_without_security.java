package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import vo.HospitalVo;
import dto.HospitalDto;
import util.DataBaseConnection;
import service.HospitalDatabaseAccess;

public class HospitalDao_without_security extends HospitalDatabaseAccess {

	private String PASSWORD_VALIDATE_QUERY = "select dPassword from doctor where dId=";
	HospitalDto dto = null;
	HospitalVo vo = null;
	Connection connect = null;
	Statement stmt = null;  
    PreparedStatement psmt = null;
    
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
}
