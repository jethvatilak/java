package fr.epita.quiz.services.business;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.ClassNullValueException;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.AnswerDAO;
import fr.epita.quiz.services.GenericDAO;
import fr.epita.quiz.services.QuestionDAO;
import fr.epita.quiz.services.UserDAO;

public class ExamDataService {
	
	private static final Logger LOGGER = LogManager.getLogger(ExamDataService.class);
	
	@Inject
	UserDAO userDAO;
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	AnswerDAO answerDAO;
	
	@Transactional(value = TxType.REQUIRED)
	public void answerToQuestion(User user, Question question, Answer answer) {
		
		try {
			userDAO.isNull(user); //check user is null or not
			questionDAO.isNull(question); //check question is null or not
			answerDAO.isNull(answer); //check answer is null or not
			
//			userDAO.isUserTableExist(); //check the user table is created or not
//			userDAO.isUserExist(user); //check the user exist or not
//			
//			questionDAO.isQuestionTableExist(); //check the question table is created or not
//			questionDAO.isQuestionExist(question); //check the question exist or not
//			
//			answerDAO.isAnswerTableExist(); //check the answer table is created or not
//			answerDAO.isAnswerExist(answer); //check the answer exist or not
		} catch (ClassNullValueException ex) {
			LOGGER.info(ex);
		}	
		
//		GenericDAO dao = new GenericDAO(UserDAO.class, user.getLoginName();
		
		//main logic part
				
		//	first : check if there's an id
		//  call dao.getById(obj) to check if it there
		
		//Assigning user and questions to the answer
		answer.setUser(user);
		answer.setQuestion(question);
		
		answerDAO.create(answer);
	}
	
	//public answerToMCQ(User user, MCQQuestion mcq, List<MCQChoices> choices);

}
