package com.shinow.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "userinfo")
public class UserinfoEntity {
	private int userId;
	private String userName;
	private String userPass;
	private String passQuestion;
	private String passQuesAnsw;
	private Timestamp birthday;
	private String nickName;
	private String questEmailAddr;
	private String pic;
	private Collection<MessageEntity> messagesByUserId;
	private Collection<ReplyMsgEntity> replyMsgsByUserId;
	private RoleTypesEntity roleTypesByRoleId;
	private SexTypesEntity sexTypesBySexTypeCode;

	@Id
	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "user_name")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Basic
	@Column(name = "user_pass")
	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Basic
	@Column(name = "pass_question")
	public String getPassQuestion() {
		return passQuestion;
	}

	public void setPassQuestion(String passQuestion) {
		this.passQuestion = passQuestion;
	}

	@Basic
	@Column(name = "pass_ques_answ")
	public String getPassQuesAnsw() {
		return passQuesAnsw;
	}

	public void setPassQuesAnsw(String passQuesAnsw) {
		this.passQuesAnsw = passQuesAnsw;
	}

	@Basic
	@Column(name = "birthday")
	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	@Basic
	@Column(name = "nick_name")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Basic
	@Column(name = "quest_email_addr")
	public String getQuestEmailAddr() {
		return questEmailAddr;
	}

	public void setQuestEmailAddr(String questEmailAddr) {
		this.questEmailAddr = questEmailAddr;
	}

	@Basic
	@Column(name = "pic")
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserinfoEntity that = (UserinfoEntity) o;

		if (userId != that.userId) return false;
		if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
		if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
		if (passQuesAnsw != null ? !passQuesAnsw.equals(that.passQuesAnsw) : that.passQuesAnsw != null) return false;
		if (passQuestion != null ? !passQuestion.equals(that.passQuestion) : that.passQuestion != null) return false;
		if (pic != null ? !pic.equals(that.pic) : that.pic != null) return false;
		if (questEmailAddr != null ? !questEmailAddr.equals(that.questEmailAddr) : that.questEmailAddr != null)
			return false;
		if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
		if (userPass != null ? !userPass.equals(that.userPass) : that.userPass != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = userId;
		result = 31 * result + (userName != null ? userName.hashCode() : 0);
		result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
		result = 31 * result + (passQuestion != null ? passQuestion.hashCode() : 0);
		result = 31 * result + (passQuesAnsw != null ? passQuesAnsw.hashCode() : 0);
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
		result = 31 * result + (questEmailAddr != null ? questEmailAddr.hashCode() : 0);
		result = 31 * result + (pic != null ? pic.hashCode() : 0);
		return result;
	}

	@OneToMany(mappedBy = "userinfoByUserId")
	public Collection<MessageEntity> getMessagesByUserId() {
		return messagesByUserId;
	}

	public void setMessagesByUserId(Collection<MessageEntity> messagesByUserId) {
		this.messagesByUserId = messagesByUserId;
	}

	@OneToMany(mappedBy = "userinfoByUserId")
	public Collection<ReplyMsgEntity> getReplyMsgsByUserId() {
		return replyMsgsByUserId;
	}

	public void setReplyMsgsByUserId(Collection<ReplyMsgEntity> replyMsgsByUserId) {
		this.replyMsgsByUserId = replyMsgsByUserId;
	}

	@ManyToOne
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	public RoleTypesEntity getRoleTypesByRoleId() {
		return roleTypesByRoleId;
	}

	public void setRoleTypesByRoleId(RoleTypesEntity roleTypesByRoleId) {
		this.roleTypesByRoleId = roleTypesByRoleId;
	}

	@ManyToOne
	@JoinColumn(name = "sex_type_code", referencedColumnName = "sex_type_code")
	public SexTypesEntity getSexTypesBySexTypeCode() {
		return sexTypesBySexTypeCode;
	}

	public void setSexTypesBySexTypeCode(SexTypesEntity sexTypesBySexTypeCode) {
		this.sexTypesBySexTypeCode = sexTypesBySexTypeCode;
	}
}
