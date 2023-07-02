package com.danielNeves.mongoDb.resource;

import com.danielNeves.mongoDb.DTO.UserDTO;
import com.danielNeves.mongoDb.domain.Post;
import com.danielNeves.mongoDb.domain.User;
import com.danielNeves.mongoDb.resource.util.URL;
import com.danielNeves.mongoDb.services.PostService;
import com.danielNeves.mongoDb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts") // controlador acessa o serviço
public class PostResource {
    @Autowired
    private PostService service; // serviço acessa o repositorio
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findBytitle(@RequestParam(value = "text", defaultValue = "")String text) throws UnsupportedEncodingException {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
