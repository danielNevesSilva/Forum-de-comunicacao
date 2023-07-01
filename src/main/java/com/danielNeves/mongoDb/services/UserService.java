package com.danielNeves.mongoDb.services;

import com.danielNeves.mongoDb.domain.User;
import com.danielNeves.mongoDb.repository.UserRepository;
import com.danielNeves.mongoDb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo; // repo
    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        User user = repo.findById(id).orElseThrow(null);
        return user;
    }
}
