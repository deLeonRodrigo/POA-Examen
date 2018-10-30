package edu.salle.examen.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import edu.salle.examen.Model.Task;
import edu.salle.examen.Service.TaskService;

@RestController
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> read(){
        return new ResponseEntity<List<Task>>(taskService.findAll(), HttpStatus.OK);
    }

	@RequestMapping(value = "/task", method = RequestMethod.POST)
    public ResponseEntity<Task> Post(@RequestBody Task task){
        return new ResponseEntity<Task>(taskService.saveOrUpdate(task), HttpStatus.OK);
    }

	@RequestMapping(value = "/task/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> readById(@PathVariable("id") int id){
		Task task = taskService.findOne(id);
    	HttpStatus statusCode = (task == null ? HttpStatus.NOT_FOUND : (HttpStatus) HttpStatus.OK);
        return new ResponseEntity<Task>(task, statusCode);
    }
    
	@RequestMapping(value = "/task/user/{user}", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> readByUser(@PathVariable("user") int user){
		List<Task> task = taskService.findUser(user);
    	HttpStatus statusCode = (task == null ? HttpStatus.NOT_FOUND : (HttpStatus) HttpStatus.OK);
        return new ResponseEntity<List<Task>>(task, statusCode);
    }
}
