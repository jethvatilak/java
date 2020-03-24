package fr.epita.quiz.services.business;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.AnswerDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.services.UserDAO;

public class ExamDataService {
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	AnswerDAO answerDAO;
	
	@Transactional(value = TxType.REQUIRED)
	public void answerToQuestion(User user, Question question, Answer answer) {
		//check values
		//if not valid : throw exception?
		
		//main logic part
		//checks if the question exists in db, same for user
		//	first : check if there's an id
		//  call dao.getById(obj) to check if it there
		
		//otherwise : throw exception?
		
		//Assing user and questions to the answer
		answer.setUser(user);
		answer.setQuestion(question);
		
		answerDAO.create(answer);
	}
	
	//public answerToMCQ(User user, MCQQuestion mcq, List<MCQChoices> choices);

}
