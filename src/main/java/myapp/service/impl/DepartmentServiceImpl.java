package myapp.service.impl;

import myapp.model.Department;
import myapp.repository.DepartmentRepository;
import myapp.service.DepartmentService;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final static Logger log = LogManager.getLogger(DepartmentServiceImpl.class);

    @Autowired
    private DepartmentRepository repository;

    @Override
    public List<Department> findAllDepartments() {
        log.info("Find all departments.");
        return (List<Department>) repository.findAll();
    }

    @Override
    public Department findDepartmentById(int id) {
        log.info("Find department by id - " + id);
        return repository.findOne(id);
    }

    @Override
    public void deleteDepartmentById(int id) {
        log.info("Delete department by id - " + id);
        repository.delete(id);
    }

    @Override
    public void createDepartment(Department department) {
        log.info("Add department");
        repository.save(department);
    }

    @Override
    public Department findByepartmentName(String departmentName) {
        return repository.findByDepartmentName(departmentName);
    }
}
