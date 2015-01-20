package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.AdminInfoEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/10/29.
 */
public class QueryMsgAction extends ActionSupport {
	@Resource
	private CommonBaseDAO<AdminInfoEntity>  admin_dao;

	private int page;

	private int limit;

	private int sumcount;

	private String sel;

	private List<AdminInfoEntity> admin_list;

	public String queryMsg(){
		admin_list=admin_dao.queryForPage("FROM AdminInfoEntity where adminName like \'%"+sel+"%\'",page,limit);

		return "ok";
	}

	public List<AdminInfoEntity> getAdmin_list() {
		return admin_list;
	}

	public void setAdmin_list(List<AdminInfoEntity> admin_list) {
		this.admin_list = admin_list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getSumcount() {
		return sumcount;
	}

	public void setSumcount(int sumcount) {
		this.sumcount = sumcount;
	}

	public String getSel() {
		return sel;
	}

	public void setSel(String sel) {
		this.sel = sel;
	}
}
