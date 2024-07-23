package com.dextris.hrms.hr_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.dextris.hrms.hr_service.enums.LoginStatus;
import com.dextris.hrms.hr_service.exception.AlreadyLoggedoffException;
import com.dextris.hrms.hr_service.exception.NoDataPresentException;
import com.dextris.hrms.hr_service.exception.PasswordMismatchException;
import com.dextris.hrms.hr_service.exception.UserAlreadyExistException;
import com.dextris.hrms.hr_service.exception.UserAlreadyLoggedInException;
import com.dextris.hrms.hr_service.exception.UserNotExistException;
import com.dextris.hrms.hr_service.model.HrData;
import com.dextris.hrms.hr_service.service.HrService;

@RestController
public class HrController {

	@Autowired
	private HrService service;

	@PostMapping("/register")
	public ResponseEntity<HrData> register(@RequestBody HrData hrData) {
		Optional<HrData> data = service.register(hrData);
		if (data.isPresent()) {
			return ResponseEntity.accepted().body(data.get());
		}
		throw new UserAlreadyExistException("HR Already exist with this id: " + hrData.getId());// user already exist

	}

	@PatchMapping("/update")
	public ResponseEntity<HrData> update(@RequestBody HrData hrData) {
		Optional<HrData> data = service.update(hrData);
		if (data.isPresent()) {
			return ResponseEntity.accepted().body(data.get());
		}
		throw new UserNotExistException("No HR data exist with this id to update: " + hrData.getId());// user not exist

	}

	@GetMapping("/get")
	public ResponseEntity<HrData> getByEmail(@RequestHeader String email) {
		Optional<HrData> byEmail = service.getByEmail(email);
		if (byEmail.isPresent()) {
			return ResponseEntity.ok().body(byEmail.get());
		}
		throw new UserNotExistException("No HR exist with this mailId : " + email);//

	}

	@GetMapping("/getall")
	public ResponseEntity<List<HrData>> getAll() {
		Optional<List<HrData>> all = service.getAll();
		if (all.isPresent()) {
			return ResponseEntity.ok().body(all.get());
		}
		throw new NoDataPresentException("No HR added or registered");// no data present
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteByEmail(@RequestHeader String email) {
		boolean isDeleted = service.deleteByEmail(email);
		if (isDeleted) {
			return ResponseEntity.ok().body("Data deleted Successfully");
		}

		throw new UserNotExistException("No HR exist with this mailId to be deleted : " + email);

	}

	@GetMapping("/login")
	public ResponseEntity<HrData> login(@RequestHeader String officeMail, @RequestHeader String password) {

		Optional<HrData> login = service.login(officeMail, password);
		if (login == null) {
			throw new PasswordMismatchException("The provided password is incorrect");// password missmatch
		} else if (login.isPresent() && login.get().getStatus().equals(LoginStatus.ACTIVE)) {
			throw new UserAlreadyLoggedInException("The HR already loggedin into the application");// user already
																									// logged in

		} else if (login.isEmpty()) {
			throw new UserNotExistException("No HR exist with this mailId : " + officeMail);// no user present
		}
		return ResponseEntity.ok().body(login.get());

	}
	@GetMapping("/logout")
	public ResponseEntity<String> logout(@RequestHeader String email) {
		boolean isLogout = service.logout(email);
		if(isLogout) {
			return ResponseEntity.ok().body("Account got logged off");
		}
		throw new AlreadyLoggedoffException("The HR no longer logged in with this mailId  : " + email);
	}

}
