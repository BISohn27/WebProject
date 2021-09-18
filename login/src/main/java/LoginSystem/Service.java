package LoginSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Service
 */
@WebServlet("/Service")
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Service() {
		super();
	}

	@Override
	public void init() {
		conn = DBAction.getInstance().getConnection();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String id = request.getParameter("id");
			String[] column = {"ID","NAME","BIRTH","GENDER","PHONE","EMAIL","AGREEMENT"};
			pstmt = conn.prepareStatement("SELECT ID,NAME,BIRTH,GENDER,PHONE,EMAIL,AGREEMENT FROM USERINFO WHERE ID='" + id + "'");
				
			rs = pstmt.executeQuery();

			while(rs.next()) {
				out.println("<html><head></head>");
				out.println("<body><table border = '1'");
				
				for(int i =1; i<=column.length; i++) {
					out.println("<tr><th>"+ column[i-1] + "</th><td>" + rs.getString(i) +"</td></tr>");
				}
				
				out.println("</table margin ='0'><form><input type='button' onclick=\"location.href='/login/UpdateUserInfo?id="+id+"'\" value = 'È¸¿øÁ¤º¸¼öÁ¤'>");
				out.println("<input type='button' onclick=\"location.href='/login/DeleteUserInfo?id="+id+"'\" value = 'È¸¿øÅ»Åð'>");
				out.println("</form></body></html>");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(SQLException e) {}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
