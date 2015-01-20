package com.shinow.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "message", schema = "dbo", catalog = "bbs")
public class MessageEntity {
	private int msgId;
	private Timestamp postTime;
	private String postContent;
	private UserinfoEntity userinfoByUserId;
	private Collection<ReplyMsgEntity> replyMsgsByMsgId;

	@Id
	@Column(name = "msg_id")
	public int getMsgId() {
		return msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	@Basic
	@Column(name = "post_time")
	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

	@Basic
	@Column(name = "post_content")
	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		MessageEntity that = (MessageEntity) o;

		if (msgId != that.msgId) return false;
		if (postContent != null ? !postContent.equals(that.postContent) : that.postContent != null) return false;
		if (postTime != null ? !postTime.equals(that.postTime) : that.postTime != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = msgId;
		result = 31 * result + (postTime != null ? postTime.hashCode() : 0);
		result = 31 * result + (postContent != null ? postContent.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	public UserinfoEntity getUserinfoByUserId() {
		return userinfoByUserId;
	}

	public void setUserinfoByUserId(UserinfoEntity userinfoByUserId) {
		this.userinfoByUserId = userinfoByUserId;
	}

	@OneToMany(mappedBy = "messageByMsgId")
	public Collection<ReplyMsgEntity> getReplyMsgsByMsgId() {
		return replyMsgsByMsgId;
	}

	public void setReplyMsgsByMsgId(Collection<ReplyMsgEntity> replyMsgsByMsgId) {
		this.replyMsgsByMsgId = replyMsgsByMsgId;
	}
}
