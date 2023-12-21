package com.oasys.employee.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.oasys.employee.Repositor.EmployeeRepositor;
import com.oasys.employee.entity.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepositor empRepo;
	public String insertEmployee(Employee e) {
		empRepo.save(e);
		return "success";
	}
	public String insertEmployee(List<Employee> e) {
		empRepo.saveAll(e);
		return "success";
	}
	public Optional<Employee> getid(@PathVariable int num) {
		return empRepo.findById(num);
	}
	public List<Employee> findAllEmployee() {
		return empRepo.findAll();
	}
	public String updateEmployee(Employee a) {
		 empRepo.save(a);
		 return "welcome";
	}
	public String deleteEmployee(@PathVariable int d) {
		 empRepo.deleteById(d);
		 return "delete Employee";
	}
	public List<Employee> getBySalary(@PathVariable int salary) {
		return getBySalary(salary);
	}
	public String ageeligible(Employee l) {
		if(l.getAge()>=18) {
			empRepo.save(l);
			return "eligible";
		}
		else {
			empRepo.save(l);
			return "not eligible";
		}
		
	}
}
