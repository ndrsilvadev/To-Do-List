package br.com.ndrsilva.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ndrsilva.todolist.entity.Todo;
import br.com.ndrsilva.todolist.service.TodoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/to-do-list")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Todo create(@Valid @RequestBody Todo todo) {
        Todo createdTodo = todoService.create(todo);
        return createdTodo;
    }

    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }

    @PutMapping
    Todo update(@Valid @RequestBody Todo todo) {
        Todo updateTodo = todoService.update(todo);
        return  updateTodo;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id) {
        todoService.delete(id);
    }
}
