package solidusjack.taskmanager.infrastructure.http.request;

import java.util.Optional;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import solidusjack.taskmanager.application.input.CreateTaskInput;

public record CreateTaskRequest(
		@NotBlank
		@Size(min = 3, max = 100)
		String title,
		Optional<@Size(min = 3, max = 100) String> description) {
	
	public CreateTaskInput toInput() {
		return new CreateTaskInput(title,description);
	}
}
