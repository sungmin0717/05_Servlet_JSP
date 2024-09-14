package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;

/* 왜 Service, Dao 인터페이스를 만들어서 구현했을까?
	 *  - 인터페이스를 상속 받아 구현하면
	 *   모든 자식 클래스가 똑같은 기능을 가지게 되어
	 *   비슷하게 생김!
	 *   
	 *   -> 언제든지 서로 다른 자식 클래스로 대체 가능!!
	 *   		==> 유지보수성 증가.
	 */

// MemberService를 상속 받아 구현.

public class MemberServiceImpl implements MemberService {

	private MemberDao dao = null;

	private String[] gradeArr = { "일반", "골드", "다이아" };

	// 기본 생성자
	// - MemberServiceImpl 객체 생성 시
	// MemberDaoImpl 객체도 생성
	public MemberServiceImpl() throws FileNotFoundException, IOException {

		dao = new MemberDaoImpl();
	}

	@Override
	public List<Member> getMemberList() {
		return null;
	}

}
