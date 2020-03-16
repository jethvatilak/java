package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MCQANSWER")
public class MCQAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MCQANSWER_ID")
	private long id;
	
	@Column(name = "MCQCHOICE_ID")
	private String mcqchoice_id;
	
	@Column(name = "EXAM_ID")
	private String exam_id;
	
	@Column(name = "STUDENT_ID")
	private String student_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMcqchoice_id() {
		return mcqchoice_id;
	}

	public void setMcqchoice_id(String mcqchoice_id) {
		this.mcqchoice_id = mcqchoice_id;
	}

	public String getExam_id() {
		return exam_id;
	}

	public void setExam_id(String exam_id) {
		this.exam_id = exam_id;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
}
