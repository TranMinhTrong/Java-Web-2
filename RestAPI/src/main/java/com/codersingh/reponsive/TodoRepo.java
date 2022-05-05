package com.codersingh.reponsive;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codersingh.models.Todoitem;

public interface TodoRepo extends JpaRepository<Todoitem, Long> {
	

}
