package model;

public class User {
    private String username;

    private String password;

    private String wechatid;

    private String name;

    private Integer blockFlag;

    private String createTime;
    
    public User() {
    	super();
    }
    
    public User(String username,String password) {
    	this.username=username;
    	this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getWechatid() {
        return wechatid;
    }

    public void setWechatid(String wechatid) {
        this.wechatid = wechatid == null ? null : wechatid.trim();
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
    
   
}