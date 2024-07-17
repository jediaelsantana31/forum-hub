package com.challenges.forum_hub.service;

import com.challenges.forum_hub.dto.UserDTO;
import com.challenges.forum_hub.entity.User;
import com.challenges.forum_hub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(userDTO);
        userRepository.save(user);
        return new UserDTO(user);
    }

    public List<UserDTO> listUsers() {
        return userRepository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.update(userDTO);
        return new UserDTO(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}