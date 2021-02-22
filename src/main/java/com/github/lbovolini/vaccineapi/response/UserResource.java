package com.github.lbovolini.vaccineapi.response;

import com.github.lbovolini.vaccineapi.model.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;

public class UserResource extends RepresentationModel<EntityModel<User>> {

    private final User user;

    public UserResource(User user) {
        super();
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
