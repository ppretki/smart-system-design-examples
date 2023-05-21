package com.smartsystemdesign.server.application;

import com.smartsystemdesign.server.domain.Email;
import com.smartsystemdesign.server.domain.Password;
import com.smartsystemdesign.server.domain.User;
import com.smartsystemdesign.server.domain.UserId;
import com.smartsystemdesign.server.domain.UsersRepository;
import io.micrometer.tracing.annotation.NewSpan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Users {
    private final UsersRepository repository;

    @NewSpan("users.create")
    public User create(Email email, Password password) {
        User user = new User();
        user.setEmail(email.value());
        user.setPassword(password.value());
        repository.save(user);
        return user;
    }
}
