package com.dextris.hrms.employee.service;

import java.util.List;
import java.util.Optional;

import com.dextris.hrms.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee updateEmployee(Long id, Employee employee);

	Optional<Employee> deleteEmployee(Long id);

	Employee addEmployee(Employee employee);

	Employee findEmployeeByEmail(String email);
}
