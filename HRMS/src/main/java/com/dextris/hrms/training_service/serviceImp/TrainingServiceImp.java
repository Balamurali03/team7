package com.dextris.hrms.training_service.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dextris.hrms.training_service.Entity.Training;
import com.dextris.hrms.training_service.dao.TrainingDao;
import com.dextris.hrms.training_service.requestDto.TrainingRequ;
import com.dextris.hrms.training_service.responseDto.ResponseStructure;
import com.dextris.hrms.training_service.service.TrainingService;

@Service
public class TrainingServiceImp implements TrainingService{
	
	@Autowired
	TrainingDao trainingDao;

	@Override
	public ResponseEntity<ResponseStructure<String>> addTrining(TrainingRequ trainingRequ) {
		Long Id = trainingRequ.getId();
		Optional<Training> training = trainingDao.findById(Id);
		if(!training.isPresent())
		{
			Training tra=new Training();
			Training traning2 =conTrainingRequToTraining(tra,trainingRequ);

			trainingDao.save(traning2);
			ResponseStructure<String> respo=new ResponseStructure<>();
			respo.setStatusCode(201);
			respo.setMessage("inserted successfully");
			respo.setData("one Training added successfullyS");
			
			return new ResponseEntity<ResponseStructure<String>>(respo, HttpStatus.CREATED);
						
		}
		else {
			ResponseStructure<String> respo=new ResponseStructure<>();
			respo.setStatusCode(500);
			respo.setMessage("Not Inserted");
			respo.setData("Not Inserted");
			
			return new ResponseEntity<ResponseStructure<String>>(respo, HttpStatus.BAD_REQUEST);
			}
	}
	
	
	
	
	
	
	
	

	@Override
	public ResponseEntity<ResponseStructure<List<Training>>> getTrining() {
		List<Training> training=trainingDao.findAll();
		ResponseStructure<List<Training>> respo=new ResponseStructure<>();
		respo.setStatusCode(200);
		respo.setMessage("fetching successfully");
		respo.setData(training);
		return new ResponseEntity<ResponseStructure<List<Training>>>(respo, HttpStatus.OK);
	}
	
	
	
	
	
	
	

	@Override
	public ResponseEntity<ResponseStructure<Training>> getTriningById(Long Id) {
		Optional<Training> training = trainingDao.findById(Id);
		ResponseStructure<Training> respo=new ResponseStructure<>();
		respo.setStatusCode(200);
		respo.setMessage("fetching successfully");
		respo.setData(training.get());
		return new ResponseEntity<ResponseStructure<Training>>(respo, HttpStatus.OK);
	}

	
	
	
	
	
	
	
	@Override
	public ResponseEntity<ResponseStructure<String>> updateTriningById(TrainingRequ trainingRequ) {
		Optional<Training> training = trainingDao.findById(trainingRequ.getId());
		if(training.isPresent())
		{
			Training training2 = conTrainingRequToTraining(training.get(),trainingRequ);
			trainingDao.save(training2);
			ResponseStructure<String> respo=new ResponseStructure<>();
			respo.setStatusCode(201);
			respo.setMessage("updated successfully");
			respo.setData("one data updated successfully");
			
			return new ResponseEntity<ResponseStructure<String>>(respo, HttpStatus.OK);
		}
		else {
		ResponseStructure<String> respo=new ResponseStructure<>();
		respo.setStatusCode(500);
		respo.setMessage("Not updated");
		respo.setData("Not updated");
		
		return new ResponseEntity<ResponseStructure<String>>(respo, HttpStatus.BAD_REQUEST);
		}			
	}
	
	private Training conTrainingRequToTraining(Training training, TrainingRequ trainingRequ) {
		training.setId(trainingRequ.getId());
		training.setName(trainingRequ.getName());
		training.setStartDate(trainingRequ.getStartDate());
		training.setEndDate(trainingRequ.getEndDate());
		return training;
	}

	
	

	
	
	@Override
	public ResponseEntity<ResponseStructure<String>> deleteTriningById(Long id) {
		trainingDao.deleteById(id);
		ResponseStructure<String> respo=new ResponseStructure<>();
		respo.setStatusCode(201);
		respo.setMessage("deleted successfully");
		respo.setData("one Training deleted successfully");
		
		return new ResponseEntity<ResponseStructure<String>>(respo, HttpStatus.OK);
	}
	
}