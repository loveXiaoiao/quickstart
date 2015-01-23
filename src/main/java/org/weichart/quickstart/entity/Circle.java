package org.weichart.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
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
	private Integer status;//状态(0启用，1停用)
	private String theme;//圈子主题
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	// JPA 基于account_id列的多对一关系定义
	@ManyToOne
	@JoinColumn(name = "account_id")
	public Account getCreateAccount() {
		return createAccount;
	}
	public void setCreateAccount(Account createAccount) {
		this.createAccount = createAccount;
	}
	
	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
	
}
