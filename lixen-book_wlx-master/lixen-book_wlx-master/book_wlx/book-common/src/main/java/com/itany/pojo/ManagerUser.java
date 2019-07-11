package com.itany.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ManagerUser implements Serializable{

    private Integer id;

    private String username;

    private String password;

    private Integer supplierId;

    private String roleName;

    private List<Role> roles;

}
