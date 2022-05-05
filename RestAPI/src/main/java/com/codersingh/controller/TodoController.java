package com.codersingh.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codersingh.models.Todoitem;
import com.codersingh.reponsive.TodoRepo;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {
	@Autowired
	private TodoRepo todoRepo;
	
	@GetMapping
	public List<Todoitem> findAll(){
		return todoRepo.findAll();
	}

	@PostMapping
	public Todoitem save(@Valid @NotNull @RequestBody Todoitem todoitem ) {
		return todoRepo.save(todoitem);
	}
	
	@PutMapping
	public Todoitem update(@Valid @NotNull @RequestBody Todoitem todoitem) {
		return todoRepo.save(todoitem);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		todoRepo.deleteById(id);
	}
}
