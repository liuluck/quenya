package net.quenya.model.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {

    public Long id;
    public String realName;
    public String loginName;
    public String password;
    public boolean enabled;
    public String mobile;
    public String email;
    public int loginTimes;
    public String roles;
    public int loginErrTimes;
    public Date lastLogin;
    public Date createdTime;

    private List<Role> roleList;
}
