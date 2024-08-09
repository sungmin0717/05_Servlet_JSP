package edu.kh.todolist.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import edu.kh.todolist.dto.Todo;
import edu.kh.todolist.service.TodoListService;
import edu.kh.todolist.service.TodoListServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// "/" 요청을 매핑하여 처리하는 서블릿
// "/main" == localhost / main == 메인 페이지
@WebServlet("/main")
public class MainServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//테스트용 샘플 데이터
		//req.setAttribute("str", "메인 페이지 요청 시 값 전달 됨.");
		
		
		
		//Service 객체 생성
		try {
			TodoListService service = new TodoListServiceImpl();
			
			
			//전체 할 일 목록 + 완료된 Todo 개수가 담긴 Map을
			// Service 호출해서 얻어오기
			Map<String, Object> map = service.todoListFullView();
			//Map : K : V 한쌍으로 관리하는것
			

			//Map에 저장된 값 풀어내기
			List<Todo> todoList = (List<Todo>)map.get("todoList");
			int completeCount = (int)map.get("completeCount");
			
			//request scope 객체 값을 추가
			req.setAttribute("todoList", todoList);
			req.setAttribute("completeCount", completeCount);
			
			
			
			//메인 페이지 응답을 담당하는 jsp에 요청 위임.
			String path = "/WEB-INF/views/main.jsp";
			req.getRequestDispatcher(path).forward(req, resp);	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		

		
	}
	
}
