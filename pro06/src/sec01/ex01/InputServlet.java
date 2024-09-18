package sec01.ex01;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/input2")
public class InputServlet extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		String user_id = request.getParameter("user_id");
//		String user_pw = request.getParameter("user_pw");
//		System.out.println("아이디 : " + user_id);
//		System.out.println("비밀번호 : " + user_pw);
		
//		String[] subject = request.getParameterValues("subject"); //값 여러개 받기
//		
//		for(String str : subject) {
//			System.out.println("선택한 과목:" + str);
//		}
		
		//name값 일일이 알기 번거로운 경우 사용
		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String[] values = request.getParameterValues(name);
			
			for(String value : values) {
				System.out.println("name=" + name + ", value=" + value);
			}
		}
	}

}
