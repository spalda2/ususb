package com.spalda.usu_sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    public boolean genTbl() {
    	List<Employee> empls = new ArrayList<>(Arrays.asList(
    		    new Employee("Milan", 24, "Frontend developer"),
    		    new Employee("Honza", 30, "Frontend developer"),
    		    new Employee("Jana", 30, "Frontend developer"),
    		    new Employee("Vera", 36, "Frontend developer"),
    		    new Employee("Zdenek", 50, "Frontend developer"),
    		    new Employee("Jarek", 62, "Frontend developer"),
    		    new Employee("Zuzana", 63, "Frontend developer"),
			    new Employee("Karel", 45, "Backend developer"),
			    new Employee("Josef", 18, "Backend developer"),
			    new Employee("Petr", 37, "Backend developer"),
			    new Employee("Roman", 37, "Backend developer"),
			    new Employee("Roman", 34, "Product owner"),
			    new Employee("Ales", 43, "Product owner"),
			    new Employee("Jana", 53, "Scrum master"),
			    new Employee("Jirka", 28, "Scrum master"),
			    new Employee("Jirka", 50, "Scrum master"),
			    new Employee("Alena", 58, "CEO")
    		));
    	this.deleteAll();
    	empls.forEach((Employee emp) -> {
            this.createEmployee(emp);    		
    	});
    	this.commit();
    	return true;
    }

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
