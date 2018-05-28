package local;

import javax.persistence.*;


@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@Column(name="Username")
	private String username;
	@Column(name="Password")
	private String password;
	
	public User(String username, String password) {
	this.username=username;
	this.password=password;
	}
	
	public User() {
		
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
	
	
	
}
