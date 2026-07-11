package solidusjack.taskmanager.application;

import org.springframework.stereotype.Service;

import solidusjack.taskmanager.domain.TaskId;
import solidusjack.taskmanager.domain.TaskNotFoundException;
import solidusjack.taskmanager.domain.TaskRepository;

@Service
public class DeleteTaskUserCase {

	private final TaskRepository repository;
	
	public DeleteTaskUserCase(TaskRepository repository) {
		this.repository = repository;
	}
	
	public void execute(TaskId taskId) {
		
		if(repository.findById(taskId).isEmpty()) {
			throw new TaskNotFoundException(taskId);
		}
		
		repository.delete(taskId);
	}
	
}
