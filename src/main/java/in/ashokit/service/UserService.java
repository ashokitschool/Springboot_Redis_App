package in.ashokit.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import in.ashokit.model.User;

@Service
public class UserService {
	
	HashOperations<String, Integer, User> opsForHash = null;
	
	public UserService(RedisTemplate<String, User> redisTemplate) {
		this.opsForHash = redisTemplate.opsForHash();
	}
	
	public String addUser(User user) {
		opsForHash.put("USERS", user.getId(), user);
		return "User Added";
	}
	
	public User getUser(Integer userId) {
		return opsForHash.get("USERS", userId);
	}
	
	public Collection<User> getAllUsers(){
		Map<Integer, User> entries = opsForHash.entries("USERS");
		return entries.values();
	}
}
