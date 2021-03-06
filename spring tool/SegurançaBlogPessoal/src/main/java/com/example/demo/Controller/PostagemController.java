package com.example.demo.Controller;

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

import com.example.demo.model.Postagem;
import com.example.demo.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;

	//MÉTODO FIND ALL---------------------------------------------------
	@GetMapping
	public ResponseEntity<List <Postagem>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	// MÉTODO FIND BY ID------------------------------------------------
	@GetMapping("/{Id}")
	public ResponseEntity<Postagem> GetById(@PathVariable Long Id)
	{
		return repository.findById(Id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//MÉTODO FIND BY TÍTULO-------------------------------------
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo)
	{
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	//MÉTODO POST---------------------------------------------------
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(postagem));
	}
	//MÉTODO PUT -------------------------------------------
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(postagem));
	}
	//MÉTODO DELETE---------------------------------------------------------
	@DeleteMapping("/{Id}")
	public void delete (@PathVariable Long Id)
	{
		repository.deleteById(Id);
	}
	
	
}
