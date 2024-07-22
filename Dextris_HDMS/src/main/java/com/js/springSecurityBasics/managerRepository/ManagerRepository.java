package com.js.springSecurityBasics.managerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.js.springSecurityBasics.entityManager.EntityManager;

public interface ManagerRepository extends JpaRepository<EntityManager, Long> {
}
