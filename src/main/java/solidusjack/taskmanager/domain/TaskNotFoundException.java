package solidusjack.taskmanager.domain;


public class TaskNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(TaskId taskid) {
		super("Task with id" + taskid + "not found");
	}
	
}
