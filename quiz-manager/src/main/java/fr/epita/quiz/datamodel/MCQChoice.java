package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MCQCHOICE")
public class MCQChoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MCQCHOICE_ID")
	private long id;
	
	@Column(name = "MCQCHOICE_CHOICE")
	private String choice;
	
	@Column(name = "MCQCHOICE_VALID")
	private String valid;
	
	@Column(name = "QUESTION_ID")
	private String q_id;

}

