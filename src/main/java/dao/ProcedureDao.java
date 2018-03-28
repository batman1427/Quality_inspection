package dao;

import org.springframework.stereotype.Repository;

import model.Procedure;
@Repository("ProcedureDao")
public interface ProcedureDao {
    int deleteByPrimaryKey(Procedure record);

    int insert(Procedure record);

    int insertSelective(Procedure record);

    Procedure selectByPrimaryKey(Procedure record);

    int updateByPrimaryKeySelective(Procedure record);

    int updateByPrimaryKey(Procedure record);
}