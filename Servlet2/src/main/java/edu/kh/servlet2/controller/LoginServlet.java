package edu.kh.servlet2.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
//매핑 주소가 잘못되어있다.
public class LoginServlet extends HttpServlet {

	// doPost 자동완성을 하면 오버라이딩 추천.
	// "/login" Post 방식 요청을 처리하는 메서드.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청시 제출된 값 (파라미터) 모두 얻어오기.
		String inputid = req.getParameter("inputid");
		String inputpw = req.getParameter("inputpw"); // req.getParmeter(얻어올 객체)
		String check = req.getParameter("check");

		System.out.println("inputid");
		System.out.println("inputpw"); // 데이터 확인.
		System.out.println("check");

		// ------------------------------------------------------------

		// 아이디 : user01
		// 비밀번호가: pass01!
		// check : 헬로 월드

		// 모두 일치하는 경우 로그인 성공.
		// 불일치한 내용이 있을경우
		// -> 000이 일치하지 않습니다.
		// (000은 id, pw, check)

		String result = ""; // 결과 문자열 저장 누적

		if (inputid.equals("user01") && inputpw.equals("pass01!") && check.equals("헬로 월드")) {

			result = "<h1 style = 'color:red;'> 로그인 성공  </h1>";

		} else {
			if (!inputid.equals("user01")) {
				result += "<h3>ID가 일치하지 않습니다.</h3>"; // 하나씩 따져야 하기 떄문에 else에 if문으로 따져야함
			}
			if (!inputpw.equals("pass01!")) {
				result += "<h3>PW가 일치하지 않습니다.</h3>";
			}
			if (!check.equals("헬로 월드")) {
				result += "<h3>check가 일치하지 않습니다.</h3>";

			}
			
		}
		
		//-------------------------------------------------------------
		// 응답하기.
		
		resp.setContentType("text/html; charset=utf-8"); 
		//           텍스트로 된 문자열이다. 
		//응답되는 문서의 형식, 문자 인코딩 지정.
		
		//클라이언트와 연결된 출력용 스트림 얻어오기.
		PrintWriter out = resp.getWriter();
		
		//출력할 HTML 작성하기.
		StringBuilder sb= new StringBuilder();
		
		sb.append("""
		<!DOCTYPE html>
		<html>
		<head>
		<title> 로그인 결과 페이지 </title>
		</head>
		
		<body>      """);
		
		sb.append(result);
		
		sb.append("</body>");
		sb.append("</html>");
		
		out.write(sb.toString());
		// 클라이언트에게 출력  == 서버 응답.
		
		
	}
}
