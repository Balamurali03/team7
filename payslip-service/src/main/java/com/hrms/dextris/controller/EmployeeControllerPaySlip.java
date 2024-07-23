package com.hrms.dextris.controller;

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

import com.hrms.dextris.exception.PaySlipNotFoundException;
import com.hrms.dextris.model.EmployeePaySlip;
import com.hrms.dextris.service.EmployeeServicePaySlip;

@RestController
@RequestMapping("api/payslips")
public class EmployeeControllerPaySlip {

    @Autowired
    private EmployeeServicePaySlip employeeServicePaySlip;

    @PostMapping("save")
    public ResponseEntity<EmployeePaySlip> createPaySlip(@RequestBody EmployeePaySlip empPaySlip) {
        EmployeePaySlip empPaySlip2 = employeeServicePaySlip.createPaySlip(empPaySlip);
        return new ResponseEntity<>(empPaySlip2, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public ResponseEntity<List<EmployeePaySlip>> getAllPaySlip() {
        List<EmployeePaySlip> empPaySlip3 = employeeServicePaySlip.getAllPaySlip();
        return new ResponseEntity<>(empPaySlip3, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeePaySlip> getPaySlipById(@PathVariable Integer id) {
        Optional<EmployeePaySlip> optionalEmpPaySlip =employeeServicePaySlip.getPaySlipById(id);
        if (optionalEmpPaySlip.isPresent()) {
            return new ResponseEntity<>(optionalEmpPaySlip.get(), HttpStatus.OK);
        } else {
            throw new PaySlipNotFoundException("Payslip not found with id " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeePaySlip> updatePayslip(@PathVariable Integer id, @RequestBody EmployeePaySlip empPaySlip) {
        try {
            EmployeePaySlip updatedPayslip =employeeServicePaySlip.updatePayslip(id, empPaySlip);
            return new ResponseEntity<>(updatedPayslip, HttpStatus.OK);
        } catch (PaySlipNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayslip(@PathVariable Integer id) {
        try {
            @SuppressWarnings("unused")
			boolean isDeleted =employeeServicePaySlip.deletePayslip(id);
            return new ResponseEntity<>("deleted successfully", HttpStatus.ACCEPTED);
        } catch (PaySlipNotFoundException e) {
            return new ResponseEntity<>("id not present", HttpStatus.BAD_REQUEST);
        }
    }
}
