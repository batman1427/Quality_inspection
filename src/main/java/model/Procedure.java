package model;

public class Procedure{
    private Integer id;

    private String name;

    private Integer blockFlag;

    private String createTime;

    private String equipmentid;
    
    public Procedure() {
    	super();
    }
    
    public Procedure(String equipmentid,int id) {
    	this.equipmentid=equipmentid;
    	this.id=id;
    	
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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
    
    public String getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(String equipmentid) {
        this.equipmentid = equipmentid == null ? null : equipmentid.trim();
    }
}