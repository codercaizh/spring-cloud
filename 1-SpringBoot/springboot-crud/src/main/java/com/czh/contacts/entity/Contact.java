package com.czh.contacts.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author caizh
 *
 * 通讯录表对应的实体类
 */
@Entity
@Table(name="contacts")
public class Contact {
	
	/**
	 * 主键
	 */
	//表明该字段对应数据库的主键字段
	@Id
	//表明该字段为自增长字段
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * 姓名 
	 */
	//表明该属性对应数据库表中的列名
	@Column(name = "name")
	@NotBlank(message="姓名不能为空")
	private String name;
	
	/**
	 * 生日 
	 */
	@Column(name = "birthday")
	//此注解是规定了当入参时间字符串的格式
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//此注解是规定了返回的时间字符串的格式，注意必须要加这个时区，否则会出现序列化后的日期少一天问题
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date birthday;
	
	/**
	 * 联系电话
	 */
	@NotBlank(message="联系电话不能为空")
	@Column(name = "phone")
	private String phone;
	
	/**
	 * 微信号 
	 */
	@NotBlank(message="微信号不能为空")
	@Column(name = "wechat")
	private String wechat;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", birthday=" + birthday + ", phone=" + phone + ", wechat="
				+ wechat + "]";
	}

	
}
