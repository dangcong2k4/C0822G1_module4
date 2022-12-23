package com.example.exercise_1.service;

import com.example.exercise_1.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
