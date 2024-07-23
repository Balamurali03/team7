package com.dextris.hrms.hr_service.model;

import java.time.LocalDate;

import com.dextris.hrms.hr_service.enums.LoginStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Data
public class HrData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hr_id")
	private Long id;
    private String name;
    private String position;
    private Double salary;
    private LocalDate dateOfJoin=LocalDate.now();
    private String email;
    
    @Column(name = "official_mailid")
    private String officeEmail;
    private String password;
    private String phoneNumber;
    private String department;
    private String emergencyContactName;
    private String emergencyContactPhone;
    
    @Enumerated(value = EnumType.STRING)
    private LoginStatus status= LoginStatus.INACTIVE;
    
    @Transient
    private String admin;
    @Transient
    private String address;
    


}
