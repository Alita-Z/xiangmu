package com.syd.ssh.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.syd.ssh.dao.UserDao;
import com.syd.ssh.entity.User;

public class UserManagerImpl implements UserManager {
    
	@Autowired
	private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String id) {
        // TODO Auto-generated method stub
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUser() {
        // TODO Auto-generated method stub
        //System.out.println("usermanager--getalluser");
        return userDao.getAllUser();
    }

    @Override
    public void addUser(User user) {
        // TODO Auto-generated method stub
        userDao.addUser(user);
    }

    @Override
    public boolean delUser(String id) {
        // TODO Auto-generated method stub
        return userDao.delUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        // TODO Auto-generated method stub
        return userDao.updateUser(user);
    }


}
