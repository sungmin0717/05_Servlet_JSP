package project.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import project.dto.Project;

public class ProjectDaoimpl implements ProjectDao{

	private final String FILE_FATH = "Poject.dat";
	
	private List<Project> projectList = null;
	
	private ObjectOutputStream oos = null;
	private ObjectInputStream ois = null;
	
	
	// 기본 생성자
		public ProjectDaoimpl() throws ClassNotFoundException, IOException {
			
			// Project.dat 파일이 없으면 새로운 List 생성, 있으면 읽어오기
			File file = new File(FILE_FATH); // 파일이 없을 시 만드는것,. 
			if(!file.exists()) {
				projectList = new ArrayList<Project>();
				
				
			
			projectList.add(new Project
					("java 공부", "복습하기", false , LocalDateTime.now()));
			projectList.add ( new Project 
					("css 공부", "복습하기", false, LocalDateTime.now()));
			projectList.add ( new Project 
					("html 공부", "복습하기", false, LocalDateTime.now()));
			}else {
				try {
					ois = new ObjectInputStream(new FileInputStream(FILE_FATH));
					//입력하는 input스트림한테 새로운 파일객체 
					projectList = (ArrayList<Project>)ois.readObject();
					
				} finally {
					if(ois != null) ois.close();
				}
				
			}
		}
		
		@Override
		public void saveFile() throws IOException {
			
			try {
				oos = new ObjectOutputStream(new FileOutputStream(FILE_FATH));
				//출력 = 새로운 전달받는 값 새로운 파일 전달 스트림 파일 패치.
				oos.writeObject(projectList);
				
			} finally {
			}
		}
		
}
