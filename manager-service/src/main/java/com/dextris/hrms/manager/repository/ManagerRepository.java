package com.dextris.hrms.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dextris.hrms.manager.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}