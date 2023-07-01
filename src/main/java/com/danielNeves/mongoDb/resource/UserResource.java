package com.danielNeves.mongoDb.resource;

import com.danielNeves.mongoDb.domain.User;
import com.danielNeves.mongoDb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/users") // controlador acessa o serviço
public class UserResource {
    @Autowired
    private UserService service; // serviço acessa o repositorio
    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> finAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
