package com.o4codes.todo.services;

import com.o4codes.todo.exceptions.AlreadyExistException;
import com.o4codes.todo.exceptions.NotFoundException;
import com.o4codes.todo.models.User;
import com.o4codes.todo.repository.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public User createUser(User user) {
        User userSearch = userRepo.findByEmail(user.getEmail()).orElse(null);
        if (userSearch != null) throw new AlreadyExistException("User with email already exist");
        userRepo.save(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("User with Id does does not exist"));
    }

    @Override
    public User getUserByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        if (user != null) return user;
        else throw new NotFoundException("User with email does not exist");
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepo.findById(id).orElse(null);
        if (existingUser == null) throw new NotFoundException("User with Id does not exist");
        BeanUtils.copyProperties(user, existingUser);
        userRepo.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepo.findById(id).orElse(null);
        if (existingUser == null) throw new NotFoundException("User with Id does not exist");
        userRepo.delete(existingUser);
    }
}
