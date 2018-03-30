package service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AuthorityDao;
import model.Authority;
import model.Procedure;

@Service
public class InitialDataServiceImpl implements InitialDataService{
	@Autowired  
	private AuthorityService authorityService;
	@Autowired  
	private ProcedureService procedureService;

	@Override
	public ArrayList getAuthority(String username) {
		// TODO Auto-generated method stub
		Authority authority=new Authority(username);
		ArrayList<Authority> al=new ArrayList<Authority>();
		al=authorityService.getAuthority(authority);
		ArrayList<String> result=new ArrayList<String>();
		for(Authority au:al) {
			Procedure p=new Procedure(au.getEquipmentid(),au.getProcedureid());
			p=procedureService.getProcedure(p);
			String temp=au.getEquipmentid()+"--"+"第"+au.getProcedureid()+"步"+"--"+p.getName();
			result.add(temp);
		}
		/*for(String str:result) {
			System.out.println(str);
		}*/
		return result;
	}

	@Override
	public ArrayList getMachine(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
