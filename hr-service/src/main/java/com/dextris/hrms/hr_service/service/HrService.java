package com.dextris.hrms.hr_service.service;

import java.util.List;
import java.util.Optional;

import com.dextris.hrms.hr_service.model.HrData;

public interface HrService {
	
	public Optional<HrData> register(HrData hrData);
	public Optional<HrData> update(HrData hrData);
	public Optional<HrData> getByEmail(String email);
	public Optional<List<HrData>> getAll();
	public boolean deleteByEmail(String email);
	public Optional<HrData> login(String officeMail, String password);
	public boolean logout(String email);

}
