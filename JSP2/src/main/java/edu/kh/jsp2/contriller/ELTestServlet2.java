package edu.kh.jsp2.contriller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 주소 앞에 무조건 환경설정한 / 붙여야함.
@WebServlet("/el/scope")
public class ELTestServlet2 extends HttpServlet{
	
	
	//a 태그 요청은 Get 방식
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 요청 처리
		
		// 1. page scope -> JSP 에서만 확인가능
		
		// 2. request scope 
		// -> 요청 받은 Servlet/JSP와
		// 요청이 위임된 Servlet/JSP에서 유지되는 객체
		
		// * Servlet/JSP 범위 객체에 
		// 1. 값(속성) 추가하는 방법
		// 추가적인 값(속성) 추가하는 방법
		//범위객체.setAttribute("key", value)
		
		// 2. 값(속성) 추가하는 방법
		//범위객체.setAttribute("key")
		// -> 반환형 Object -> 필요 시 다운 캐스팅
		
		
		req.setAttribute("requestValue", 
				"request scope 객체에 세팅한값");
		
		System.out.println(req.getAttribute("requestValue"));
		
		//---------------------------------------
		
		//3. session(입회,접속) scope
		// - 클라이언트가 서버에 첫 요청 시 
		// 서버쪽에 생성되는 객체
		
		// - 클라이언트가 브라우저를 종료하거나
		// 지정된 세샨 만료 시간이 지나면 사라짐
		// -> 위 상황이 아니면 계속 유지되는 객체
		
		// 1) session scope 객체 얻어오기
		
		HttpSession session = req.getSession();
		
		//2 ) session scope 객체에 값 세팅
		session.setAttribute("sessionValue",
				"session scope 객체에 세팅한 값" );
		
		/*session 만료 시키기*/
		
		session.setMaxInactiveInterval(1800); // 초단위
		
		//==================================
		//4. application socpe
		// - 서버 전체에 1개만 존재하는 객체
		// -> 모든 클라이언트가 공유
		
		// - 서버 시작 시 생성, 서버 종료 시 소멸
		
		//1) application scope 객체 얻어오기
		ServletContext application = req.getServletContext();
		
		//2) 값 세팅
		application.setAttribute("applicationValue",
				"application scope 객체에 세팅한값");
		//-----------------------------------
		
		//5. 범위별 우선순위 확인
		// (좁은 범위가 우선순위가 높다!!)
		// page > request > session > application 
		
		req.setAttribute("menu", "짬뽕(request)");
		session.setAttribute("menu", "짜장(session)");
		application.setAttribute("menu", "볶음밥(application)");
		
		
		
		
		//----------------
		// 응답 처리
		
		String path = "/WEB-INF/views/el/scope.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}

}
