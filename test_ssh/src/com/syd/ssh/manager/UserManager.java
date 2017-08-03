package com.syd.ssh.manager;

import java.util.List; 
import com.syd.ssh.entity.User;

public interface UserManager {
	public User getUser(String id);
	public List<User> getAllUser();

	public void addUser(User user);

	public boolean delUser(String id);

	public boolean updateUser(User user);
}
