package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DTO;

/**
 * Servlet implementation class Front
 */
@WebServlet("/Front")
public class Front extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Front() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		DTO dto = (DTO)request.getAttribute("dto");
		
		out.println("<html><head></head>");
		out.println("<body><table border = '1'");
		out.println("<tr><th>아이디</th><td>" + dto.getId() + "</td></tr>");
		out.println("<tr><th>이 름</th><td>" + dto.getName() + "</td></tr>");
		out.println("<tr><th>생년월일</th><td>" + dto.getBirth() + "</td></tr>");
		out.println("<tr><th>성 별</th><td>" + dto.getBirth() + "</td></tr>");
		out.println("<tr><th>전화번호</th><td>" + dto.getPhone() + "</td></tr>");
		out.println("<tr><th>이메일</th><td>" + dto.getEmail() + "</td></tr>");
		out.println("<tr><th>수신동의</th><td>" + dto.getAgreement() + "</td></tr></table>");
		out.println("<form><input type='button' name='command' onclick=\"location.href='/login/Service?id=" + dto.getId() + "'\" value = 'modify'>");
		out.println("<input type='button' name = 'command' onclick=\"location.href='/login/Service?id=" + dto.getId() + "'\" value = 'delete'>");
		out.println("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
