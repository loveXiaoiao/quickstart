package org.weichart.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 圈子
 * @author liyi
 *
 */
@Entity
@Table(name = "ss_circle")
public class Circle extends IdEntity {
	
	private String name;//圈子名称
	private Account createAccount;//创建人
	private Date createTime;//创建时间
	private String status;//状态
	private String theme;//圈子主题
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	public Account getCreateAccount() {
		return createAccount;
	}
	public void setCreateAccount(Account createAccount) {
		this.createAccount = createAccount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
	
}
