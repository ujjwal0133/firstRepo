package services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.studentms.repository.StudentRepo;

import entity.student;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class StudentService {
	
	
	
	private final StudentRepo RepoService;
	
	public StudentService(StudentRepo sr) {
		this.RepoService = sr;						//CONSTRUCTOR INJECTION.
	}
	
	
	public List<student> allStudents(){
		return RepoService.findAll();
	}
	
	
	public student findStudent(String id) {
		return RepoService.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found!"));
		
	}
	
	public student addStudent(student s) {
		return RepoService.save(s);
	}
	
	public student updateStudent(String id,student s) {
		student old = RepoService.getById(id);
		
		old.setName(s.getName());
		old.setAge(s.getAge());
		old.setEmail(s.getEmail());
		
		return RepoService.save(old);
		
	}
	
	public void deleteStudent(String id) {
		 RepoService.deleteById(id);
		 System.out.println( "Student deleted");
		
	}
	

}
