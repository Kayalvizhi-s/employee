package com.oasys.employee.contoller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oasys.employee.Exception.SalaryNotFoundException;
import com.oasys.employee.entity.Employee;
import com.oasys.employee.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeContoller {
	@Autowired
	EmployeeService empser;
	@PostMapping(value="/add") 
	public String insertEmployee(@RequestBody Employee e) {
		return empser.insertEmployee(e);
	}
	@PostMapping(value="/num")
	public String insertEmployee(@RequestBody List<Employee> e) {
		return empser.insertEmployee(e);
	}
	@GetMapping(value="/get/{num}")
	public Optional<Employee> getid(@PathVariable int num) {
		return empser.getid(num);
	}
	@GetMapping(value="/get")
	public List<Employee> findAllEmployee() {
		return empser.findAllEmployee();
	}
	@PostMapping(value="/update/{a}")
	public String updateEmployee(@PathVariable Employee a) {
		return empser.updateEmployee(a);
	}
	@DeleteMapping(value="/delete/{d}")
	public String deleteEmployee(@PathVariable int d) {
		return empser.deleteEmployee(d);
		}
	@GetMapping(value="Gender/{gender}")
	public List<Employee> getEmpByGender(@PathVariable String gender) {
		return empser.getEmpByGender(gender);
	}
	@GetMapping(value="salary/{salary}")
	public List<Employee> getBySalary(@PathVariable int salary) {
		return empser.getBySalary(salary);
	}
	@GetMapping(value="/maxage")
	public int getByAge() {
		return empser.getByAge();
	}
	@GetMapping(value="/maxsalary")
	public String getByName() {
		return empser.getByName();
	}
	@GetMapping(value="/female/{s}")
	public List<Employee> salary(@PathVariable String s) {
		return empser.salary(s);
	}
	@GetMapping(value="/maleemployee/{m}")
	public List<Employee> malesalary(@PathVariable String m) {
		return empser.malesalary(m);
	}
	@GetMapping(value="/eligible")
	public String ageeligible(@RequestBody Employee l){
		return empser.ageeligible(l);
	}
	@GetMapping(value="/getsalary/{p}")
	public List<Employee> employeesalary(@PathVariable int p)throws SalaryNotFoundException {
	return empser.employeesalary(p);
	}
}
