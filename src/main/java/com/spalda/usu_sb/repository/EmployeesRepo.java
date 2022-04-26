package com.spalda.usu_sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spalda.usu_sb.model.Employee;

@Repository
public interface EmployeesRepo  extends JpaRepository<Employee, Long> {
		
	@Modifying
	@Query(value = "TRUNCATE TABLE employees", nativeQuery = true)
	void deleteAll();
}
