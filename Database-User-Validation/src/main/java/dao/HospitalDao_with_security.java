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
	HospitalDto dto = null;
	HospitalVo vo = null;
	Connection connect = null;
	
	@Override
	public void getPassword() {
		// database operation logic
		try {
			dto = new HospitalDto();
			vo = new HospitalVo();
			
			// connection to database
			// and execute given SQL query
			connect = DataBaseConnection.getConnection(); 
			PreparedStatement ps = connect.prepareStatement(VALIDATE_PASSWORD);
			
			// typecaste values to SQL datatypes
			// String to varchar()
			// the entire string will be read as a varchar by the database
			ps.setString(1, vo.getD_id().trim());
			ps.setString(2, vo.getdPassword().trim());
			ResultSet rs = ps.executeQuery();
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
}