package app.data;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import app.entity.User;

public interface UserRepository {

	User save(User user);
  
	@Cacheable(value = { "myUserCache" })
	User findByUsername(String username);
	
	@CacheEvict(value={"myUserCache"})
	void deleteByUsername(String username);

	//comment me to test testCacheable()
	@CachePut(value="myUserCache", key="#result.username")
	User addUser(User user);
	
}
