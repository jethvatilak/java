package fr.epita.quiz.datamodel;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Named(value = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long u_id;
	
	@Column(unique = true)
	private String u_name;
	
	@Named(value = "U_PWD")
	private String u_pwd;

	public long getU_id() {
		return u_id;
	}

	public void setU_id(long u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_pwd() {
		return u_pwd;
	}

	public void setU_pwd(String u_pwd) {
		this.u_pwd = u_pwd;
	}
	
}
