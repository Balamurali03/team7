package com.hrms.dextris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dextris.model.EmpPaySlip;
import com.hrms.dextris.repository.EmpRepoPaySlip;

@Service 
public class EmpServiceImplPaySlip implements EmpServicePaySlip {
	
	@Autowired
	public EmpRepoPaySlip empRepoPaySlip;

	@Override
	public EmpPaySlip createPayslip(EmpPaySlip empPaySlip) {
		// TODO Auto-generated method stub
		return empRepoPaySlip.save(empPaySlip);
	}

	@Override
	public List<EmpPaySlip> getAllPaySlip() {
		
		
		return empRepoPaySlip.findAll();
	}

	
	
	
	
}

