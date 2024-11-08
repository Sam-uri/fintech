package com.app.fintech.users.services;

import com.app.fintech.users.dtos.CreateUserDTO;
import com.app.fintech.users.dtos.UserDTO;
import com.app.fintech.users.entities.User;
import com.app.fintech.users.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    public UserDTO getUserById(String id){
        User user = userRepository.findById(Long.valueOf(id))
                .orElseThrow(()->
                        new RuntimeException("User is not avaialble with this id:-"+id)
                );
        return getBuild(user);
    }
    public User getUserEntityById(String id){
        return userRepository.findById(Long.valueOf(id))
                .orElseThrow(()->
                        new RuntimeException("User is not avaialble with this id:-"+id)
                );

    }

    public UserDTO createUser(CreateUserDTO user) {

        User userEntity = userRepository.saveAndFlush(User.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .password(passwordEncoder.encode(user.getPassword()))
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build());

        return getBuild(userEntity);
    }

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        List<User> userList =  userRepository.findAll();
        userList.forEach(u->{
            users.add(getBuild(u));
        });
        return users;
    }

    private static UserDTO getBuild(User user) {
        return UserDTO.builder()
                .id(String.valueOf(user.getId()))
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}
