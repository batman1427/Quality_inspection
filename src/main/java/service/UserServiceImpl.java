package service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;


@Service
public class UserServiceImpl implements UserService{

	    @Autowired  
	    private UserDao userDao;  
	      
	    @Override
	    public String getstaffList() {  
	         
	        User a=userDao.selectByPrimaryKey("xwz");
	        System.out.println(a.getPassword());
	           return null;
	    }

}
