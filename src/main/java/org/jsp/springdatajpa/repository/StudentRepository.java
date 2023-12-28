package org.jsp.springdatajpa.repository;

import org.jsp.springdatajpa.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
