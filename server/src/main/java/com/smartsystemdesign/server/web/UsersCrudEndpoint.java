package com.smartsystemdesign.server.web;

import com.smartsystemdesign.server.application.Users;
import com.smartsystemdesign.server.domain.Email;
import com.smartsystemdesign.server.domain.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UsersCrudEndpoint {
    private final Users users;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateUserRequest request) {
        log.info("New User has been created");
        var user = users.create(new Email(request.email()), new Password(request.password()));
        return ResponseEntity.created(URI.create("/users/" + user.getUserId())).build();
    }

}
