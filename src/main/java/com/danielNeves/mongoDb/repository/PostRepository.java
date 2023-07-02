package com.danielNeves.mongoDb.repository;

import com.danielNeves.mongoDb.domain.Post;
import com.danielNeves.mongoDb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String > {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
