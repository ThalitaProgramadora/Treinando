package com.olisaude.dev.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.olisaude.dev.model.healthProblems;
import com.olisaude.dev.repository.HealthProblemsRepository;

@RestController
//a requisição ira consumir essa classe.
@RequestMapping("/problems")
@CrossOrigin("*")
public class healthProblemsController {
	 @Autowired
	 private HealthProblemsRepository repository;
	 
	 @GetMapping
		public ResponseEntity<List<healthProblems>> getAll() {
			return ResponseEntity.ok(repository.findAll());
		}
	 
	  @GetMapping("/{id}")
	   public ResponseEntity<healthProblems> getById(@PathVariable long id){
		   return repository.findById(id).map(resp ->ResponseEntity.ok(resp))
				   .orElse(ResponseEntity.notFound().build());
	   }
	  @GetMapping("name/{name}")
	   public ResponseEntity<List<healthProblems>> getByName(@PathVariable String name){
		   return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	   }
	   @PostMapping
	   public ResponseEntity<healthProblems> post(@RequestBody healthProblems name){
		   return ResponseEntity.status(HttpStatus.CREATED)
				   .body(repository.save(name));
	   }
	   @PutMapping
	   public ResponseEntity<healthProblems> put(@RequestBody healthProblems name){
		   return ResponseEntity.ok(repository.save(name));
	   }
	   @DeleteMapping("/{id}")
	   public void delete (@PathVariable long id) {
		   repository.deleteById(id);
	   }
}
