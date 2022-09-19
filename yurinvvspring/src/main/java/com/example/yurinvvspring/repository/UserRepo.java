package com.example.yurinvvspring.repository;


import com.example.yurinvvspring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

//Repository - слой абстракции, который работает с базой данных

//Интерфейс для взаимодействия с БД через сервис Spring
//Почитать

//Persistence layer
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    //Какая-то магия. Почитать про Crud inf
    UserEntity findByUserName(String name);
}
