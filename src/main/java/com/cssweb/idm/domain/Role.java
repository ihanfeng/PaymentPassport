package com.cssweb.idm.domain;

import com.cssweb.common.domain.BaseDomain;

import java.io.Serializable;

/**
 * Created by chenhf on 14-2-20.
 */
public class Role extends BaseDomain {
    private int id;

    private String roleName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
