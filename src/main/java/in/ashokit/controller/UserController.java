package in.ashokit.controller;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.model.User;
import in.ashokit.service.UserService;

@RestController
public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service  = service;
	}
	
	@PostMapping("/user")
	public String add(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable Integer userId) {
		return service.getUser(userId);
	}
	
	@GetMapping("/users")
	public Collection<User> getAllUsers(){
		return service.getAllUsers();
	}
	
}
