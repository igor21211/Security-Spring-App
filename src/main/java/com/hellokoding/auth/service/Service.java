package com.hellokoding.auth.service;


import com.hellokoding.auth.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public interface Service {


    User create (User user);

    User findByEmail(String email);

    List<User> getAll();

    Optional<User> getById(Long id);

    User updateById(Long id, User user);

    void removeById(Long id);

    void removeAll();
}
