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
    @Operation(summary = "", description = "Apresenta todas as tasks")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tasks exibidas com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao exibir tasks")
    })
    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    // Obter uma tarefa específica pelo ID
    @Operation(summary = "", description = "Obtém uma Task pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task obtida com sucesso"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable long id) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (task != null) {
            return ResponseEntity.ok(task); // Retorna a tarefa encontrada
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se não encontrada
        }
    }

    // Criar nova tarefa
    @Operation(summary = "", description = "Cria uma Task")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro ao criar Task")
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
            @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable long id) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (task != null) {
            tasks.removeIf(t -> t.getId() == id);
            return ResponseEntity.ok(task); // Retorna a tarefa deletada
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se não encontrada
        }
    }

    // Alterar o status ou nome da tarefa
    @Operation(summary = "", description = "Atualiza uma Task pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Task atualizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Task não encontrada")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable long id, @RequestBody Task taskUpdate) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (task != null) {
            task.setName(taskUpdate.getName());
            task.setCompleted(taskUpdate.getCompleted());
            return ResponseEntity.ok(task); // Retorna a tarefa atualizada
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Retorna 404 se não encontrada
        }
    }
}
