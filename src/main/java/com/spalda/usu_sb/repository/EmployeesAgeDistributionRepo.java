package com.spalda.usu_sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spalda.usu_sb.model.EmployeeAgeDistribution;

@Repository
public interface EmployeesAgeDistributionRepo extends org.springframework.data.repository.Repository<EmployeeAgeDistribution, Long> {

	//SELECT count(*) as `Count of Employees`,  CASE  WHEN  Age < 20  THEN  ' 20 -' WHEN  Age >=20  and Age<=40 THEN  ' 20 - 40' WHEN  Age >40  and Age<60 THEN  '41 - 60' ELSE '60+' END AS `Average Age` FROM usu_schema.employees GROUP BY `Average Age` ORDER BY  `Average Age` ASC
	@Query(value = "SELECT count(*) as `Count of Employees`,  CASE  WHEN  Age < 20  THEN  ' 20 -' WHEN  Age >=20  and Age<=40 THEN  ' 20 - 40' WHEN  Age >40  and Age<=60 THEN  '41 - 60' ELSE '60+' END AS `Average Age` FROM employees GROUP BY `Average Age` ORDER BY  `Average Age` ASC", nativeQuery = true)
	List<EmployeeAgeDistribution> ageDistr();


}
