package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private Connection conn;
	private PreparedStatement pstmt;

	public List<DTO> getUserList(){
		List<DTO> list = new ArrayList<>();
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM USERINFO");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();
			
			while(rs.next()) {
				String[] data = new String[cnt];
				
				for(int i=0; i<cnt; i++) {
					data[i] = rs.getString(i+1);
				}
				DTO dto = new DTO();
				dto.setId(data[0]);
				dto.setPw(data[1]);
				dto.setName(data[2]);
				dto.setBirth(data[3]);
				dto.setGender(data[4]);
				dto.setPhone(data[5]);
				dto.setEmail(data[6]);
				dto.setAgreement(data[7]);
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		
		return list;
	}
	
	public DTO getUser(String id) {
		DTO dto = new DTO();
		conn = DBAction.getInstance().getConnection();
		try{
			pstmt = conn.prepareStatement("SELECT * FROM USERINFO WHERE ID='"+id+"'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setId(rs.getString(1));
				dto.setPw(rs.getString(2));
				dto.setName(rs.getString(3));
				dto.setBirth(rs.getString(4));
				dto.setGender(rs.getString(5));
				dto.setPhone(rs.getString(6));
				dto.setEmail(rs.getString(7));
				dto.setAgreement(rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
		return dto;
	}
	
	public void addUser (DTO dto) {
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("INSERT INTO USERINFO VALUES(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getPhone());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getAgreement());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
	
	public void deleteUser(String id) {
		try {
			conn = DBAction.getInstance().getConnection();
			pstmt = conn.prepareStatement("DELETE FROM USERINFO WHERE ID='" + id + "'");
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {}
		}
	}
}
