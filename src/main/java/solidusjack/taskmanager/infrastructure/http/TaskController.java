 package solidusjack.taskmanager.infrastructure.http;


import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import solidusjack.taskmanager.application.CreateTaskUseCase;
import solidusjack.taskmanager.application.DeleteTaskUserCase;
import solidusjack.taskmanager.application.GetTaskByIdUseCase;
import solidusjack.taskmanager.application.GetTasksUseCase;
import solidusjack.taskmanager.application.UpdateTaskUseCase;
import solidusjack.taskmanager.domain.TaskId;
import solidusjack.taskmanager.infrastructure.http.request.CreateTaskRequest;
import solidusjack.taskmanager.infrastructure.http.request.UpdateTaskRequest;
import solidusjack.taskmanager.infrastructure.http.response.TaskResponse;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	private final CreateTaskUseCase createTaskUseCase;
	private final GetTasksUseCase getTasksUseCase;
	private final GetTaskByIdUseCase getTaskByIdUseCase;
	private final DeleteTaskUserCase deleteTaskUserCase;
	private final UpdateTaskUseCase updateTaskUseCase;
	
	public TaskController(CreateTaskUseCase createTaskUseCase, GetTasksUseCase getTasksUseCase, GetTaskByIdUseCase getTaskByIdUseCase, DeleteTaskUserCase deleteTaskUserCase, UpdateTaskUseCase updateTaskUseCase) {
		this.createTaskUseCase = createTaskUseCase;
		this.getTasksUseCase = getTasksUseCase;
		this.getTaskByIdUseCase =  getTaskByIdUseCase;
		this.deleteTaskUserCase = deleteTaskUserCase;
		this.updateTaskUseCase = updateTaskUseCase;
	}
	
	
	@PostMapping
	TaskResponse create(@RequestBody @Valid CreateTaskRequest request) {
		var input = request.toInput();
		var output = createTaskUseCase.execute(input);
		return TaskResponse.from(output);
	}
	
	@GetMapping
	List<TaskResponse> List(){
		return getTasksUseCase.execute().stream()
				.map(TaskResponse::from)
				.toList();
	}
	
	@GetMapping("/{id}")
	TaskResponse read(@PathVariable UUID id) {
		var output = getTaskByIdUseCase.execute(new TaskId(id));
		return TaskResponse.from(output);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void delete(@PathVariable UUID id) {
		deleteTaskUserCase.execute(new TaskId(id));
	}
	
	@PatchMapping("/{id}")
	TaskResponse update(@PathVariable UUID id,@RequestBody UpdateTaskRequest request) {
		var input = request.toInput();
		var output = updateTaskUseCase.execute(new TaskId(id), input);
		return TaskResponse.from(output);
	}
	
	
}
