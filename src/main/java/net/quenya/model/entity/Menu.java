package net.quenya.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Menu {

    public Long id;
    public String parentId;
    public String name;
    public String permission;
    public String url;
    public Long createId;
    public Date createTime;
    public Date modifyTime;
}
