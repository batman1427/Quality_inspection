package model;

public class Authority  {
    
    private String username;

    private String equipmentid;

    private Integer procedureid;

    private Integer blockFlag;

    private String createTime;
    
    public Authority() {
    	super();
    }
    
    public Authority(String username) {
    	this.username=username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(String equipmentid) {
        this.equipmentid = equipmentid == null ? null : equipmentid.trim();
    }

    public Integer getProcedureid() {
        return procedureid;
    }

    public void setProcedureid(Integer procedureid) {
        this.procedureid = procedureid;
    }
    
    public Integer getBlockFlag() {
        return blockFlag;
    }

    public void setBlockFlag(Integer blockFlag) {
        this.blockFlag = blockFlag;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}