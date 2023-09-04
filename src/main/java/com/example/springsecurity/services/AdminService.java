package com.example.springsecurity.services;

import com.example.springsecurity.repositories.UserRepository;
import com.example.springsecurity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final UserRepository repository;
    public HttpStatus disableUser(Integer userId) {
        User user = repository.findById(userId).orElse(null);
        if (user != null && !user.isStatus()) {
            user.setStatus(true);
            repository.save(user);
            return HttpStatus.OK;
        } else {
            return HttpStatus.BAD_REQUEST;
        }
    }
}

