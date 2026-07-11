package solidusjack.taskmanager.application.input;

import java.util.Optional;

import solidusjack.taskmanager.domain.TaskStatus;

public record UpdateTaskInput(Optional<String> title,
		Optional<String> description,
		Optional<TaskStatus> status) {
	
}
