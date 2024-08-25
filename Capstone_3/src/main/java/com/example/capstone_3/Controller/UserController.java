package com.example.capstone_3.Controller;

import com.example.capstone_3.Api.ApiResponse;
import com.example.capstone_3.Model.User;
import com.example.capstone_3.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added successfully"));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity updateUser(@PathVariable Integer userId, @Valid @RequestBody User user) {
        userService.updateUser(userId, user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }
}

