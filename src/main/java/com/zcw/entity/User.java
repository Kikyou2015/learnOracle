package com.zcw.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_T")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8656940771942534240L;

	@Id
	@Column(name = "UT_ID")
	private Long utId;

	// @Column(name = "UT_NAME")
	private String utName;

	@Column(name = "UT_EMAIL")
	private String utEmail;

	@Column(name = "UT_ADDR")
	private String utAddr;

	@Column(name = "UT_GENDER")
	private short utGender;

	@Column(name = "UT_ORGID")
	private String utOrgid;

	public User() {
	}

	public User(Long utId, String utName, String utEmail, String utAddr, short utGender, String utOrgid) {
		super();
		this.utId = utId;
		this.utName = utName;
		this.utEmail = utEmail;
		this.utAddr = utAddr;
		this.utGender = utGender;
		this.utOrgid = utOrgid;
	}

	public Long getUtId() {
		return utId;
	}

	public void setUtId(Long utId) {
		this.utId = utId;
	}

	public String getUtName() {
		return utName;
	}

	public void setUtName(String utName) {
		this.utName = utName;
	}

	public String getUtEmail() {
		return utEmail;
	}

	public void setUtEmail(String utEmail) {
		this.utEmail = utEmail;
	}

	public String getUtAddr() {
		return utAddr;
	}

	public void setUtAddr(String utAddr) {
		this.utAddr = utAddr;
	}

	public short getUtGender() {
		return utGender;
	}

	public void setUtGender(short utGender) {
		this.utGender = utGender;
	}

	public String getUtOrgid() {
		return utOrgid;
	}

	public void setUtOrgid(String utOrgid) {
		this.utOrgid = utOrgid;
	}

	@Override
	public String toString() {
		return "User [utId=" + utId + ", utName=" + utName + ", utEmail=" + utEmail + ", utAddr=" + utAddr
				+ ", utGender=" + utGender + ", utOrgid=" + utOrgid + "]";
	}

}
