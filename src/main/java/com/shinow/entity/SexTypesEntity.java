package com.shinow.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "sex_types", schema = "dbo", catalog = "bbs")
public class SexTypesEntity {
	private byte sexTypeCode;
	private String sexTypeName;
	private Collection<AdminInfoEntity> adminInfosBySexTypeCode;
	private Collection<UserinfoEntity> userinfosBySexTypeCode;

	@Id
	@Column(name = "sex_type_code")
	public byte getSexTypeCode() {
		return sexTypeCode;
	}

	public void setSexTypeCode(byte sexTypeCode) {
		this.sexTypeCode = sexTypeCode;
	}

	@Basic
	@Column(name = "sex_type_name")
	public String getSexTypeName() {
		return sexTypeName;
	}

	public void setSexTypeName(String sexTypeName) {
		this.sexTypeName = sexTypeName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SexTypesEntity that = (SexTypesEntity) o;

		if (sexTypeCode != that.sexTypeCode) return false;
		if (sexTypeName != null ? !sexTypeName.equals(that.sexTypeName) : that.sexTypeName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) sexTypeCode;
		result = 31 * result + (sexTypeName != null ? sexTypeName.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "sexTypesBySexTypeCode")
	public Collection<AdminInfoEntity> getAdminInfosBySexTypeCode() {
		return adminInfosBySexTypeCode;
	}

	public void setAdminInfosBySexTypeCode(Collection<AdminInfoEntity> adminInfosBySexTypeCode) {
		this.adminInfosBySexTypeCode = adminInfosBySexTypeCode;
	}

	@OneToMany(mappedBy = "sexTypesBySexTypeCode")
	public Collection<UserinfoEntity> getUserinfosBySexTypeCode() {
		return userinfosBySexTypeCode;
	}

	public void setUserinfosBySexTypeCode(Collection<UserinfoEntity> userinfosBySexTypeCode) {
		this.userinfosBySexTypeCode = userinfosBySexTypeCode;
	}
}
