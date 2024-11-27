const apiUrl = "http://localhost:8080/tasks";  // URL correto do backend

// Função para carregar as tarefas da API
function loadTasks() {
    fetch(apiUrl)
        .then(response => response.json())
        .then(data => {
            const taskList = document.getElementById('task-list');
            taskList.innerHTML = '';  // Limpa a lista antes de repopulá-la

            data.forEach(task => {
                const li = document.createElement('li');
                li.innerHTML = `
                    <span class="${task.completed ? 'completed' : ''}" contenteditable="true" onblur="updateTask(${task.id}, this)">${task.name}</span>
                    <button onclick="deleteTask(${task.id})">Deletar</button>
                    <button onclick="toggleTaskCompletion(${task.id})">${task.completed ? 'Desmarcar' : 'Marcar como concluída'}</button>
                `;
                taskList.appendChild(li);
            });
        })
        .catch(error => console.error('Erro ao carregar as tarefas:', error));
}

// Função para adicionar uma nova tarefa
function addTask() {
    const taskName = document.getElementById('task-name').value;
    if (!taskName) {
        alert("Por favor, insira um nome para a tarefa.");
        return;
    }

    const newTask = {
        name: taskName,
        completed: false
    };

    fetch(apiUrl, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newTask)
    })
    .then(response => response.json())
    .then(() => {
        loadTasks();  // Recarrega as tarefas após adicionar
        document.getElementById('task-name').value = '';  // Limpa o campo de input
    })
    .catch(error => console.error('Erro ao adicionar a tarefa:', error));
}

// Função para deletar uma tarefa
function deleteTask(id) {
    fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    })
    .then(() => loadTasks())  // Recarrega as tarefas após a exclusão
    .catch(error => console.error('Erro ao deletar a tarefa:', error));
}

// Função para alterar o status de conclusão e nome de uma tarefa
function toggleTaskCompletion(id) {
    // Primeiro, obtenha a tarefa e o status atual de conclusão
    fetch(`${apiUrl}/${id}`)
        .then(response => response.json())
        .then(task => {
            const updatedTask = {
                name: task.name,  // Mantém o nome atual da tarefa
                completed: !task.completed  // Alterna o status de conclusão
            };

            // Envia a atualização para o backend
            fetch(`${apiUrl}/${id}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(updatedTask)
            })
            .then(() => loadTasks())  // Recarrega as tarefas após a alteração
            .catch(error => console.error('Erro ao alterar o status da tarefa:', error));
        })
        .catch(error => console.error('Erro ao obter a tarefa:', error));
}

// Função para atualizar o nome de uma tarefa quando o campo for editado
function updateTask(id, span) {
    const updatedTask = {
        name: span.innerText,
        completed: span.classList.contains('completed')
    };

    fetch(`${apiUrl}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedTask)
    })
    .then(() => loadTasks())  // Recarrega as tarefas após a alteração
    .catch(error => console.error('Erro ao atualizar a tarefa:', error));
}

// Carrega as tarefas assim que a página for carregada
window.onload = loadTasks;
