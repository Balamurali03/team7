package com.dextris.hrms.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dextris.hrms.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmail(String email);
}
