package edu.kh.test.controller;

import java.io.IOException;

import java.util.ArrayList;

import java.util.List;

import edu.kh.test.model.dto.Member;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;

@WebServlet("/join")
//어노테이션 매핑주소가 잘못되어있음. 존재하지도않은것이 되어있다.

public class JoinServlet extends HttpServlet {

@Override

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//req 클라이언트 요청을 받아오는 제출된던 값들이 존재한다
//resp req을 요청한 응답 기능 (방법)이 담겨있다. (print) 내보내는것.
List<Member> memberList = new ArrayList<Member>();
//멤버안에 리스트라는애한테 멤버리스트라는 객체 추가.
memberList.add(new Member("test01", "1234", "김테스트"));
//멤버 리스트에 추가를 하겠다
memberList.add(new Member("test02", "5678", "최테스트"));

memberList.add(new Member("test03", "qwer", "박테스트"));

//-----------------------------------------------------------

String memberId = req.getParameter("memberId");
//memberID라는 객체를 외부에서 가져와. String memberId에 저장을 하겠다
String memberPw = req.getParameter("memberPw");
//memberID라는 객체를 외부에서 가져와. String memberPw에 저장을 하겠다
String memberName = req.getParameter("memberName");
//memberID라는 객체를 외부에서 가져와. String memberName에 저장을 하겠다
//html에문서는 모든게 문자열로 이루어져있다. 그래서 String으로 
for(Member member : memberList) {
//반복문 : memberList 에서 member라는애를 꺼내.
if(member.getMemberId().equals(memberId)) {
//만약 member.getMemberId가 memberid와 같다면
HttpSession session = req.getSession();
//page .         request . session .application 
//현재 페이지, 요청받은 페이지와 위임받은 페이지 , 브라우저가 종료 될떄까지 , 하나의 웹 어플맄네이션에서 계속 유지
//Session 범위 브라우저가 종료 꺼질떄 까지. session이라는 객체에 저장.
session.setAttribute("message", memberId + "은/는 이미 존재하는 아이디 입니다.");
//session.setAttributev
resp.sendRedirect("/");
//유효시간 지정 가능.
return;

}

}

Member member = new Member(memberId, memberPw, memberName);

memberList.add(member);

String message = String.format("%s/%s 님이 가입 되었습니다 (비밀번호 : %s)" 
		, memberId, memberName, memberPw);
//돌려받아서 memeberID s 에 저장 뒤에도 같음.

req.setAttribute("message", message);
//req 위임받은 서블릿.

String path = "/WEB-INF/views/success.jsp";
//파일경로가 잘못되어있어서 WEB-INF부터 다시 작성.
req.getRequestDispatcher(path).forward(req, resp);

}

}