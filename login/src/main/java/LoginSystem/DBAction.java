package LoginSystem;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBAction {
	private static DBAction instance = new DBAction();
	private Connection conn;
	private DataSource ds;
	
	public DBAction() {
		try {
			InitialContext initctx = new InitialContext();
			Context ctx = (Context)initctx.lookup("java:/comp/env");
			ds = (DataSource)ctx.lookup("jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DBAction getInstance() {
		if(instance == null) instance = new DBAction();
		
		return instance;
	}
	
	public Connection getConnection() {
		try {
			conn=ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() {
		try {
			if(conn != null) conn.close();
		}catch(SQLException e) {}
	}
}
