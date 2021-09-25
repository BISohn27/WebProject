package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAO;
import data.DBAction;
import data.DTO;

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
		doHandle(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);

	}
	
	private void doHandle(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DAO dao = new DAO();
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		
		if(command != null && command.equals("addUser")) {
			String id = request.getParameter("id");
			String pw  = request.getParameter("pw");
			String name = request.getParameter("name");
			String birth = request.getParameter("year") + request.getParameter("month") + request.getParameter("day");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("firstphone") + request.getParameter("secondphone") + request.getParameter("thirdphone");
			String email = request.getParameter("emailid") + "@" + request.getParameter("emailaddress");
			String agreement = request.getParameter("agreement");
			
			DTO dto = new DTO();
			dto.setId(id);
			dto.setPw(pw);
			dto.setName(name);
			dto.setBirth(birth);
			dto.setGender(gender);
			dto.setPhone(phone);
			dto.setEmail(email);
			dto.setAgreement(agreement);
			dao.addUser(dto);
			
			request.setAttribute("dto", dto);
			RequestDispatcher dispatch = request.getRequestDispatcher("/view/Front.jsp");
			dispatch.forward(request, response);
			
		} else if(command != null && command.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			DTO dto = dao.loginCheck(id, pw);
			
			if(dto != null) {
				request.setAttribute("dto", dto);
				RequestDispatcher dispatch = request.getRequestDispatcher("/view/Front.jsp");
				dispatch.forward(request, response);
			}else {
				response.sendRedirect("login.html");
			}
		} else if(command != null && command.equals("delete")) {
			String id = request.getParameter("id");
			System.out.println(id);
			dao.deleteUser(id);
			response.sendRedirect("login.html");
			
		} else if(command != null && command.equals("modify")) {
			String id = request.getParameter("id");
			String phone = request.getParameter("phone");
			String email = request.getParameter("emailfirst") + "@" + request.getParameter("emaillast");
			String agreement = request.getParameter("agreement");
			DTO dto = dao.modifyUser(id, phone, email, agreement);
			request.setAttribute("dto",dto);
			RequestDispatcher dispatch = request.getRequestDispatcher("/view/Front.jsp");
			dispatch.forward(request, response);
			
		} else if(command != null&& command.equals("뒤로가기")) {
			String id = request.getParameter("id");
			
			request.setAttribute("dto",dao.getUser(id));
			RequestDispatcher dispatch =request.getRequestDispatcher("/view/Front.jsp");
			dispatch.forward(request, response);
		}
	}

}
