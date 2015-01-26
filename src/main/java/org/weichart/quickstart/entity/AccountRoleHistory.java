package org.weichart.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 用户角色管理历史实体
 * @author liyi
 *
 */

@Entity
@Table(name = "ss_account_role_history")
public class AccountRoleHistory extends IdEntity {
	
	private Account account;
	private CircleRole circleRole;
	private Date OperateTime;
	private Integer OperateType;
	
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
	public Date getOperateTime() {
		return OperateTime;
	}
	public void setOperateTime(Date operateTime) {
		OperateTime = operateTime;
	}
	public Integer getOperateType() {
		return OperateType;
	}
	public void setOperateType(Integer operateType) {
		OperateType = operateType;
	}
	
	

}
