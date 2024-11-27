package org.example;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500") // Permite requisições do frontend
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
    @Operation(summary = "", description = "Deleta uma Task pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task deletada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao deletar Task")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable long id) {
        // Encontra a tarefa a ser deletada
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);

        if (task != null) {
            tasks.removeIf(t -> t.getId() == id);  // Remove a tarefa
            return ResponseEntity.ok(task);  // Retorna a tarefa deletada com status 200
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();  // Retorna 400 se não encontrar a tarefa
        }
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
