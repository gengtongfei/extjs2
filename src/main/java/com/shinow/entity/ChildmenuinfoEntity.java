package com.shinow.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "childmenuinfo", schema = "dbo", catalog = "bbs")
public class ChildmenuinfoEntity {
	private int childId;
	private String childName;
	private String childPic;
	private MenuInfoEntity menuInfoByMenuId;

	@Id
	@Column(name = "child_id")
	public int getChildId() {
		return childId;
	}

	public void setChildId(int childId) {
		this.childId = childId;
	}

	@Basic
	@Column(name = "child_name")
	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	@Basic
	@Column(name = "child_pic")
	public String getChildPic() {
		return childPic;
	}

	public void setChildPic(String childPic) {
		this.childPic = childPic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ChildmenuinfoEntity that = (ChildmenuinfoEntity) o;

		if (childId != that.childId) return false;
		if (childName != null ? !childName.equals(that.childName) : that.childName != null) return false;
		if (childPic != null ? !childPic.equals(that.childPic) : that.childPic != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = childId;
		result = 31 * result + (childName != null ? childName.hashCode() : 0);
		result = 31 * result + (childPic != null ? childPic.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
	public MenuInfoEntity getMenuInfoByMenuId() {
		return menuInfoByMenuId;
	}

	public void setMenuInfoByMenuId(MenuInfoEntity menuInfoByMenuId) {
		this.menuInfoByMenuId = menuInfoByMenuId;
	}
}
