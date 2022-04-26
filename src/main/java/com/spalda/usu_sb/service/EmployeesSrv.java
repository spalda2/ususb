package com.spalda.usu_sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.spalda.usu_sb.model.Employee;
import com.spalda.usu_sb.model.EmployeeAgeDistribution;
import com.spalda.usu_sb.model.EmployeesAverageAge;
import com.spalda.usu_sb.repository.EmployeesAgeDistributionRepo;
import com.spalda.usu_sb.repository.EmployeesAverageAgeRepo;
import com.spalda.usu_sb.repository.EmployeesRepo;

@Service
public class EmployeesSrv {

    @Autowired
    EmployeesRepo empRepo;        
    @Autowired
    EmployeesAverageAgeRepo avgageRepo;        
    @Autowired
    EmployeesAgeDistributionRepo agedistrRepo;        

    // CREATE 
    public Employee createEmployee(Employee emp) {
        return empRepo.save(emp);
    }

    // UPDATE
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
            Employee emp = empRepo.findById(empId).get();
            emp.setName(employeeDetails.getName());
            emp.setAge(employeeDetails.getAge());
            emp.setPosition(employeeDetails.getPosition());
            
            return empRepo.save(emp);                                
    }
    // READ
    public List<Employee> getEmployees() {
        return empRepo.findAll();
    }

    // DELETE
    public void deleteEmployee(Long empId) {
    	empRepo.deleteById(empId);
    }


    public void commit() {
    	empRepo.flush();
    }
    
	public List<EmployeesAverageAge> avgAge() {
		return avgageRepo.avgAge();
	}
	
	
	public List<EmployeeAgeDistribution> ageDistr() {
		return agedistrRepo.ageDistr();
	}


	public void deleteAll() {
		empRepo.deleteAll();
	}
}
