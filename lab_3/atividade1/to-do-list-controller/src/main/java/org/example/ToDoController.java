package org.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/tasks")
public class ToDoController {
    private List<Task> tasks = new ArrayList<>();
    private long nextId = 1;

    // Obter todas as tarefas
    @Operation(summary= "", description = "Apresenta todas as tasks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks exibidas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao exibir task"),
    })
    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    // Criar nova tarefa
    @Operation(summary= "", description = "Cria uma Task pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar Task"),
    })
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setId(nextId++);
        tasks.add(task);
        return task;
    }

    // Remover tarefa
    @Operation(summary= "", description = "Altera uma Task pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao deletar API"),
    })
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    // Alterar o status da tarefa (completa / incompleta)
    @Operation(summary= "", description = "Alterar uma Task pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task alterada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao alterar Task"),
    })
    @PutMapping("/{id}")
    public Task toggleCompletion(@PathVariable long id,@RequestBody Task taskUpdate) {
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        task.setName(taskUpdate.getName());
        task.setCompleted(taskUpdate.getCompleted());
        return task;
    }
}
