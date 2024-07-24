package com.dextris.hrms.hr_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dextris.hrms.hr_service.model.HrData;

public interface HrRepo extends JpaRepository<HrData, Long>{
	
	public Optional<HrData> findByOfficeEmail(String email);

}
