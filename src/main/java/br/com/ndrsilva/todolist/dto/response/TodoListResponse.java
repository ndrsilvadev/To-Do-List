package br.com.ndrsilva.todolist.dto.response;

import br.com.ndrsilva.todolist.entity.Todo;
import java.util.List;


public record TodoListResponse(int total, List<Todo> todos) {

}
