package myapp.service;

import myapp.controller.UserController;
import myapp.model.User;
import myapp.repository.UserRepository;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class UserService {
    private final static Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        Iterable<User> users = repository.findAll();
        log.info("Find all users - " + users);
        return (List<User>) users;
    }

    public User findOne(int id) {
        User user = repository.findOne(id);
        log.info("Find user - " + user + ", by id - " + id);
        return user;
    }

    public List<User> findByAge(int age) {
        Iterable<User> users = repository.findByAgeAfter(age);
        log.info("Find users - " + users + ", by age after - " + age);
        return (List<User>) users;
    }

    public void deleteUserById(int id) {
        repository.delete(id);
        log.info("Delete user by id - " + id);
    }

    public void addedUser() {
        repository.save(new User("Serhii", "Yakovlev", 47, "066-100-82-92"));
        repository.save(new User("Alex", "Ivanov", 27, "066-100-82-93"));
        log.info("Persist new users");
    }

    public String changeStatus(int id, String status) {
        User user = repository.findOne(id);
        if (user != null) {
            user.setStatus(status);
            repository.save(user);
            log.info("User by id -" + id + "change status");
            return "Ok";
        } else {
            String message = "Error user by id - " + id + " not found";
            log.info(message);
            return message;
        }
    }

    public List<User> findByStatus(String status){
        return repository.findByStatus(status);
    }
}
