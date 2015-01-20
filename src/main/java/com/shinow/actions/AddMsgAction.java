package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.AdminInfoEntity;
import com.shinow.entity.SexTypesEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/10/24.
 */
public class AddMsgAction extends ActionSupport{
	@Resource
	private CommonBaseDAO<AdminInfoEntity> admin_dao;
	private AdminInfoEntity admin1;
	private List<AdminInfoEntity> adminlist;


	private String message;
	private boolean success;
	private boolean ss;



	public String savetest(){
		adminlist=admin_dao.findByExample(AdminInfoEntity.class,admin1);

		if(adminlist.size()>0){

			setSuccess(true);
			setSs(false);
					setMessage("插入失败！");
					return "ok";
				}
		else{
			admin_dao.insert(admin1);
			setSuccess(true);
			setSs(false);
			setMessage("插入成功！");
			return "ok";
				}


	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AdminInfoEntity getAdmin1() {
		return admin1;
	}

	public void setAdmin1(AdminInfoEntity admin1) {
		this.admin1 = admin1;
	}
	public boolean isSs() {
		return ss;
	}

	public void setSs(boolean ss) {
		this.ss = ss;
	}
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
