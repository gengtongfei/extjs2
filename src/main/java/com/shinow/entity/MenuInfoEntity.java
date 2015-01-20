package com.shinow.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "menu_info", schema = "dbo", catalog = "bbs")
public class MenuInfoEntity {
	private int menuId;
	private String menuName;
	private Collection<ChildmenuinfoEntity> childmenuinfosByMenuId;

	@Id
	@Column(name = "menu_id")
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Basic
	@Column(name = "menu_name")
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MenuInfoEntity that = (MenuInfoEntity) o;

		if (menuId != that.menuId) return false;
		if (menuName != null ? !menuName.equals(that.menuName) : that.menuName != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = menuId;
		result = 31 * result + (menuName != null ? menuName.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "menuInfoByMenuId")
	public Collection<ChildmenuinfoEntity> getChildmenuinfosByMenuId() {
		return childmenuinfosByMenuId;
	}

	public void setChildmenuinfosByMenuId(Collection<ChildmenuinfoEntity> childmenuinfosByMenuId) {
		this.childmenuinfosByMenuId = childmenuinfosByMenuId;
	}
}
