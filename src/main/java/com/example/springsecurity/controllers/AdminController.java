package com.example.springsecurity.controllers;

import com.example.springsecurity.payloads.requests.UpdateUserRequest;
import com.example.springsecurity.services.AdminService;
import com.example.springsecurity.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final AdminService adminService;
    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String get() {
        return "GET:: admin controller";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public String post() {
        return "POST:: admin controller";
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put(
            @RequestBody UpdateUserRequest request,
            @RequestParam("userId") Integer userId
    ) {
        return userService.updateUser(request, userId);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    public ResponseEntity<String> delete(
            @RequestParam("userId") Integer userId
    ) {
        return new ResponseEntity<>(adminService.disableUser(userId));
    }

}
