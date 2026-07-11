package solidusjack.taskmanager.application;

import java.util.List;

import org.springframework.stereotype.Service;

import solidusjack.taskmanager.application.output.TaskOutput;
import solidusjack.taskmanager.domain.TaskRepository;

@Service
public class GetTasksUseCase {

	private final TaskRepository repository;
	
	public GetTasksUseCase(TaskRepository repository) {
		this.repository = repository;
	}
	
	public List<TaskOutput> execute() {
		return repository.findAll().stream()
				.map(TaskOutput::from)
				.toList();
	}
}
