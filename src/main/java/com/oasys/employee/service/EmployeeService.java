package com.oasys.employee.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.oasys.employee.Dao.EmployeeDao;
import com.oasys.employee.Exception.SalaryNotFoundException;
import com.oasys.employee.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
	public String insertEmployee(Employee e) {
		return empDao.insertEmployee(e);
	}
	public String insertEmployee(List<Employee> e) {
		return empDao.insertEmployee(e);
	}
	public Optional<Employee> getid(@PathVariable int num) {
		return empDao.getid(num);
	}
	public List<Employee> findAllEmployee() {
		return empDao.findAllEmployee();
	}
	public String updateEmployee(Employee a) {
		return empDao.updateEmployee(a);
	}
	public String deleteEmployee(@PathVariable int d) {
		return empDao.deleteEmployee(d);
	}
	public List<Employee> getEmpByGender(String gender) {
		List<Employee>allEmp=this.findAllEmployee();
		return allEmp.stream().filter(i->i.getGender().equals(gender)).toList();
	}
	public List<Employee> getBySalary(@PathVariable int salary) {
		List<Employee> allsalary=this.findAllEmployee();
		return allsalary.stream().filter(i->i.getSalary()>=10000).toList();
	}
	public int getByAge() {
		List<Employee> allage=this.findAllEmployee();
		Employee max=allage.stream().max(Comparator.comparing(Employee::getAge)).get();
		return max.getSalary();
	}
	public String getByName() {
		List<Employee> name=this.findAllEmployee();
		Employee max=name.stream().max(Comparator.comparing(Employee::getSalary)).get();
		return max.getName();
	}
	public List<Employee> salary(@PathVariable String s) {
		List<Employee> female=this.findAllEmployee();
		List<Employee> fe=female.stream().filter(i->i.getGender().equals(s)).peek(i->{
			int c=i.getSalary()*5/100;i.setSalary(i.getSalary()+c);}).toList();
		return fe;
	}
	public List<Employee> malesalary(@PathVariable String m) {
		List<Employee> male=this.findAllEmployee();
		List<Employee> ma= male.stream().filter(i->i.getGender().equals(m)).peek(i->{
		int d=i.getSalary()*8/100;i.setSalary(i.getSalary()+d);}).toList();
		return ma;
	}
	public String ageeligible(Employee l) {
		return empDao.ageeligible(l);
	}
	public List<Employee> employeesalary(int p)throws SalaryNotFoundException {
		List<Employee> emp=this.findAllEmployee();
		List<Employee> val=emp.stream().filter(x->x.getSalary()==p).toList();
		if(val.isEmpty()) {
			throw new SalaryNotFoundException("there is no data in the salary");
			
		}
		else {
			return val;
		}
	}
}
