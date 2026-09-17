package br.com.ndrsilva.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ndrsilva.todolist.entity.Todo;
import br.com.ndrsilva.todolist.repository.TodoRepository;


@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> list() {
        return todoRepository.findAllByOrderByPriorityDescTitleAsc();
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return  list();
    }
}
