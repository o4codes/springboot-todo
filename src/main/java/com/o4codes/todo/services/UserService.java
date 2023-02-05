package com.o4codes.todo.services;

import com.o4codes.todo.models.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);
    User updateUser(Long id, User user);
    void deleteUser(Long id);

}
