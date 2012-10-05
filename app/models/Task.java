package models;

import java.util.*;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

@Entity
public class Task extends Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Required
	public String label;
	
	public static Model.Finder<Long, Task> find = new Finder<Long, Task>(Long.class,
			Task.class);

	public static List<Task> all() {
		return find.all();
	}

	public static void create(Task task) {
		task.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	
	public String toString(){
		return label;
	}

}
