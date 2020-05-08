package fr.epita.quiz.datamodel;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Named(value = "QUESTION")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long q_id;
	
	@Column(name="Q_TITLE")  
	private String q_title;
	
	@ManyToOne
	@JoinColumn(name="A_EXAM_FK")
	private Exam exam;

	public Long getQ_id() {
		return q_id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public void setQ_id(Long q_id) {
		this.q_id = q_id;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

}
