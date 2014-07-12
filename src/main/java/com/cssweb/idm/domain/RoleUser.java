package com.cssweb.idm.domain;

import com.cssweb.common.domain.BaseDomain;

import java.io.Serializable;

/**
 * Created by chenhf on 14-2-21.
 */
public class RoleUser extends BaseDomain {
    private int roleId;
    private int userId;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
