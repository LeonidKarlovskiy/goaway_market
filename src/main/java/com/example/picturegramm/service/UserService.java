package com.example.picturegramm.service;


import com.example.picturegramm.domain.User;
import com.example.picturegramm.dto.UserDto;
import com.example.picturegramm.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<String> listOfAllUsersNames (){
        return userRepository
                .findAll()
                .stream()
                .map(User::getName)
                .collect(Collectors.toList());

    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> listOfAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id).orElse(null);
    }









}
