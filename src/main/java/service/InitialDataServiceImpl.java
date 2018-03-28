package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AuthorityDao;

@Service
public class InitialDataServiceImpl implements InitialDataService{
	@Autowired  
	private AuthorityService authorityService;

	@Override
	public ArrayList getAuthority(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList getMachine(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
