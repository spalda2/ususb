package com.spalda.usu_sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.spalda.usu_sb.model.Employee;
import com.spalda.usu_sb.model.EmployeeAgeDistribution;
import com.spalda.usu_sb.model.EmployeesAverageAge;
import com.spalda.usu_sb.service.EmployeesSrv;


@CrossOrigin(origins = "*", allowedHeaders = "*") //supposedly recommended but doesn't work
@RestController
@RequestMapping("/api")
public class EmployeesController {

    @Autowired
    EmployeesSrv empSrv;

    @RequestMapping(value="/employees/gentbl", method=RequestMethod.POST)
    public void genTbl() {
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
    	empSrv.deleteAll();
    	empls.forEach((Employee emp) -> {
            empSrv.createEmployee(emp);    		
    	});
    	empSrv.commit();
    }

    @RequestMapping(value="/employee", method=RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee emp) {
        return empSrv.createEmployee(emp);
    }
    
    @RequestMapping(value="/employees", method=RequestMethod.GET)
    public List<Employee> readEmployees() {
        return empSrv.getEmployees();
    }

    @RequestMapping(value="/employee/{empId}", method=RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable(value = "empId") Long id, @RequestBody Employee empDetails) {
        return empSrv.updateEmployee(id, empDetails);
    }

    @RequestMapping(value="/employee/{empId}", method=RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
    	empSrv.deleteEmployee(id);
    }

    @RequestMapping(value="/employees/avgage", method=RequestMethod.GET)
    public List<EmployeesAverageAge> avgage() {
    	return empSrv.avgAge();
    }

    @RequestMapping(value="/employees/agedistr", method=RequestMethod.GET)
    public List<EmployeeAgeDistribution> ageDistr() {
    	return empSrv.ageDistr();
    }
}
