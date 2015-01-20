package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.AdminInfoEntity;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2014/10/29.
 */
public class UpdateAction extends ActionSupport {
	@Resource
	private CommonBaseDAO<AdminInfoEntity> admin_dao;
	private AdminInfoEntity adminInfo;
	private String message;
	private boolean success;
	private boolean stat;
	public String updateMsg(){

		if(true==admin_dao.update(adminInfo)){
			setMessage("更新成功！");
			setStat(true);
			setSuccess(true);
			return "ok";
		}else {
			setMessage("更新失败！");
			setSuccess(true);
			setStat(false);
			return "input";
		}

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isStat() {
		return stat;
	}

	public void setStat(boolean stat) {
		this.stat = stat;
	}

	public AdminInfoEntity getAdminInfo() {
		return adminInfo;
	}

	public void setAdminInfo(AdminInfoEntity adminInfo) {
		this.adminInfo = adminInfo;
	}
}
