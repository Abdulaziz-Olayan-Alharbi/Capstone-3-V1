package com.example.capstone_3.Service;

import com.example.capstone_3.Api.ApiException;
import com.example.capstone_3.Model.User;
import com.example.capstone_3.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id,User user) {
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("User not found");
        }
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        u.setRole(user.getRole());
        userRepository.save(u);
    }

    public void deleteUser(Integer id) {
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }
}
