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

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
        
    }

    public List<Todo> list() {
        return todoRepository.findAllOrderPriorityDescTitleAsc();
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
