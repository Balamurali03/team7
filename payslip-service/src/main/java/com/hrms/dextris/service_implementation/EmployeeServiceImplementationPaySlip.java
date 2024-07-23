package com.hrms.dextris.service_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dextris.exception.PaySlipNotFoundException;
import com.hrms.dextris.model.EmployeePaySlip;
import com.hrms.dextris.repository.EmployeeRepositoryPaySlip;
import com.hrms.dextris.service.EmployeeServicePaySlip;

@Service
public class EmployeeServiceImplementationPaySlip implements EmployeeServicePaySlip {

    @Autowired
    public EmployeeRepositoryPaySlip empRepoPaySlip;

    @Override
    public EmployeePaySlip createPaySlip(EmployeePaySlip empPaySlip) {
        return empRepoPaySlip.save(empPaySlip);
    }

    @Override
    public List<EmployeePaySlip> getAllPaySlip() {
        return empRepoPaySlip.findAll();
    }

    @Override
    public Optional<EmployeePaySlip> getPaySlipById(Integer id) {
        return empRepoPaySlip.findById(id);
    }

    @Override
    public EmployeePaySlip updatePayslip(Integer id, EmployeePaySlip empPaySlip) {
        Optional<EmployeePaySlip> optionalEmpPaySlip6 = empRepoPaySlip.findById(id);
        if (optionalEmpPaySlip6.isPresent()) {
            EmployeePaySlip empPaySlip9 = optionalEmpPaySlip6.get();
            empPaySlip9.setEmployeeName(empPaySlip.getEmployeeName());
            empPaySlip9.setDepartment(empPaySlip.getDepartment());
            empPaySlip9.setDoj(empPaySlip.getDoj());
            empPaySlip9.setSalary(empPaySlip.getSalary());
            empPaySlip9.setLocation(empPaySlip.getLocation());
            empPaySlip9.setAdharNo(empPaySlip.getAdharNo());
            empPaySlip9.setPayDate(empPaySlip.getPayDate());
            empPaySlip9.setMonth(empPaySlip.getMonth());
            empPaySlip9.setAccountDetails(empPaySlip.getAccountDetails());
            return empRepoPaySlip.save(empPaySlip9);
        } else {
            throw new PaySlipNotFoundException("Payslip not found with id " + id);
        }
    }

    @Override
    public boolean deletePayslip(Integer id) {
        if (empRepoPaySlip.existsById(id)) {
            empRepoPaySlip.deleteById(id);
            return true;
        } else {
            throw new PaySlipNotFoundException("Payslip not found with id " + id);
        }
    }
}
