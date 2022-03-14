package com.ecom.service.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "myecom_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "roleid_generator")
	@SequenceGenerator(name = "roleid_generator", initialValue = 1, allocationSize = 1, sequenceName = "roleid_seq")
	@Column(name = "id")
	private long id;

	@Column(name = "role")
	private String role;

	@Column(name = "created_at")
	private Date creaedAt = new Date();

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreaedAt() {
		return creaedAt;
	}

	public void setCreaedAt(Date creaedAt) {
		this.creaedAt = creaedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
