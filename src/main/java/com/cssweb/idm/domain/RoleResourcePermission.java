package com.cssweb.idm.domain;

import com.cssweb.common.domain.BaseDomain;

import java.io.Serializable;

/**
 * Created by chenhf on 14-2-21.
 */
public class RoleResourcePermission extends BaseDomain {

    private int roleId;
    private int resourceId;
    private int permissionId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
