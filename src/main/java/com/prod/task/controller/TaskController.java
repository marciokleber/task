package com.prod.task.controller;

import com.prod.task.domain.Task;
import com.prod.task.repository.TaskRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class TaskController {

    final private TaskRepository taskRepository;

    @PostMapping("new")
    public ResponseEntity<Task> newTask(@RequestBody @Valid Task newTask){
        taskRepository.save(newTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.findById(id).get());
    }

    @GetMapping("tasks")
    public ResponseEntity<List<Task>> findAllTasks(){
        return ResponseEntity.status(HttpStatus.OK).body(taskRepository.findAll());
    }

}
