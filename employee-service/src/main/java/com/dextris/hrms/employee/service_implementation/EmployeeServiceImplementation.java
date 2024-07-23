package com.dextris.hrms.employee.service_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextris.hrms.employee.model.Employee;
import com.dextris.hrms.employee.repository.EmployeeRepository;
import com.dextris.hrms.employee.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Optional<Employee> foundEmployee = employeeRepository.findById(id);
		if (foundEmployee.isPresent()) {
			Employee employee = foundEmployee.get();
			employee.setAddress(updatedEmployee.getAddress());
			employee.setDateOfBirth(updatedEmployee.getDateOfBirth());
			employee.setDepartmentId(updatedEmployee.getDepartmentId());
			employee.setEmail(updatedEmployee.getEmail());
			employee.setEmployeeId(id);
			employee.setFirstName(updatedEmployee.getFirstName());
			employee.setHireDate(updatedEmployee.getHireDate());
			employee.setLastName(updatedEmployee.getLastName());
			employee.setPhone(updatedEmployee.getPhone());
			employee.setJobId(employee.getJobId());
			return employeeRepository.save(employee);
		}
		return null;
	}

	@Override
	public Optional<Employee> deleteEmployee(Long id) {
		Optional<Employee> foundEmployee = employeeRepository.findById(id);
		if (foundEmployee.isPresent()) {
			employeeRepository.deleteById(id);
			return foundEmployee;
		}
		return Optional.empty();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		if (employee != null) {
			System.out.println("Entered save()");
			return employeeRepository.save(employee);
		}
		return null;
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		Employee foundEmployee = employeeRepository.findByEmail(email);
		if (foundEmployee != null) {
			return foundEmployee;
		}
		return null;
	}
}
