package com.vektorel.eticaretrestapi.service;

import com.vektorel.eticaretrestapi.repository.UserRepository;
import com.vektorel.eticaretrestapi.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }

    public Optional<User> findById(long id){
        return  userRepository.findById(id);
    }

    public Optional<User> findUserAndPassword(String username,String password){
        return userRepository.findOptionalByUsernameAndPassword(username,password);
    }
}
