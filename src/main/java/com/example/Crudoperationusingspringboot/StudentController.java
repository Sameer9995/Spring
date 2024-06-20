package com.example.Crudoperationusingspringboot;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Successfully Student Inserted";
	}
	
	@GetMapping("/getstudent/{id}")
	public Student getStudent(@PathVariable int id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = optional.get();
		return student;
		 
	}
	
	@GetMapping("/getallstudent")
	public List<Student> getAllStudent() {
		List<Student> student = studentRepository.findAll();
		return student;
	}
	
	@PutMapping("/updatestudent")
	public String updateStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return "Student Record SuccessFully Updated";
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if (optional.isPresent()) {
			Student student = optional.get();
			studentRepository.delete(student);
			return "Student Deleted Successfully";
		}
		return "Student Not Found";
	}
	
	
}
