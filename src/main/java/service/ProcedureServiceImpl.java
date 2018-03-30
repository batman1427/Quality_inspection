package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProcedureDao;
import model.Procedure;
@Service
public class ProcedureServiceImpl implements ProcedureService{

	@Autowired  
	private ProcedureDao procedureDao;  
	
	@Override
	public Procedure getProcedure(Procedure record) {
		// TODO Auto-generated method stub
		Procedure p=procedureDao.selectByPrimaryKey(record);
		return p;
	}

}
