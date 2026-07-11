package solidusjack.taskmanager.application;

import org.springframework.stereotype.Service;

import solidusjack.taskmanager.application.input.CreateTaskInput;
import solidusjack.taskmanager.application.output.TaskOutput;
import solidusjack.taskmanager.domain.Task;
import solidusjack.taskmanager.domain.TaskRepository;

@Service
public class CreateTaskUseCase {
	private final TaskRepository repository;
	
	public CreateTaskUseCase(TaskRepository repository) {
		this.repository = repository;
	}
	
	public TaskOutput execute(CreateTaskInput input) {
		var task = new Task(input.title(), input.description());
		var saved = repository.save(task);
		return TaskOutput.from(saved);
	}
}
