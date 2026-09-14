package br.com.ndrsilva.todolist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    @Size(
        max = 100,
        message = "O titulo deve ter no máximo 100 caracteres."
    )
    @Column(
        name = "title",
        nullable = false,
        length = 100
    )
    private String title;

    @NotBlank(message = "A descrição é obrigatório.")
    @Size(
        max = 500,
        message = "A descrição deve ter no máximo 500 caracteres."
    )
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

    @NotNull(message = "A prioridade é obrigatório.")
    @Min(
        value = 1,
        message = "A prioridade mínima é 1."
    )
    @Max(
        value = 5,
        message = "A prioridade máxima é 5."
    )
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
