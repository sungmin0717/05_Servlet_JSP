package service;

import java.lang.reflect.Member;
import java.util.List;

public interface MemberService {


	List<Member> getMemberList();

	boolean addMember(String name, String phone);


 
}
