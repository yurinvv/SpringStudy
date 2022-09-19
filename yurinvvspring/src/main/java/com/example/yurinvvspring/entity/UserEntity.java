package com.example.yurinvvspring.entity;

import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.util.List;

// После сборки spring app автоматически создастся пустая таблица,
// если не создана, для хранения сущностей данного класса.

//Business layer
@Entity
//@Table(name = "user")
public class UserEntity {
    @Id
    // Укажем, что каждый ID будет автоматически инкрементироваться
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<ToDoEntity> todos;

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ToDoEntity> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDoEntity> todos) {
        this.todos = todos;
    }
}
