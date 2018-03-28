package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import model.Authority;
@Repository("AuthorityDao")
public interface AuthorityDao {
    int deleteByPrimaryKey(Authority record);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Authority record);
    
    ArrayList<Authority> selectByUsername(Authority record);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
}