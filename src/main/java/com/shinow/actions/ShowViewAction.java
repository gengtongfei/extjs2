package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.MenuInfoEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/10/26.
 */
public class ShowViewAction extends ActionSupport {


	private List<MenuInfoEntity> menulist;

	@Resource
	private CommonBaseDAO<MenuInfoEntity> menu_dao;
	public String showview(){
		menulist=menu_dao.listAll(MenuInfoEntity.class);
		return "ok";
	}

	public List<MenuInfoEntity> getMenulist() {
		return menulist;
	}

	public void setMenulist(List<MenuInfoEntity> menulist) {
		this.menulist = menulist;
	}
}
