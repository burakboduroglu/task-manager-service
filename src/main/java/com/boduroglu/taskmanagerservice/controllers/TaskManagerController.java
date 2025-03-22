package com.boduroglu.taskmanagerservice.controllers;

import com.boduroglu.taskmanagerservice.models.dtos.requests.TaskCreateRequest;
import com.boduroglu.taskmanagerservice.models.entities.Task;
import com.boduroglu.taskmanagerservice.services.TaskManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task")
public class TaskManagerController {
    private TaskManagerService taskManagerService;

    public TaskManagerController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Task> createTask(@RequestBody TaskCreateRequest taskCreateRequest) {
        Task createdTask = taskManagerService.createTask(taskCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }


}
