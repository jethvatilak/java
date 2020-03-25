package fr.epita.quiz.datamodel;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWERS")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ANS_ID")
	private long id;
	
	@Column(name="ANS_CONTENT")
	private String content;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ANS_QUE_FK")
	private Question question;
	
//	@ManyToOne
//	@JoinColumn(name = "ANS_EXA_FK")
//	private Exam exam;
	
//	@ManyToOne
//	@Column(name = "STUDENT")
//	private Student student;
	
	@ManyToOne
	@JoinColumn(name="A_USER_FK")
	private User user;
	
	public Answer() {}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

//	public String getExam_id() {
//		return exam_id;
//	}
//
//	public void setExam_id(String exam_id) {
//		this.exam_id = exam_id;
//	}

//	public String getStudent_id() {
//		return student_id;
//	}
//
//	public void setStudent_id(String student_id) {
//		this.student_id = student_id;
//	}
}
