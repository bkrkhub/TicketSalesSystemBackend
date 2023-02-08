package com.ticketsales.repository;


import com.ticketsales.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer>{
    User findByUsername(String username);
}