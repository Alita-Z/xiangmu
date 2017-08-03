package com.syd.ssh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.SessionFactory;

import com.syd.ssh.entity.User;

public class UserDaoImpl implements  UserDao{
	@Autowired
	private SessionFactory sessionFactory;  

	
	public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }  
      
    @Override  
    public User getUser(String id) {  
          
        String hql = "from User u where u.id=?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, id);
        List list = new ArrayList();
        return (User)query.uniqueResult();
    }  
  
    @Override  
    public List<User> getAllUser() {  
          
        String hql = "from User";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);

        //System.out.println("userdaoimpl getalluser--"+query.list());
        return query.list();  
    }  
  
    @Override  
    public void addUser(User user) {  
        sessionFactory.getCurrentSession().save(user);  
    }  
  
    @Override  
    public boolean delUser(String id) {  
          
        String hql = "delete User u where u.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, id);  
          
        return (query.executeUpdate() > 0);  
    }

	@Override
	public boolean updateUser(User user) {
        String hql = "update User u set u.username = ?,u.password=? where u.id = ?";  
        Query query = sessionFactory.getCurrentSession().createQuery(hql);  
        query.setString(0, user.getUsername());  
        query.setString(1, user.getPassword());  
        query.setString(2, user.getId());  
          
        return (query.executeUpdate() > 0);  
	}  
  
 
}
