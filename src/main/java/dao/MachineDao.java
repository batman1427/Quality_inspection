package dao;

import org.springframework.stereotype.Repository;

import model.Machine;
@Repository("MachineDao")
public interface MachineDao {
    int deleteByPrimaryKey(String qrcode);

    int insert(Machine record);

    int insertSelective(Machine record);

    Machine selectByPrimaryKey(String qrcode);

    int updateByPrimaryKeySelective(Machine record);

    int updateByPrimaryKey(Machine record);
}