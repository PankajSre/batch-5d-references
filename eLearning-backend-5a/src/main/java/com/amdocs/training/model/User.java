package com.amdocs.training.model;

import java.beans.Transient;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class User implements Serializable{
	private Long id;
	private String username;
	private String password;
	private String email;
	private String address;
	private transient MultipartFile image;

	public User() {
		super();
	}

	public User(Long id, String username, String password, String email, String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + "]";
	}
}
