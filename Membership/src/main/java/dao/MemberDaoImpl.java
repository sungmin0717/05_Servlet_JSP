package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Member;
import java.util.List;


	
	//MemberDao 인터페이스를 상속 받아 구현
	
public class MemberDaoImpl implements MemberDao{
	

	// 회원 데이터가 저장될 파일 경로를 상수로 지정.
	private final String FILE_PATH = "membership_servlet.dat";
	
	//회원 목록을 저장해둘 List 객체
	private List<Member> memberList = null;
	
	//스트림 객체 참조 변수.
	private ObjectOutputStream oos = null;
	private ObjectInputStream  ois = null;
	
	//기본 생성자
	// - 회원 다수를 관리할 회원 목록 (List)이 필요한데
	//	이미 파일로 저장된 회원 목록이 있으면 읽어오고
	//	없으면 새로 만들기.
	public MemberDaoImpl() throws FileNotFoundException,IOException {
		
		//파일이 존재하는지 검사
		File file = new File(FILE_PATH);
		
		if( file.exists()) { //존재하는 경우
			
			try {
				
				//스트림 생성
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				//정장된 객체를 파일에서 읽어와.
			} finally {
			}
			
		}
		
		
	}

}
