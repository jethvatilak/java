package fr.epita.quiz.datamodel;

import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Named(value = "MCQCHOICE")
public class MCQChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mc_id;
	
	private int q_id;
	
	private String mc_choice;
	
	private int mc_valid;

	public int getMc_id() {
		return mc_id;
	}

	public void setMc_id(int mc_id) {
		this.mc_id = mc_id;
	}

	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getMc_choice() {
		return mc_choice;
	}

	public void setMc_choice(String mc_choice) {
		this.mc_choice = mc_choice;
	}

	public int getMc_valid() {
		return mc_valid;
	}

	public void setMc_valid(int mc_valid) {
		this.mc_valid = mc_valid;
	}
	
}
