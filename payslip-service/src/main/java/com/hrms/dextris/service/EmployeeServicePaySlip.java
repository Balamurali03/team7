package com.hrms.dextris.service;

import java.util.List;
import java.util.Optional;

import com.hrms.dextris.model.EmployeePaySlip;

public interface EmployeeServicePaySlip {

	public EmployeePaySlip createPaySlip(EmployeePaySlip empPaySlip);

	public List<EmployeePaySlip> getAllPaySlip();

	public Optional<EmployeePaySlip> getPaySlipById(Integer id);

	public EmployeePaySlip updatePayslip(Integer id, EmployeePaySlip empPaySlip);

	public boolean deletePayslip(Integer id);






}
