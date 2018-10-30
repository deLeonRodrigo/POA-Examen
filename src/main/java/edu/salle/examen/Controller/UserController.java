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
import edu.salle.examen.Model.User;
import edu.salle.examen.Service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> read(){
        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.OK);
    }
	
	@RequestMapping(value = "/user/{username}/{password}/{type}", method = RequestMethod.GET)
    public ResponseEntity<User> login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type){
		User user = userService.login(username, password, type);
    	HttpStatus statusCode = (user == null ? HttpStatus.NOT_FOUND : (HttpStatus) HttpStatus.OK);
    	return new ResponseEntity<User>(user, statusCode);
    }
	@RequestMapping(value = "/user/{username}/{password}", method = RequestMethod.GET)
    public ResponseEntity<User> login(@PathVariable("username") String username, @PathVariable("password") String password){
		User user = userService.login(username, password, "");
    	HttpStatus statusCode = (user == null ? HttpStatus.NOT_FOUND : (HttpStatus) HttpStatus.OK);
    	return new ResponseEntity<User>(user, statusCode);
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.PUT)
    public ResponseEntity<User> saveOrUpdate(@RequestBody User u){
		User user = userService.saveOrUpdate(u);
    	HttpStatus statusCode = (user == null ? HttpStatus.NOT_FOUND : (HttpStatus) HttpStatus.OK);
    	return new ResponseEntity<User>(user, statusCode);
    }
}
