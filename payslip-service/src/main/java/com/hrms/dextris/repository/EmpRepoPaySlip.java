package com.hrms.dextris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dextris.model.EmpPaySlip;

@Repository
public interface EmpRepoPaySlip extends JpaRepository<EmpPaySlip, Integer>{

}
