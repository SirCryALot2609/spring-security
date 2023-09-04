package com.example.springsecurity.services;

import com.example.springsecurity.payloads.requests.UpdateUserRequest;
import com.example.springsecurity.repositories.UserRepository;
import com.example.springsecurity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String updateUser(UpdateUserRequest request, Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && !user.isStatus()) {
            user.setEmail(request.getEmail());
            user.setFirstname(request.getFirstname());
            user.setLastname(request.getLastname());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            userRepository.save(user);
            return "User information updated successfully.";
        } else {
            return "false.";
        }
    }
}
