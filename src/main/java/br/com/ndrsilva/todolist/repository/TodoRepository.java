package br.com.ndrsilva.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ndrsilva.todolist.entity.Todo;


public interface TodoRepository  extends JpaRepository<Todo, Long>{

}
