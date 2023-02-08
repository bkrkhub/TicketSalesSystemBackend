package com.ticketsales.repository;

import com.ticketsales.model.Admin;
import org.springframework.data.repository.CrudRepository;


public interface AdminRepository extends CrudRepository <Admin, Integer>{
    Admin findByUsername(String username);
}