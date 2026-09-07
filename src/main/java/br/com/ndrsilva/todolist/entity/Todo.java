package br.com.ndrsilva.todolist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(
        name = "title",
        nullable = false,
        length = 100
    )
    private String title;

    @Column(
        name = "description",
        nullable = false,
        length = 500
    )
    private String description;

    @Column(
        name = "completed",
        nullable = false
    )
    private boolean completed;

    @Column(
        name = "priority",
        nullable = false
    )
    private int priority;


    protected Todo() {}

    public Todo(
        String title,
        String description,
        boolean completed,
        int priority
    ) {
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
