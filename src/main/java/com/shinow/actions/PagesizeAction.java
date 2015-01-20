package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.AdminInfoEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/10/23.
 */
public class PagesizeAction extends ActionSupport {
	@Resource
	private CommonBaseDAO<AdminInfoEntity> admin_dao;
	private List<AdminInfoEntity> adminlist;
	private int page;
	private int limit;
	private int count;
	private String admin;
	private String stuno;
	private String sexname;
	 public String test2(){
		 if((admin!=null&&admin.trim().length()>0)||(stuno!=null&&stuno.trim().length()>0)||(sexname!=null&&sexname.trim().length()>0)) {
			 adminlist = admin_dao.queryForPage("from AdminInfoEntity where adminName like \'%"+admin+"%\' and adminId like \'%"+stuno+"%\' and sexTypesBySexTypeCode like \'%"+sexname+"%\'",page,limit);
			 count = admin_dao.queryRecordCount("select COUNT(*) FROM AdminInfoEntity  WHERE adminName LIKE \'%"+admin+"%\' and adminId like \'%"+stuno+"%\' and sexTypesBySexTypeCode like\'%"+sexname+"%\'");
		 } else{
			 count = admin_dao.listAll(AdminInfoEntity.class).size();
			 adminlist = admin_dao.queryForPage("from AdminInfoEntity", getPage(), getLimit());
		 }
		 return "ok";
	 }

	public String getSexname() {
		return sexname;
	}

	public void setSexname(String sexname) {
		this.sexname = sexname;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public List<AdminInfoEntity> getAdminlist() {
		return adminlist;
	}

	public void setAdminlist(List<AdminInfoEntity> adminlist) {
		this.adminlist = adminlist;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
