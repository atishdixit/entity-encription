package com.info.edp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.info.edp.entiry.User;
import com.info.edp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        Date date = new Date();
        user.setCreatedDate(date);
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            BeanUtils.copyProperties(updatedUser, user, "id", "createdDate", "lastModifiedDate", "username");
            user.setLastModifiedDate(new Date());
                    // Ignore "id", "createdDate", "username" and "lastModifiedDate" properties
            return userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}