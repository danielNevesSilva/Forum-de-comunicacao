package com.danielNeves.mongoDb.services;

import com.danielNeves.mongoDb.DTO.UserDTO;
import com.danielNeves.mongoDb.domain.Post;
import com.danielNeves.mongoDb.domain.User;
import com.danielNeves.mongoDb.repository.PostRepository;
import com.danielNeves.mongoDb.repository.UserRepository;
import com.danielNeves.mongoDb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repo; // repo

    public Post findById(String id) {
        Optional<Post> optionalUser = repo.findById(id);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
    }

}
