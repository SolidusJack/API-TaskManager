package solidusjack.taskmanager.application;

import org.springframework.stereotype.Service;

import solidusjack.taskmanager.application.input.UpdateTaskInput;
import solidusjack.taskmanager.application.output.TaskOutput;
import solidusjack.taskmanager.domain.TaskId;
import solidusjack.taskmanager.domain.TaskNotFoundException;
import solidusjack.taskmanager.domain.TaskRepository;

@Service
public class UpdateTaskUseCase {
	private final TaskRepository repository;
	
	public UpdateTaskUseCase(TaskRepository repository) {
		this.repository = repository;
	}
	
	public TaskOutput execute(TaskId id, UpdateTaskInput input) {
		var task = repository.findById(id)
				.orElseThrow(() -> new TaskNotFoundException(id));
		
		task.update(input.title(), input.description(), input.status());
		var update = repository.save(task);
		
		return TaskOutput.from(update);
	}
}
