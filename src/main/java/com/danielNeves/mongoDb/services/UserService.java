package com.danielNeves.mongoDb.services;

import com.danielNeves.mongoDb.domain.User;
import com.danielNeves.mongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository; // repo
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
