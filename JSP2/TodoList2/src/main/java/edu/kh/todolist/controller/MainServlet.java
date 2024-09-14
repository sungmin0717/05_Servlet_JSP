package edu.kh.todolist.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// "/" 메인페이지를 보여지게 하는것.
@WebServlet("/")
public class MainServlet extends HttpServlet{

	/* 왜 "/" 메인페이지 요청을 처리하는 서블릿 만들었는가???
	 * - Servlet(back-End) 에서 추가한 데이터를 
	 * 메인 페이지에서 사용할수 있게하려고 
	 * 
	 */
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//테스트용 샘플 데이터
		//req.setAttribute("str", "메인페이지 요청시 값 전달됨.");
		
		
		
		
		String path = "/WEB-INF/views/main.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
		// Dispatcher
		// 서블릿 컨테이너의 제일 앞에서 서버로 들어오는 클라이언트의 모든 요청을 서버로 들이것.
	}
}
