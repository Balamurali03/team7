package com.dextris.hrms.hr_service.service_implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextris.hrms.hr_service.enums.LoginStatus;
import com.dextris.hrms.hr_service.model.HrData;
import com.dextris.hrms.hr_service.repository.HrRepo;
import com.dextris.hrms.hr_service.service.HrService;

@Service
public class HrServiceImpl implements HrService {

	@Autowired
	private HrRepo repo;

	@Override
	public Optional<HrData> register(HrData hrData) {
		boolean isAvilable = repo.existsById(hrData.getId());
		if (!isAvilable) {
			return Optional.of(repo.save(hrData));
		}
		return Optional.empty();
	}

	@Override
	public Optional<HrData> update(HrData hrData) {
		boolean isAvilable = repo.existsById(hrData.getId());
		if (isAvilable) {
			return Optional.of(repo.save(hrData));
		}
		return Optional.empty();
	}

	@Override
	public Optional<List<HrData>> getAll() {
		Optional<List<HrData>> getall = Optional.of(repo.findAll());
		if (getall.isPresent()) {
			return getall;
		}
		return Optional.empty();

	}

	@Override
	public Optional<HrData> login(String officeMail, String password) {

		Optional<HrData> byOfficialMailid = repo.findByOfficeEmail(officeMail);

		if (byOfficialMailid.isPresent()) {

			if (byOfficialMailid.get().getStatus().equals(LoginStatus.INACTIVE)) {

				if (password.equals(byOfficialMailid.get().getPassword())) {

					byOfficialMailid.get().setStatus(LoginStatus.ACTIVE);

					return Optional.of(repo.save(byOfficialMailid.get()));

				} else {
					return null;

				}
			} else {
				return byOfficialMailid;
			}
		}

		return Optional.empty();
	}

	@Override
	public Optional<HrData> getByEmail(String email) {
		Optional<HrData> byOfficialMailid = repo.findByOfficeEmail(email);

		if (byOfficialMailid.isPresent()) {
			return byOfficialMailid;
		} else {
			return Optional.empty();
		}

	}

	@Override
	public boolean deleteByEmail(String email) {
		Optional<HrData> byOfficialMailid = repo.findByOfficeEmail(email);

		if (byOfficialMailid.isPresent()) {
			repo.delete(byOfficialMailid.get());
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean logout(String email) {
		Optional<HrData> byOfficialMailid = repo.findByOfficeEmail(email);
		if(byOfficialMailid.get().getStatus().equals(LoginStatus.ACTIVE)) {
			byOfficialMailid.get().setStatus(LoginStatus.INACTIVE);
			repo.save(byOfficialMailid.get());
			return true;
		}
		return false;
	}

}
