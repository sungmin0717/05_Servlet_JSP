package project.dao;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import project.dto.Project;

public class ProjectDaoimpl implements ProjectDao{

	private final String FILE_FATH = "Poject.dat";
	
	private List<Project> ProjectList = null;
	
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	
	
	// 기본 생성자
		public ProjectDaoimpl() {
			
			// Project.dat 파일이 없으면 새로운 List 생성, 있으면 읽어오기
			File file = new File(FILE_FATH); // 파일이 없을 시 만드는것,. 
			if(!file.exists()) {
				ProjectList = new ArrayList<Project>();
				
				
			}
		}
}
