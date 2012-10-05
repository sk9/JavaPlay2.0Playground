package controllers;

import java.util.List;

import models.Task;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import play.libs.Json;
import play.mvc.*;
import dto.ResponseDTO;
import dto.TasksDTO;

public class TasksOverview extends Controller {
	
	public static Result ajaxTasks(){
		return ok(views.html.ajaxTasks.render());
	}
	
	protected static List<Task> getTasks() {
		new Json();
		TasksDTO dto = Json.fromJson(request().body().asJson(), TasksDTO.class);

		return dto != null ? dto.data : null;
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result list() {
		List<Task> tasks = Task.all();
		ObjectNode result = new ResponseDTO(true, "test message", tasks).toJson();
		return ok(result);
	}
	
	@BodyParser.Of(BodyParser.Json.class)
	public static Result create() {
		List<Task> tasks = getTasks();

		if (tasks != null) {
			for (Task task : tasks) {
				task.save();
			}

			return ok(new ResponseDTO(true,	"The tasks(s) was create successfully", tasks).toJson());
		}
		return ok(new ResponseDTO(true,	"The tasks(s) cannot be created", null).toJson());
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result update() {
		List<Task> tasks = getTasks();
		
		if (tasks != null) {
			for (Task h : tasks) {
				Task.create(h);
			}
			return ok(new ResponseDTO(true,
					"The tasks(s) was updated successfully", tasks).toJson());
		}
		return  ok(new ResponseDTO(true,	"The tasks(s) cannot be updated", null).toJson());
	}

	@BodyParser.Of(BodyParser.Json.class)
	public static Result delete() {
		JsonNode data = request().body().asJson();

		if (data != null) {
			for (int i = 0; i < data.size(); i++) {
				Task.delete(data.get(i).asLong());
			}
			return ok(new ResponseDTO(true,
					"The task was deleted successfully", null).toJson());
		}
		 return ok(new ResponseDTO(true,
					"The task cannot be deleted", null).toJson());
	}
}
