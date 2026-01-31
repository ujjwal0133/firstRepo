package com.example.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentms.entity.student;

public interface StudentRepo extends JpaRepository<student,String> {
	
	public student findByName(String name);
	
}
