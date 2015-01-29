package org.weichart.quickstart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 说说实体
 * @author liyi
 *
 */
@Entity
@Table(name = "ss_topic")
public class Topic extends IdEntity {
	
	private String content;//发表内容
	private String images;//评论图片
	private Date createTime;//发表时间
	private Account account;//发表账号
	private Circle circle;//所属圈子
	private CircleRole circleRole;//发表角色
	private List<CircleRole> praiseRoles;//点赞角色
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
	@JoinColumn(name = "circle_id")
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	
	@ManyToOne
	@JoinColumn(name = "circle_role_id")
	public CircleRole getCircleRole() {
		return circleRole;
	}
	public void setCircleRole(CircleRole circleRole) {
		this.circleRole = circleRole;
	}
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@ManyToMany
	@JoinTable(name = "ss_praise_roles", joinColumns = { @JoinColumn(name = "topic_id") }, inverseJoinColumns = { @JoinColumn(name = "circle_role_id") })
	@OrderBy("id")
	public List<CircleRole> getPraiseRoles() {
		return praiseRoles;
	}
	public void setPraiseRoles(List<CircleRole> praiseRoles) {
		this.praiseRoles = praiseRoles;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	

}
