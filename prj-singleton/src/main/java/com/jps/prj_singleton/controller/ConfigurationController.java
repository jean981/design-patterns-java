package com.jps.prj_singleton.controller;

import com.jps.prj_singleton.domain.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {

    @GetMapping("/check-instance")
    public ResponseEntity<String> checkInstance() {
        Configuration instance = Configuration.getInstance();

        // Checks whether the instance was created for the first time
        if (instance != null) {
            return ResponseEntity.status(HttpStatus.OK).body("First instance created.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("It's an instance of Configuration.");
        }
    }
}

