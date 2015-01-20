package com.shinow.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.shinow.dao.CommonBaseDAO;
import com.shinow.entity.SexTypesEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2014/10/28.
 */
public class QuerySexAction extends ActionSupport {
	@Resource
	private CommonBaseDAO<SexTypesEntity> sextypes_dao;
	private List<SexTypesEntity> sexlist;

	public String sextype(){
		sexlist=sextypes_dao.listAll(SexTypesEntity.class);
		return SUCCESS;
	}

	public List<SexTypesEntity> getSexlist() {
		return sexlist;
	}

	public void setSexlist(List<SexTypesEntity> sexlist) {
		this.sexlist = sexlist;
	}
}
