package app.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import app.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=app.config.RootConfig.class)
public class UsreRepositoryTest {
	@Autowired
	UserRepository userRepository;
	
	
	//Note: Must remove @CachePut on addUser interface method
	@Test
	public void testCacheable(){
		System.out.println("Please make sure the @CachePut is removed on app.data.UserRepository.addUser(User)");
		
		User user0 = new User(27, "raiden", "raiden@qq.com", "中国");
		userRepository.addUser(user0);
		
		System.out.println("=================================");
		
		String username = "raiden";
		User user = userRepository.findByUsername(username);
		System.out.println("user is: "+user);
		
		System.out.println("=================================");
		System.out.println("Note, findByUsername is not execute again ");
		
		User user1 = userRepository.findByUsername(username);
		System.out.println("repeat: user is: "+user1);
	}
	
	@Test
	public void testCachePut(){
		User user0 = new User(27, "raiden", "raiden@qq.com", "中国");
		userRepository.addUser(user0);
		
		System.out.println("=================================");
		System.out.println("Note, findByUsername is not execute at all");
		
		String username = "raiden";
		User user = userRepository.findByUsername(username);
		System.out.println("user is: "+user);
	}
	
	@Test
	public void testCacheEvict(){
		User user0 = new User(27, "raiden", "raiden@qq.com", "中国");
		userRepository.addUser(user0);
		
		System.out.println("=================================");
		
		userRepository.deleteByUsername("raiden");
		
		System.out.println("=================================");
		System.out.println("Note, findByUsername is not execute at all and it returns null");
		
		String username = "raiden";
		User user = userRepository.findByUsername(username);
		System.out.println("user is: "+user);
	}
}
