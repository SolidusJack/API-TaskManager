package solidusjack.taskmanager.infrastructure.http.request;

import java.util.Optional;

import solidusjack.taskmanager.application.input.UpdateTaskInput;
import solidusjack.taskmanager.domain.TaskStatus;

public record UpdateTaskRequest(
		Optional<String> title,
		Optional<String> description,
		Optional<String> status	
){
	public UpdateTaskInput toInput() {
		return new UpdateTaskInput(title, description,status.map(TaskStatus::valueOf));
	}
}
