package myapp.controller;

import myapp.model.Department;
import myapp.model.Status;
import myapp.model.User;
import myapp.service.DepartmentService;
import myapp.service.UserService;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = ("*"))
@RestController
public class UserController implements Serializable {
    private final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    @Qualifier("employeeService")
    private UserService service;


    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String addedUser() {
        service.addedUser();
        return "Ok";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> findAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User findOne(@PathVariable("id") int id) {
        return service.findOne(id);
    }

    @RequestMapping(value = "/status/{status}", method = RequestMethod.GET)
    public List<User> findByStatus(@PathVariable("status") Status status) {
        return service.findByStatus(status);
    }

    @RequestMapping(value = "/age/{age}", method = RequestMethod.GET)
    public List<User> findByAge(@PathVariable("age") int age) {
        return service.findByAge(age);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUserById(@PathVariable("id") int id) {
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}/{status}", method = RequestMethod.POST)
    public String changeStatus(@PathVariable("id") int id, @PathVariable("status") Status status) {
        return service.changeStatus(id, status);
    }

    @RequestMapping(value = "/user/{id}/department/{name}", method = RequestMethod.PUT)
    public String addDepartmentByName(@PathVariable("id") int id, @PathVariable("name") String departmentName) {
        return service.addDepartment(id, departmentName);
    }

    @RequestMapping(value = "/user/dep/{id}", method = RequestMethod.GET)
    public String showDepartment(@PathVariable("id") int id) {
        return service.findOne(id).getDepartment().getDepartmentName();
    }
}
