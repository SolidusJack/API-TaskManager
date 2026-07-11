package solidusjack.taskmanager.application;

import org.springframework.stereotype.Service;

import solidusjack.taskmanager.application.output.TaskOutput;
import solidusjack.taskmanager.domain.TaskId;
import solidusjack.taskmanager.domain.TaskNotFoundException;
import solidusjack.taskmanager.domain.TaskRepository;

@Service
public class GetTaskByIdUseCase {

	private final TaskRepository repository;
	
	public GetTaskByIdUseCase(TaskRepository repository) {
		this.repository = repository;
	}
	
	public TaskOutput execute(TaskId id) {
		return repository.findById(id)
				.map(TaskOutput::from)
				.orElseThrow(() -> new TaskNotFoundException(id));
	}
}
