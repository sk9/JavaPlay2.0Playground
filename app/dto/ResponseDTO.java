package dto;
import java.util.List;

import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.POJONode;

import play.libs.Json;
import models.Task;

public class ResponseDTO {

	private ObjectNode objectNode;
	public boolean success;
	public String message;
	public List<Task> data;

	public ResponseDTO(boolean success, String message, List<Task> data) {
		objectNode = Json.newObject();
		objectNode.put("success", success);
		objectNode.put("message", message);
		objectNode.putPOJO("tasks", data);
	}

	public ObjectNode toJson() {
		return objectNode;
	}
}
