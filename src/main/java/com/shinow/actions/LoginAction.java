package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.UserinfoEntity;
import org.apache.log4j.Logger;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by Administrator on 2014/10/26.
 */
public class LoginAction extends ActionSupport {

	private UserinfoEntity user;
	private boolean isno;
	private boolean success;
	private String message;
	private List<UserinfoEntity> userlist;
	@Resource
	private CommonBaseDAO<UserinfoEntity> user_dao;
	private Logger logger= Logger.getLogger(getClass());
	public String logintest(){
		setSuccess(false);
		try{
		userlist=user_dao.findByExample(UserinfoEntity.class, getUser());
			if(userlist.size()>0){
				setSuccess(true);
				setIsno(true);
				setMessage("登陆成功");
			}else {
				setIsno(false);
				setSuccess(true);
				setMessage("用户名或密码错误！");
			}

		}catch (Exception e){
			logger.error(e.getMessage(),e);

		}
		return "ok";
	}


	public UserinfoEntity getUser() {
		return user;
	}

	public void setUser(UserinfoEntity user) {
		this.user = user;
	}

	public boolean isIsno() {
		return isno;
	}

	public void setIsno(boolean isno) {
		this.isno = isno;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
