package myapp.controller;

import myapp.model.User;
import myapp.repository.UserRepository;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = ("*"))
@RestController
public class UserController {
    private final static Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserRepository repository;

    @RequestMapping("/save")
    public String addedUser() {
        repository.save(new User("Serhii", "Yakovlev", 47, "066-174-82-91"));
        repository.save(new User("Alex", "Ivanov", 27, "066-100-82-93"));
        log.info("Persist new string");
        return "Ok";
    }

    @RequestMapping(value = "/findall", method = RequestMethod.GET)
    public String findAll() {
        String result = "<html>";
        Iterable<User> users = repository.findAll();
        for (User user : users) {
            result += "<div>" + user.toString() + "</div>";
        }
        log.info("Find all users - " + users);
        return result + "</html>";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable("id") int id) {
        User user = repository.findOne(id);
        log.info("Find user - " + user + ", by id - " + id);
        return user;
    }

    @RequestMapping(value = "/age/{age}", method = RequestMethod.GET)
    public String findByAge(@PathVariable("age") int age) {
        Iterable<User> users = repository.findByAgeAfter(age);
        String result = "<html>";
        for (User user : users) {
            result += "<div>" + user.toString() + "</div>";
        }
        log.info("Find users - " + users + ", by age after - " + age);
        return result;
    }
}
