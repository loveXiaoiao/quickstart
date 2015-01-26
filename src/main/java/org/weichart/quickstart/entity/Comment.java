package org.weichart.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 说说评论
 * @author liyi
 *
 */
@Entity
@Table(name = "ss_comment")
public class Comment extends IdEntity {
	
	private String content;//评论内容
	private Date createTime;//发表时间
	private Topic topic;//所在说说
	private Account account;//评论人
	private CircleRole circleRole;//角色
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@ManyToOne
	@JoinColumn(name = "topic_id")
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	@ManyToOne
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@ManyToOne
	@JoinColumn(name = "circle_role_id")
	public CircleRole getCircleRole() {
		return circleRole;
	}
	public void setCircleRole(CircleRole circleRole) {
		this.circleRole = circleRole;
	}
	
}
