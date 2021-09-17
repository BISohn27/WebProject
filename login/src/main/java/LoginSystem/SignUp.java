package LoginSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException{
    	Connection conn = DBAction.getInstance().getConnection();
    	Statement stmt = null;
    	
    	try {
    		stmt = conn.createStatement();
    		stmt.executeUpdate("CREATE TABLE USERINFO(ID VARCHAR(20),PW VARCHAR(20),NAME VARCHAR(20),BIRTH VARCHAR(8),GENDER VARCHAR(6),PHONE VARCHAR(11),EMAIL VARCHAR(40),AGREEMENT VARCHAR(8))");
    	}catch(Exception e) {
    		
    	}finally {
    		try {
    			if(stmt != null) stmt.close();
    		}catch(SQLException e) {}
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = DBAction.getInstance().getConnection();
		PreparedStatement pstmt = null;
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String[] data = new String[8];
		data[0] = request.getParameter("id");
		data[1] = request.getParameter("pw");
		data[2] = request.getParameter("name");
		data[3] = request.getParameter("year") + request.getParameter("month") + request.getParameter("day");
		data[4] = request.getParameter("gender");
		data[5] = request.getParameter("firstphone") + request.getParameter("secondphone") + request.getParameter("thirdphone");
		data[6] = request.getParameter("emailid") + "@" + request.getParameter("emailaddress");
		data[7] = request.getParameter("agreement");
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO USERINFO VALUES(?,?,?,?,?,?,?,?)");
			
			for(int i = 1; i<=8; i++) {
				pstmt.setString(i, data[i-1]);
			}
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
