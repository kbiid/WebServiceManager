package kr.co.torpedo.webservicemanager.domain;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String ip_address;
	private Date date;

	public User(int id, String firstName, String lastName, String email, String gender, String ipAddress, Date date) {
		this.id = id;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.gender = gender;
		this.ip_address = ipAddress;
		this.date = date;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIpAddress() {
		return ip_address;
	}

	public void setIpAddress(String ipAddress) {
		this.ip_address = ipAddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
