package com.js.springSecurityBasics.managerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.js.springSecurityBasics.entityManager.EntityManager;
import com.js.springSecurityBasics.managerService.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping
    public ResponseEntity<List<EntityManager>> getAllManagers() {
        List<EntityManager> managers = managerService.getAllManagers();
        return new ResponseEntity<>(managers, HttpStatus.OK);
    }

    @GetMapping("/{mId}")
    public ResponseEntity<EntityManager> getManagerById(@PathVariable Long mId) {
    	EntityManager manager = managerService.getManagerById(mId);
        if (manager != null) {
            return new ResponseEntity<>(manager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<EntityManager> createManager(@RequestBody EntityManager manager) {
    	EntityManager savedManager = managerService.saveManager(manager);
        return new ResponseEntity<>(savedManager, HttpStatus.CREATED);
    }

    @PutMapping("/{mId}")
    public ResponseEntity<EntityManager> updateManager(@PathVariable Long mId, @RequestBody EntityManager managerDetails) {
        EntityManager manager = managerService.getManagerById(mId);
        if (manager != null) {
            manager.setmName(managerDetails.getmName());
            manager.setmDepartment(managerDetails.getmDepartment());
            manager.setmMailId(managerDetails.getmMailId());
            manager.setmPhone(managerDetails.getmPhone());
            EntityManager updatedManager = managerService.saveManager(manager);
            return new ResponseEntity<>(updatedManager, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{mId}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long mId) {
        managerService.deleteManager(mId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

