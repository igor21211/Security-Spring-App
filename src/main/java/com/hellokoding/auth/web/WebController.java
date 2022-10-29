package com.hellokoding.auth.web;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.service.Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class WebController {




    private Service service;


    //Операция сохранения юзера в базу данных

    public User saveEmployee(@RequestBody  User user) {
        return service.create(user);
    }

    //  Получение списка юзеров
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return service.getAll();
        // return employee.stream().map(EmployeeDto::map).collect(Collectors.toList());
    }

    //Получения юзера по id
    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<User> getEmployeeById(@PathVariable Long id) {
        return service.getById(id);
        // return userMapper.toReadDto(employee);
    }

    //Обновление юзера
    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User refreshEmployee(@PathVariable("id") Long id, @RequestBody User user) {
        return service.updateById(id, user);
    }


    //Удаление по id
    @PatchMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeEmployeeById(@PathVariable Long id) {
        service.removeById(id);
    }

    //Удаление всех юзеров
    @DeleteMapping("/users")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeAllUsers() {
        service.removeAll();
    }

    @GetMapping(value = "/users", params = {"email"})
    @ResponseStatus(HttpStatus.OK)
    public User findByEmail(@RequestParam(value = "email") String email) {
        return service.findByEmail(email);
    }

}
