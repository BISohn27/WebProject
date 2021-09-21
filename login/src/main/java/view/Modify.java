package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Modify
 */
@WebServlet("/Modify")
public class Modify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modify() {
        super();
   
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id =request.getParameter("id");
		
		out.println("<html>"
				+ "		<head>"
				+ "		  <meta charset=\"utf-8\">"
				+ "		  <meta name=\"viewport\" content=\"width=device-width\">"
				+ "		  <title>회원정보 수정</title>"
				+ "		  <style>"
				+ "			[for=email]{"
				+ "				 padding-right: 16px;"
				+ "			}"
				+ "		  </style>"
				+ "		</head>"
				+ "		<body>"
				+ "		  <form action=\"Service\" method=\"post\">"
				+ "         <input type='hidden' name='id' value='" + id + "'"
				+ "		    <label for=\"phone\">전화번호</label>"
				+ "		    <input type=\"text\" id=\"phone\" name=\"phone\" maxlength=\"15\" size=\"15\"><br>"
				+ "		    <label for=\"email\">이메일</label>"
				+ "		    <input type=\"text\" id=\"email\" name=\"emailfirst\" maxlength=\"20\" size=\"20\">@<input type=\"text\" name=\"emaillast\" maxlength=\"20\" size=\"20\"><br>"
				+ "		    <label for=\"agreement\">수신동의</label>"
				+ "		    <input type=\"radio\" id=\"agreement\" name=\"agreement\" value=\"agree\">동의<input type=\"radio\" name=\"agreement\" value=\"disagree\">비동의<br>"
				+ "		    <input type=\"submit\" value=\"수정\"><input type=\"reset\" value=\"지우기\"><input type=\"button\" name=\"command\" onclick=\"location.href='/login/Service?id=" + id + "'\" value=\"뒤로가기\">"
				+ "		    <input type=\"hidden\" name=\"command\" value=\"modify\">"
				+ "		  </form>"
				+ "		</body>"
				+ "		</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
