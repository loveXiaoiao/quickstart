package org.weichart.quickstart.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 提示消息实体
 * @author liyi
 *
 */

@Entity
@Table(name = "ss_notice")
public class Notice extends IdEntity {
	
	private Integer noticeType;//消息类型
	private Integer status;//消息状态
	private Account account;//所属账户
	private Topic topic;//说说消息
	private Circle circle;//圈子关注消息
	private String content;//消息内容
	
	@ManyToOne
	@JoinColumn(name = "circle_id")
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getNoticeType() {
		return noticeType;
	}
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	@JoinColumn(name = "topic_id")
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

}
