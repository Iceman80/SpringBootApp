package myapp.service.impl;


import myapp.model.Task;
import myapp.repository.TaskRepository;
import myapp.service.TaskService;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    private final static Logger log = LogManager.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskRepository repository;

    @Override
    public List<Task> findAllTasks() {
        log.info("Find all tasks");
        return (List<Task>) repository.findAll();
    }

    @Override
    public void saveTask(Task task) {
        log.info("Save task - " + task.getDescription());
        repository.save(task);
    }

    @Override
    public Task findTaskById(int taskId) {
        log.info("Find task by Id - " + taskId);
        return repository.findOne(taskId);
    }

    @Override
    public void deleteTaskById(int taskId) {
        log.info("Delete Task by id - " + taskId);
        repository.delete(taskId);
    }
}
