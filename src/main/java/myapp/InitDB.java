package myapp;


import myapp.service.UserService;
import myapp.service.impl.DepartmentServiceImpl;

import javax.annotation.PostConstruct;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InitDB {
    private final static Logger log = LogManager.getLogger(InitDB.class);

    @Autowired
    @Qualifier("employeeService")
    private UserService service;

//  need for first run for initial DB after need commit

//    @PostConstruct
//    public void initDB() {
//        if (service.findAll().isEmpty()) {
//            service.addedUserAndDepartment();
//            log.info("Save Users, Departments and Tasks");
//        }
//    }
}
