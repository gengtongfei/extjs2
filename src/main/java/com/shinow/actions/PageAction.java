package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.AdminInfoEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/10/23.
 */
public class PageAction extends ActionSupport {
	@Resource
	private CommonBaseDAO<AdminInfoEntity> admin_dao;
	private List<AdminInfoEntity> adminlist;
	public String test1(){
		adminlist=admin_dao.listAll(AdminInfoEntity.class);
		return "ok";

	}


	public List<AdminInfoEntity> getAdminlist() {
		return adminlist;
	}

	public void setAdminlist(List<AdminInfoEntity> adminlist) {
		this.adminlist = adminlist;
	}
}
