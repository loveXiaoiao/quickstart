package org.weichart.quickstart.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 帐号实体
 * @author liyi
 *
 */

@Entity
@Table(name = "ss_account")
public class Account extends IdEntity {
	
	private String accountName;//微信号
	private String password;//密码
	private String avatar;//头像
	private String nickName;//昵称
	private String maxCard;//二维码
	private Integer gender;//性别
	private String area;//地区
	private Date createTime;//创建时间
	private String personSignature;//个性签名
	private String flag;//功能字段，用来判断关注
	
	
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@NotBlank
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	// 设定JSON序列化时的日期格式
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMaxCard() {
		return maxCard;
	}
	public void setMaxCard(String maxCard) {
		this.maxCard = maxCard;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPersonSignature() {
		return personSignature;
	}
	public void setPersonSignature(String personSignature) {
		this.personSignature = personSignature;
	}
	
	
	

}
