package org.weichart.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * 用户点赞操作历史实体
 * @author liyi
 *
 */

@Entity
@Table(name = "ss_praise_history")
public class PraiseHistory extends IdEntity {
	
	private CircleRole circleRole;//角色
	private Account account;//账户
	private Topic topic;//说说
	private Integer operateType;//操作类型（1，点赞。2，取消点赞）
	private Date operateTime;//操作时间
	public CircleRole getCircleRole() {
		return circleRole;
	}
	public void setCircleRole(CircleRole circleRole) {
		this.circleRole = circleRole;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public Integer getOperateType() {
		return operateType;
	}
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

}
