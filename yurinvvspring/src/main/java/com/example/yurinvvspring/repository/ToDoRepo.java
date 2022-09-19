package com.example.yurinvvspring.repository;

import com.example.yurinvvspring.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;


//Persistence layer
public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
