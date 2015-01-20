package com.shinow.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "role_types", schema = "dbo", catalog = "bbs")
public class RoleTypesEntity {
	private int roleId;
	private String roleName;
	private Collection<AdminInfoEntity> adminInfosByRoleId;
	private Collection<UserinfoEntity> userinfosByRoleId;

	@Id
	@Column(name = "role_id")
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Basic
	@Column(name = "role_name")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		RoleTypesEntity that = (RoleTypesEntity) o;

		if (roleId != that.roleId) return false;
		if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = roleId;
		result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "roleTypesByRoleId")
	public Collection<AdminInfoEntity> getAdminInfosByRoleId() {
		return adminInfosByRoleId;
	}

	public void setAdminInfosByRoleId(Collection<AdminInfoEntity> adminInfosByRoleId) {
		this.adminInfosByRoleId = adminInfosByRoleId;
	}

	@OneToMany(mappedBy = "roleTypesByRoleId")
	public Collection<UserinfoEntity> getUserinfosByRoleId() {
		return userinfosByRoleId;
	}

	public void setUserinfosByRoleId(Collection<UserinfoEntity> userinfosByRoleId) {
		this.userinfosByRoleId = userinfosByRoleId;
	}
}
