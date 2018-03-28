package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AuthorityDao;
import model.Authority;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	    @Autowired  
	    private AuthorityDao authorityDao;

		@Override
		public ArrayList getAuthority(Authority authority) {
			// TODO Auto-generated method stub
			ArrayList<Authority> al=new ArrayList<Authority>();
			al=authorityDao.selectByUsername(authority);
			for(int i=0;i<al.size();i++) {
				System.out.println(al.get(i).getProcedureid());
			}
			return al;
		}  
	      


}
