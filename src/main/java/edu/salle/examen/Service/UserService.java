package edu.salle.examen.Service;

import java.util.List;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.salle.examen.Model.User;
import edu.salle.examen.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User login(String username, String password, String type) {
		List<User> ul = userRepository.findAll();
		Predicate<User> loginInfo = e -> e.getUsername().equals(username) && e.getPassword().equals(password);
		if(ul.stream().anyMatch(loginInfo))
			return ul.stream().filter(loginInfo).findFirst().get();
		else if(ul.stream().anyMatch(e -> e.getUsername().equals(username))) 
			return null;
		if(ul.stream().anyMatch(e -> e.getType().equals("admin")) && type.equals("admin")) 
			return null;
		else if (!type.equals("")) 
			return saveOrUpdate(new User(username, password, type));
		else 
			return null;
	}
	
	public User saveOrUpdate(User user) {
		return userRepository.save(user);
	}
	
}
