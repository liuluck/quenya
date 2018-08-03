package net.quenya.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Role {

    public int id;
    public String displayName;
    public String roleLevel;
    public String roleName;
    public String menus;
    public Long createrId;
    public Date creationTime;
}
