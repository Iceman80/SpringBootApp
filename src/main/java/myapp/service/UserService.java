package myapp.service;


import myapp.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    List<User> findByAge(int age);

    void deleteUserById(int id);

    void addedUser();

    String changeStatus(int id, String status);

    List<User> findByStatus(String status);
}
