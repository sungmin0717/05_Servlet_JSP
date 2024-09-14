package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/signUp.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		//getParameter로 name 얻어오기.
		String phone = req.getParameter("phone");
		//getParameter로 phone 얻어오기.
		
		
		//오류가 생길수도 잇을 가능성이 있기에 트라이 문.
		try {
			
			MemberService service = new MemberServiceImpl();
			//MemberService에 새로운 MemberServiceImpl service를 만들겠다
			boolean result = service.addMember(name, phone);
			//거짓 트루 로 service에 addMember(name,phone)을 result에 저장.
			
			String url = null;
			String message = null;
			
			
			//만일 result가 
			if(result) {
				url ="/";
				//url이 메인화면일 경우.
				message = name + "님이 가입되었습니다";
				//얼러트로 문자표시
			}else { // 아닐 경우
				url = "/signUp"; // url이 로그인 페이지라면,
				message = "중복된 휴대폰 번호가 존재합니다.";
				// 얼러트로 메시지 표시.
			}
			
			HttpSession session = req.getSession();
			//Session : 페이지가 꺼질떄까지. 유지되는것,
			session.setAttribute(message, session);
			//setAttribute 값을 저장하는것
			
			resp.sendRedirect(url);
			//sendRedirect url 을 보내다.
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
