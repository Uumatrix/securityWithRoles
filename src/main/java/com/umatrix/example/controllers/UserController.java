package com.umatrix.example.controllers;

import com.umatrix.example.models.Users;
import com.umatrix.example.service.UserService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Users registerAsUser(@RequestBody Users user) {
        user.setRoles("ROLE_USER");
        return userService.register(user);
    }

    @PostMapping("/register/manager")
    public Users registerAsManager(@RequestBody Users user) {
        user.setRoles("ROLE_MANAGER");
        return userService.register(user);
    }

    @PostMapping("/register/admin")
    public Users registerAsAdmin(@RequestBody Users user) {
        user.setRoles("ROLE_ADMIN");
        return userService.register(user);
    }

    @PostMapping("/login")
   // @PreAuthorize("hasRole('ADMIN')")
    public String logIn(@RequestBody Users user) {
        return userService.verify(user);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String admin(){
        return "admin";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/manager")
    @PreAuthorize("hasRole('MANAGER')")
    public String manager(){
        return "manager";
    }



    @GetMapping("/")
    @Operation(
            description = "get endpoints for managers",
            summary = "this is summary for management get endpoint",
            responses = {
                    @ApiResponse(
                            description = "success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "unauthorized / invalid token",
                            responseCode = "403"
                    )
            }
    )
    public String hello() {
        return "hello";
    }


    @Hidden
    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
