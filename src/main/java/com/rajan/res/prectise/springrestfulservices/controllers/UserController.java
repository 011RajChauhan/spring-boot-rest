package com.rajan.res.prectise.springrestfulservices.controllers;

import com.rajan.res.prectise.springrestfulservices.exceptions.UserNotFoundException;
import com.rajan.res.prectise.springrestfulservices.users.User;
import com.rajan.res.prectise.springrestfulservices.users.UserServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceDao userServiceDao;

    @GetMapping("/users/userList")
    public List<User> getAllUsers() {
        return userServiceDao.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public EntityModel<User> getUser(@PathVariable String userId) {
        User user;
        int id;
        try {
            id = Integer.parseInt(userId);
            user = userServiceDao.getUser(id);
            if (user == null) {
                throw new UserNotFoundException("user with id - "+userId+" not found ");
            }
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("User id can only be a number, invalid user id - " + userId);
        }
        EntityModel<User> entityModel = new EntityModel<User>(user);
        WebMvcLinkBuilder linkTo =  linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(linkTo.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@Valid  @RequestBody User user) {

        userServiceDao.addUser(user);

        URI location =
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable String userId){
        User user;
        int id;
        try {
            id = Integer.parseInt(userId);
            user = userServiceDao.delete(id);
            if (user == null) {
                throw new UserNotFoundException("user with id - "+userId+ " not found");
            }
        } catch (Exception e) {
            throw new UserNotFoundException("User id can only be a number, invalid user id - " + userId);
        }

    }
}
