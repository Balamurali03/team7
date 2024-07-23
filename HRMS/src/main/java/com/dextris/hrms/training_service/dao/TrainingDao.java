package com.dextris.hrms.training_service.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dextris.hrms.training_service.Entity.Training;

@Repository
public interface TrainingDao extends JpaRepository<Training,Long>{


}
