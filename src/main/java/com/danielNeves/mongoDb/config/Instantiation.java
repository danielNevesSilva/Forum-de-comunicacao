package com.danielNeves.mongoDb.config;

import com.danielNeves.mongoDb.DTO.AuthorDTO;
import com.danielNeves.mongoDb.domain.Post;
import com.danielNeves.mongoDb.domain.User;
import com.danielNeves.mongoDb.repository.PostRepository;
import com.danielNeves.mongoDb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception{

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null,sdf.parse("21/03/2023"),"Partiu viagem", "Vou viajar para são paulo. Abraços", new AuthorDTO(maria));
        Post post2 = new Post(null,sdf.parse("23/03/2023"),"Bom dia", "Acordei feliz hoje!",new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
