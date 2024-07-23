package com.dextris.hrms.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dextris.hrms.employee.exception.EmployeeCannotBeCreatedException;
import com.dextris.hrms.employee.exception.EmployeeNotFoundException;
import com.dextris.hrms.employee.exception.NoEmployeesAtATimeException;
import com.dextris.hrms.employee.model.Employee;
import com.dextris.hrms.employee.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() throws NoEmployeesAtATimeException {
		List<Employee> employees = employeeService.getAllEmployees();
		if (!employees.isEmpty()) {
			return ResponseEntity.ok().body(employees);
		}
		throw new NoEmployeesAtATimeException("No employee present at the moment");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Employee updatedEmployee = employeeService.updateEmployee(id, employee);
		if (updatedEmployee != null) {
			return ResponseEntity.accepted().body(updatedEmployee);
		}
		throw new EmployeeNotFoundException("Employee not found with an id: " + id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
		Optional<Employee> deletedEmployee = employeeService.deleteEmployee(id);
		if (deletedEmployee.isPresent()) {
			return ResponseEntity.accepted().body(deletedEmployee.get());
		}
		throw new EmployeeNotFoundException("Employee not found with an id: " + id);
	}

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		Employee savedEmployee = employeeService.addEmployee(employee);
		if (savedEmployee != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
		}
		throw new EmployeeCannotBeCreatedException("Employee cannot be created, please verify the entered details");
	}

	@GetMapping("/{email}")
	public ResponseEntity<Employee> findByEmail(@PathVariable String email) {
		Employee employee = employeeService.findEmployeeByEmail(email);
		if (employee != null) {
			return ResponseEntity.accepted().body(employee);
		}
		throw new EmployeeNotFoundException("Employee not found with an email: " + email);
	}
}
