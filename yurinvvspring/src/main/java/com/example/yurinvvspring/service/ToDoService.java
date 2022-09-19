package com.example.yurinvvspring.service;

import com.example.yurinvvspring.entity.ToDoEntity;
import com.example.yurinvvspring.entity.UserEntity;
import com.example.yurinvvspring.model.ToDo;
import com.example.yurinvvspring.repository.ToDoRepo;
import com.example.yurinvvspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Business layer
@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;

    @Autowired
    private UserRepo userRepo;

    public ToDo createToDo(ToDoEntity toDo, Long userId) {
        UserEntity userEntity = userRepo.findById(userId).get();
        toDo.setUser(userEntity);
        return ToDo.toModel(toDoRepo.save(toDo));
    }

    public ToDo complete(Long id) {
        ToDoEntity todo = toDoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return ToDo.toModel(toDoRepo.save(todo));
    }
}
