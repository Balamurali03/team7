package com.dextris.hrms.training_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dextris.hrms.training_service.Entity.Training;
import com.dextris.hrms.training_service.requestDto.TrainingRequ;
import com.dextris.hrms.training_service.responseDto.ResponseStructure;
import com.dextris.hrms.training_service.service.TrainingService;



@RestController
@RequestMapping("/Training")
public class TrainingController {
	
	@Autowired
	TrainingService trainingService;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseStructure<String>> addTrining(@RequestBody TrainingRequ trainingRequ)
	{
		return trainingService.addTrining(trainingRequ);
		
	}
	
	@GetMapping("/getAllTrining")
	public ResponseEntity<ResponseStructure<List<Training>>> getTrining()
	{
		return trainingService.getTrining();
		
	}
	
	@GetMapping("/getTriningById/{Id}")
	public ResponseEntity<ResponseStructure<Training>> getTriningById(@PathVariable Long Id)
	{
		return trainingService.getTriningById(Id);
		
	}
	
	@PutMapping("/updateTriningById")
	public ResponseEntity<ResponseStructure<String>> updateTriningById(@RequestBody TrainingRequ trainingRequ)
	{
		return trainingService.updateTriningById(trainingRequ);
		
	}

	@DeleteMapping("/updateTriningById/{Id}")
	public ResponseEntity<ResponseStructure<String>> deleteTriningById(@PathVariable  Long Id)
	{
		return trainingService.deleteTriningById(Id);
	}
}
