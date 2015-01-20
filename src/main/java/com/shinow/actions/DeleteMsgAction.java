package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.AdminInfoEntity;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2014/10/28.
 */
public class DeleteMsgAction extends ActionSupport {
	@Resource
	private CommonBaseDAO<AdminInfoEntity> admin1_dao;
	private AdminInfoEntity admin2;

	private boolean success;
	public String delmsg(){
		if(true==admin1_dao.delete(admin1_dao.findById(AdminInfoEntity.class,admin2.getAdminId()))){
			setSuccess(true);
			return SUCCESS;
		}else {
			setSuccess(true);
			return SUCCESS;
		}

	}

	public AdminInfoEntity getAdmin2() {
		return admin2;
	}

	public void setAdmin2(AdminInfoEntity admin2) {
		this.admin2 = admin2;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
