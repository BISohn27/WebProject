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
		
		out.println("<html><head><style>form {display:inline;}</style></head>");
		out.println("<body><table border = '1'");
		out.println("<tr><th>���̵�</th><td>" + dto.getId() + "</td></tr>");
		out.println("<tr><th>�� ��</th><td>" + dto.getName() + "</td></tr>");
		out.println("<tr><th>�������</th><td>" + dto.getBirth() + "</td></tr>");
		out.println("<tr><th>�� ��</th><td>" + dto.getBirth() + "</td></tr>");
		out.println("<tr><th>��ȭ��ȣ</th><td>" + dto.getPhone() + "</td></tr>");
		out.println("<tr><th>�̸���</th><td>" + dto.getEmail() + "</td></tr>");
		out.println("<tr><th>���ŵ���</th><td>" + dto.getAgreement() + "</td></tr></table>");
		out.println("<form action='Modify' method='post'>");
		out.println("<input type='hidden' name='id' value='"+dto.getId()+"'><input type='submit' value = '����'></form>");
		out.println("<form action='Service' method ='post'><input type='hidden' name = 'command' value = 'delete'><input type ='hidden' name='id' value='"+dto.getId()+"'><input type='submit' value = '��������'>");
		out.println("</form></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
