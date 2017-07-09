package myapp.service;


import myapp.model.Department;
import myapp.model.Status;
import myapp.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(int id);

    List<User> findByAge(int age);

    void deleteUserById(int id);

    void addedUser();

    String changeStatus(int id, Status status);

    List<User> findByStatus(Status status);

    public String addDepartment(int id, String department);
}
