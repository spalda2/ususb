package com.spalda.usu_sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.spalda.usu_sb.model.Employee;
import com.spalda.usu_sb.model.EmployeeAgeDistribution;
import com.spalda.usu_sb.model.EmployeesAverageAge;
import com.spalda.usu_sb.service.EmployeesSrv;


@CrossOrigin(origins = "*", allowedHeaders = "*") //supposedly recommended but doesn't work
@RequestMapping("/api")
@RestController
public class EmployeesController {

    @Autowired
    EmployeesSrv empSrv;

    @RequestMapping(value="/employees/gentbl", method=RequestMethod.POST)
    public void genTbl() {
    	empSrv.genTbl();
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
