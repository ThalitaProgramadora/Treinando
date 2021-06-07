package com.olisaude.dev.controller;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RestController;

import com.olisaude.dev.model.Client;
import com.olisaude.dev.model.healthProblems;
import com.olisaude.dev.repository.ClientRepository;

@RestController
//serve para deixar aberto a origin do front pode vim de varios lugares.
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClientController {
	 @Autowired
	 private ClientRepository repository;
	 
	 @GetMapping
		public ResponseEntity<List<Client>> getAll() {
			return ResponseEntity.ok(repository.findAll());
		}
	  @GetMapping("/{id}")
	   public ResponseEntity<Client> getById(@PathVariable long id){
		   return repository.findById(id).map(resp ->ResponseEntity.ok(resp))
				   .orElse(ResponseEntity.notFound().build());
	   }
	  @GetMapping("name/{name}")
	   public ResponseEntity<List<Client>> getByName(@PathVariable String nome){
		   return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(nome));
	   }
	   @PostMapping
	   public ResponseEntity<Client> post(@RequestBody Client client){	
		   return ResponseEntity.status(HttpStatus.CREATED)
				   .body(repository.save(client));
	   }
	    
	   @PutMapping
	   public ResponseEntity<Client> put(@RequestBody Client client){
		   return ResponseEntity.ok(repository.save(client));
	   }
	   @DeleteMapping("/{id}")
	   public void delete (@PathVariable long id) {
		   repository.deleteById(id);
	   }
	    //CREATE THE MACHINE TO SHOW AND CREATE THE MACHINE TO CALCULATE SCORE
		//CRIAR O METODO PARA MOSTRAR E CRIAR O METODO PARA CALCULAR SCORE
		public double Calcular(healthProblems healthProblems){
			int sd = 0;
			if(healthProblems.getDegreeProblem() != 0){
				sd = sd + healthProblems.getDegreeProblem();
				}
			//na parte do e^ fica Math.exp(x) é o certo e não Math.E
			healthProblems.setScore((1/(1+Math.E -(-2.8+sd)))*100);
			return healthProblems.getScore();
			}
		ArrayList<Double> lista = new ArrayList<Double>();
		//this part adds the score values of each person and shows the top 10 being from the highest to the lowest score
		//essa parte adiciona os valores do score de cada pessoa e mostra os 10 maiores sendo do maior para o menor score
		public void mostrarAdicionar(healthProblems healthProblems){
			lista.add(healthProblems.getScore());
			Collections.sort(lista,Collections.reverseOrder());	
			//this part shows if the array size is 10 shows the 10 if it is larger that 10 to variable size receives the number 10 to show only the first 10
			//essa parte mostra se o tamanho do array for 10  mostra os 10 se for maior que 10 a variavel tamanho recebe o número 10 para mostrar só os 10 primeiros
			int tamanho =(lista.size() < 10) ? lista.size():10;
			for(int i =0;i < tamanho;i++) {
				    System.out.println(lista.get(i));
				    System.out.println("Nome: "+ Client.class.getName());
					System.out.println("Os scores mais altos: "+healthProblems.getScore());						
			}
		}
			
		
}
