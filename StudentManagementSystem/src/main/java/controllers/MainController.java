package controllers;
import java.security.Provider.Service;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentms.repository.StudentRepo;

import entity.student;
import lombok.RequiredArgsConstructor;
import services.StudentService;

@RestController
@RequestMapping(path="/students")
@RequiredArgsConstructor
public class MainController {
	
	private final StudentService servicelayer;
	
	public MainController(StudentService sr) {
		this.servicelayer = sr;
	}
	
	
	@GetMapping("")
	public List<student> students(){
		return servicelayer.allStudents();
	}
	
	@GetMapping("/{id}")
	public student findStudent(@PathVariable String id) {
		return servicelayer.findStudent(id);
	}
	
	@PostMapping("")
	public student addStudent(@RequestBody student st) {
		return servicelayer.addStudent(st);
	}
	
	@PutMapping("/{id}")
	public student updateStudent(@PathVariable String name,@RequestBody student st) {
		return servicelayer.updateStudent(name, st);
	}
	
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable String name) {
		servicelayer.deleteStudent(name);
	}
	

	
	


}