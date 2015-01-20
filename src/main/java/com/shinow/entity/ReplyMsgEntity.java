package com.shinow.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2014/10/26.
 */
@Entity
@Table(name = "reply_msg", schema = "dbo", catalog = "bbs")
public class ReplyMsgEntity {
	private int replyMsgId;
	private Timestamp replyTime;
	private String replyContent;
	private MessageEntity messageByMsgId;
	private UserinfoEntity userinfoByUserId;

	@Id
	@Column(name = "reply_msg_id")
	public int getReplyMsgId() {
		return replyMsgId;
	}

	public void setReplyMsgId(int replyMsgId) {
		this.replyMsgId = replyMsgId;
	}

	@Basic
	@Column(name = "reply_time")
	public Timestamp getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	@Basic
	@Column(name = "reply_content")
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ReplyMsgEntity that = (ReplyMsgEntity) o;

		if (replyMsgId != that.replyMsgId) return false;
		if (replyContent != null ? !replyContent.equals(that.replyContent) : that.replyContent != null) return false;
		if (replyTime != null ? !replyTime.equals(that.replyTime) : that.replyTime != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = replyMsgId;
		result = 31 * result + (replyTime != null ? replyTime.hashCode() : 0);
		result = 31 * result + (replyContent != null ? replyContent.hashCode() : 0);
		return result;
	}

	@ManyToOne
	@JoinColumn(name = "msg_id", referencedColumnName = "msg_id")
	public MessageEntity getMessageByMsgId() {
		return messageByMsgId;
	}

	public void setMessageByMsgId(MessageEntity messageByMsgId) {
		this.messageByMsgId = messageByMsgId;
	}

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	public UserinfoEntity getUserinfoByUserId() {
		return userinfoByUserId;
	}

	public void setUserinfoByUserId(UserinfoEntity userinfoByUserId) {
		this.userinfoByUserId = userinfoByUserId;
	}
}
