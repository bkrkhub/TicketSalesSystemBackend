package com.ticketsales.services;


import com.ticketsales.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUser();
    public User getUserById(int id);
    public void addUser(User user);
    public void deleteUser(int id);
    public User getUserByUsername(String username);
}
