package com.example.yurinvvspring.controller;

import com.example.yurinvvspring.entity.UserEntity;
import com.example.yurinvvspring.exception.UserAlreadyExistsException;
import com.example.yurinvvspring.exception.UserNotFoundException;
import com.example.yurinvvspring.repository.UserRepo;
import com.example.yurinvvspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Котроллер - слой абстракции, который должен работать конкретно с запросами и ответами.
// В нем не должно быть посторонней логики.
// Эта логика должна быть сохранена в Services

//Presentation layer

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранен");
        } catch (UserAlreadyExistsException ue) {
            return ResponseEntity.badRequest().body(ue.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Ошибка при добавлении нового пользователся!");
        }

    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try {
            //Обращаемся к сервису UserService и возварщаем UserEntity в теле ответа
            return ResponseEntity.ok(userService.getOneUser(id));
        } catch (UserNotFoundException ue) {
            // Обрабатываем исключения
            return ResponseEntity.badRequest().body(ue.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка при удалении!");
        }
    }
}
