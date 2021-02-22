package com.github.lbovolini.vaccineapi.controller;

import com.github.lbovolini.vaccineapi.model.User;
import com.github.lbovolini.vaccineapi.response.UserResource;
import com.github.lbovolini.vaccineapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "api/v1/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserResource> save(@Valid @RequestBody User user) {
        User savedUser = userService.save(user);
        String savedUserId = String.valueOf(savedUser.getId());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(savedUserId + "/")
                .build()
                .toUri();

        UserResource userResource = new UserResource(savedUser);

        return ResponseEntity.created(location).body(userResource);
    }

}
