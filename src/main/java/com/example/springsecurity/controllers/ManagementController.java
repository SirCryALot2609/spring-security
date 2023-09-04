package com.example.springsecurity.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/management")
@PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
@Tag(name = "Management")
public class ManagementController {
    @Operation(
            description = "Get endpoint for manager",
            summary = "summary test",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    )
            }
    )
    @GetMapping
    @PreAuthorize("hasAuthority('admin:read') or hasAuthority('management:read')")
    public String get() {
        return "GET:: admin controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:create') or hasAuthority('management:create')")
    public String post() {
        return "POST:: admin controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:update') or hasAuthority('management:update')")
    public String put() {
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete') or hasAuthority('management:delete')")
    public String delete() {
        return "DELETE:: admin controller";
    }
}
