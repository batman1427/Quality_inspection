package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;


@Service
public class UserServiceImpl implements UserService{

	    @Autowired  
	    private UserDao userDao;  
	      
	    @Override
	    public User login(User user) {  
	         
	        User result=userDao.selectByPrimaryKey(user.getUsername());
	        if(result!=null) {
	        	return result;
	        }
	        return null;
	    }

}
