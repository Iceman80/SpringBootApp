package myapp.controller;


import myapp.model.Department;
import myapp.model.User;
import myapp.service.DepartmentService;
import myapp.service.Helper;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = ("*"))
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String createDepartment(@RequestBody Department department) {
        service.createDepartment(department);
        return "Create Ok";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveDepartment() {
        for (Department department: Helper.getDepartment()){
            service.createDepartment(department);
        }
        return "Save";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Department> findAll() {
        return service.findAllDepartments();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Department findOne(@PathVariable("id") int id) {
        return service.findDepartmentById(id);
    }

    @RequestMapping(value = "/dep/{name}", method = RequestMethod.GET)
    public Department findByName(@PathVariable("name") String name) {
        return service.findByepartmentName(name);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteByID(@PathVariable("id") int id) {
        service.deleteDepartmentById(id);
        return "Delete by Id OK";
    }
}
