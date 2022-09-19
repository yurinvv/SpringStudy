package com.example.yurinvvspring.service;

// Service - слой абстракции, который работает с какой-то конкретной логикой

import com.example.yurinvvspring.entity.UserEntity;
import com.example.yurinvvspring.exception.UserAlreadyExistsException;
import com.example.yurinvvspring.exception.UserNotFoundException;
import com.example.yurinvvspring.model.User;
import com.example.yurinvvspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


//Business layer
@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByUserName(user.getUserName()) != null) {
            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует!");
        }
        return userRepo.save(user);
    }

    public User getOneUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден!");
        }

        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
