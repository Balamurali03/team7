package com.dextris.hrms.manager.controller;

import java.util.List;
import java.util.Optional;


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

import com.dextris.hrms.manager.entity.Manager;
import com.dextris.hrms.manager.service.ManagerService;

@RestController
@RequestMapping("/api/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
        Optional<Manager> manager = managerService.getManagerById(id);
        return manager.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Manager createManager(@RequestBody Manager manager) {
        return managerService.addManager(manager);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager managerDetails) {
        Manager updatedManager = managerService.updateManager(id, managerDetails);
        return updatedManager != null ? ResponseEntity.ok(updatedManager) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
        return ResponseEntity.noContent().build();
    }
}
