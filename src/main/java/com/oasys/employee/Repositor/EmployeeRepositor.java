package com.oasys.employee.Repositor;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oasys.employee.entity.Employee;

public interface EmployeeRepositor extends JpaRepository <Employee,Integer>{

}
