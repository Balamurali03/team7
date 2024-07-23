package com.dextris.hrms.training_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.dextris.hrms.training_service.Entity.Training;
import com.dextris.hrms.training_service.requestDto.TrainingRequ;
import com.dextris.hrms.training_service.responseDto.ResponseStructure;

public interface TrainingService {

	ResponseEntity<ResponseStructure<String>> addTrining(TrainingRequ trainingRequ);

	ResponseEntity<ResponseStructure<List<Training>>> getTrining();

	ResponseEntity<ResponseStructure<Training>> getTriningById(Long Id);

	ResponseEntity<ResponseStructure<String>> updateTriningById(TrainingRequ trainingRequ);

	ResponseEntity<ResponseStructure<String>> deleteTriningById(Long id);

}
