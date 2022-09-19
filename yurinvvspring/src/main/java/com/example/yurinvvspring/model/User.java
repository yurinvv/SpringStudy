package com.example.yurinvvspring.model;

// Model - это обычный класс, который будет использоваться на клиенте
// и с помощью которого будет просиходит обмен данными между сервером и клиентом
// В данном случае, с помощью этого класса мы определяем то, что следует отправить клиенту

import com.example.yurinvvspring.entity.UserEntity;


import java.util.List;
import java.util.stream.Collectors;

//Business layer
public class User {
    private Long id;
    private String name;
    private List<ToDo> toDos;


    // Создание модели
    public static User toModel(UserEntity userEntity) {
        User model = new User();
        model.setId(userEntity.getId());
        model.setName(userEntity.getUserName());
        model.setToDos(userEntity.getTodos().stream().map(ToDo::toModel).collect(Collectors.toList()));
        return model;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ToDo> getToDos() {
        return toDos;
    }

    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }
}
