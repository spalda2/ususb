package com.spalda.usu_sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spalda.usu_sb.model.EmployeesAverageAge;

@Repository
public interface EmployeesAverageAgeRepo extends org.springframework.data.repository.Repository<EmployeesAverageAge, Long> {

	//SELECT Position, count(*) as Count, cast((sum(Age) / Count(*)) as unsigned) as `Average Age` FROM usu_schema.employees GROUP BY Position ORDER BY Position
	@Query(value = "SELECT Position, count(*) as Count, cast((sum(Age) / Count(*)) as unsigned) as `Average Age` FROM usu_schema.employees GROUP BY Position ORDER BY Position", nativeQuery = true)
	List<EmployeesAverageAge> avgAge();

}
