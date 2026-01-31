package com.example.studentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.student;

public interface StudentRepo extends JpaRepository<student,String> {
	
	public student findByName(String name);
	
}
