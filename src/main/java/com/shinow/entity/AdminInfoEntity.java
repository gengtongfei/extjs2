package com.shinow.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "admin_info")
public class AdminInfoEntity {
	private int adminId;
	private String adminName;
	private String adminPass;
	private RoleTypesEntity roleTypesByRoleId;
	private SexTypesEntity sexTypesBySexTypeCode;

	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Basic
	@Column(name = "admin_name")
	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	@Basic
	@Column(name = "admin_pass")
	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AdminInfoEntity that = (AdminInfoEntity) o;

		if (adminId != that.adminId) return false;
		if (adminName != null ? !adminName.equals(that.adminName) : that.adminName != null) return false;
		if (adminPass != null ? !adminPass.equals(that.adminPass) : that.adminPass != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = adminId;
		result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
		result = 31 * result + (adminPass != null ? adminPass.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	public RoleTypesEntity getRoleTypesByRoleId() {
		return roleTypesByRoleId;
	}

	public void setRoleTypesByRoleId(RoleTypesEntity roleTypesByRoleId) {
		this.roleTypesByRoleId = roleTypesByRoleId;
	}

	@ManyToOne
	@JoinColumn(name = "sex_type_code", referencedColumnName = "sex_type_code")
	public SexTypesEntity getSexTypesBySexTypeCode() {
		return sexTypesBySexTypeCode;
	}

	public void setSexTypesBySexTypeCode(SexTypesEntity sexTypesBySexTypeCode) {
		this.sexTypesBySexTypeCode = sexTypesBySexTypeCode;
	}
}
