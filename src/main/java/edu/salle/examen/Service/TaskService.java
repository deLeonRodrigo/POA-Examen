package edu.salle.examen.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.salle.examen.Model.Task;
import edu.salle.examen.Repository.taskRepository;

@Service
public class TaskService {
	@Autowired
	private taskRepository taskRepository;

	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	public Task saveOrUpdate(Task task) {
		return taskRepository.save(task);
	}
	
	public Task findOne(long id) {
		return taskRepository.findOne(id);
	}
	
	public List<Task> findUser(long id){
		List<Task> tasks = new ArrayList<>();
		taskRepository.findAll().stream().filter(e -> e.getUserId() == id).forEach(e -> tasks.add(e));
		return tasks;
	}
}
