package com.hrms.dextris.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.dextris.model.EmpPaySlip;
import com.hrms.dextris.service.EmpServicePaySlip;

@RestController
@RequestMapping("api/payslips")
public class EmpControllerPaySlip {
	
	@Autowired
	private EmpServicePaySlip empServicePaySlip;
	
	@PostMapping("save")
	 public EmpPaySlip createPayslip(@RequestBody EmpPaySlip empPaySlip) {
        return empServicePaySlip.createPayslip(empPaySlip);
    }
	
	@GetMapping
	public List<EmpPaySlip> getAllPaySlip(){
		return empServicePaySlip.getAllPaySlip();
	}
}
	