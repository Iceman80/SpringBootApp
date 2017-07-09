package myapp.service.impl;

import myapp.model.Department;
import myapp.model.Status;
import myapp.model.User;
import myapp.repository.DepartmentRepository;
import myapp.repository.UserRepository;
import myapp.service.Helper;
import myapp.service.UserService;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements UserService {
    private final static Logger log = LogManager.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<User> findAll() {
        Iterable<User> users = repository.findAll();
        log.info("Find all employee - " + users);
        return (List<User>) users;
    }

    public User findOne(int id) {
        User user = repository.findOne(id);
        log.info("Find employee - " + user + ", by id - " + id);
        return user;
    }

    public List<User> findByAge(int age) {
        Iterable<User> users = repository.findByAgeAfter(age);
        log.info("Find employee - " + users + ", by age after - " + age);
        return (List<User>) users;
    }

    public void deleteUserById(int id) {
        repository.delete(id);
        log.info("Delete employee by id - " + id);
    }

    public void addedUser() {
        repository.save(Helper.getUserList());
        log.info("Persist new users");
    }

    public String changeStatus(int id, Status status) {
        User user = repository.findOne(id);
        if (user != null) {
            user.setStatus(status);
            user.setData(Helper.getCurrentData());
            repository.save(user);
            log.info("employee by id -" + id + "change status");
            return "Ok";
        } else {
            String message = "Error employee by id - " + id + " not found";
            log.info(message);
            return message;
        }
    }

    public List<User> findByStatus(Status status){
        log.info("Found employees by status - "+ status);
        return repository.findByStatus(status);
    }

    public String addDepartment(int id, String departmentName) {
        User user = repository.findOne(id);
        if (user != null) {
            Department department = departmentRepository.findByDepartmentName(departmentName);

//            department.getUsers().add(user);
//            departmentRepository.save(department);

            user.setDepartment(department);
            user.setData(Helper.getCurrentData());
            repository.save(user);
            log.info("employee by id -" + id + "added department");
            return "Ok";
        } else {
            String message = "Error employee by id - " + id + " not found";
            log.info(message);
            return message;
        }
    }
}
