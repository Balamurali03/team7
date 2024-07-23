package com.hrms.dextris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dextris.model.EmployeePaySlip;

@Repository
public interface EmployeeRepositoryPaySlip extends JpaRepository<EmployeePaySlip, Integer>{

}
