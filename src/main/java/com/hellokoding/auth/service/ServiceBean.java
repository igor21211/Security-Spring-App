package com.hellokoding.auth.service;

import com.hellokoding.auth.Exeptions.ResourceNotFoundException;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.UserRepository;
import lombok.AllArgsConstructor;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@org.springframework.stereotype.Service
public class ServiceBean implements Service {


    private UserRepository repository;


    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User updateById(Long id, User user) {
        return repository.findById(id)
                .map(entity -> {
                    entity.setUsername(user.getUsername());
                    entity.setEmail(user.getEmail());
                    entity.setCountry(user.getCountry());
                    return repository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id = " + id));
    }

    @Override
    public void removeById(Long id) {
        User user = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        repository.delete(user);
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }

}
