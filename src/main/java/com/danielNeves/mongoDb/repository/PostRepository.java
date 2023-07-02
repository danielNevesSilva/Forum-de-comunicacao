package com.danielNeves.mongoDb.repository;

import com.danielNeves.mongoDb.domain.Post;
import com.danielNeves.mongoDb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String > {

}
