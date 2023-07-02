package com.danielNeves.mongoDb.services;

import com.danielNeves.mongoDb.DTO.UserDTO;
import com.danielNeves.mongoDb.domain.User;
import com.danielNeves.mongoDb.repository.UserRepository;
import com.danielNeves.mongoDb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repo; // repo

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> optionalUser = repo.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        Optional<User> optionalUser = repo.findById(obj.getId());

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            updateData(existingUser, obj);
            return repo.save(existingUser);
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }


    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());

    }


    public User fromDTo(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(), objDto.getEmail());
    }
}
