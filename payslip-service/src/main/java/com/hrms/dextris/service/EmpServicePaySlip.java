package com.hrms.dextris.service;

import java.util.List;

import com.hrms.dextris.model.EmpPaySlip;

public interface EmpServicePaySlip {

	public EmpPaySlip createPayslip(EmpPaySlip empPaySlip);

	public List<EmpPaySlip> getAllPaySlip();




}
