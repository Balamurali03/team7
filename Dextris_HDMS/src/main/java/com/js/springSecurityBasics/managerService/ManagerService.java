package com.js.springSecurityBasics.managerService;

import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.js.springSecurityBasics.entityManager.EntityManager;
import com.js.springSecurityBasics.managerRepository.ManagerRepository;

import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public List<EntityManager> getAllManagers() {
        return managerRepository.findAll();
    }

    public EntityManager getManagerById(Long mId) {
        return managerRepository.findById(mId).orElse(null);
    }

    public EntityManager saveManager(EntityManager entityManager) {
        return managerRepository.save(entityManager);
    }

    public void deleteManager(Long mId) {
        managerRepository.deleteById(mId);
    }
}
