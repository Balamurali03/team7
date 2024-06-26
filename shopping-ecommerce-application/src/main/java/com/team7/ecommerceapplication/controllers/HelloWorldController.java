package com.team7.ecommerceapplication.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HelloWorldController {

    @GetMapping("/cart")
    public String welcomeMessage() {
        return "Welcome to the e-Cart Application!";
    }

	  @GetMapping("hello-world")
	  public ResponseEntity<String> printHelloWorld() {
		  return ResponseEntity.accepted().body("Hello World!");
	  }
}
