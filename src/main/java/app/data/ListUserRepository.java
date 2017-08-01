package app.data;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import app.entity.User;

@Repository
public class ListUserRepository implements UserRepository {
	private Set<User> userSet = new HashSet<>();

	@Override
	public User save(User user) {
		System.out.println("save executed");
		userSet.add(user);
		System.out.println(user);
		return user;
	}
	@Override
	public User addUser(User user){
		System.out.println("addUser executed");
		int maxId = 1;
		for (User existingUser:userSet) {
			if (existingUser.getId()>maxId){
				maxId = existingUser.getId()+1;
				break;
			}
		}
		user.setId(maxId);
		userSet.add(user);
		System.out.println(user);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		System.out.println("findByUsername executed");
		if (username != null) {
			for (User user : userSet) {
				if (user.getUsername().equals(username)) {
					System.out.println(user);
					return user;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public void deleteByUsername(String username) {
		System.out.println("deleteByUsername executed");
		for (User user : userSet) {
			if (user.getUsername().equals(username)) {
				System.out.println(user);
				userSet.remove(user);
				break;
			}
		}
	}

}
