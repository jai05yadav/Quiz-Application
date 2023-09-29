package com.application.demo.quizapp.quizSerivce;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.demo.quizapp.Question;
import com.application.demo.quizapp.QuestionWrapper;
import com.application.demo.quizapp.dow.Questiondow;
import com.application.demo.quizapp.quizcontroller.Response;
import com.application.demo.quizapp.quizservice.quizdow.QuizDow;
import com.application.demo.quizapp.quizservice.quizmodel.Quiz;
@Service
public class quizSerivce {
	@Autowired
     QuizDow quizdow;
	@Autowired
	Questiondow questiondow;

	public ResponseEntity<String> created(String category, int q, String title) {
		List<Question>question=questiondow.findRandomQuestionByCategory(category,q);
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestion(question);
		quizdow.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getquizQuestion(Integer id) {
		// TODO Auto-generated method stub
		java.util.Optional<Quiz> quiz=quizdow.findById(id);
		List<Question>questionfromdb =quiz.get().getQuestion();
		List<QuestionWrapper>questionforUser = new ArrayList<>();
		for(Question q:questionfromdb)
		{
			QuestionWrapper qr = new QuestionWrapper(q.getId(),q.getQuestion_title(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionforUser.add(qr);
		}
		
		return new ResponseEntity<>(questionforUser,HttpStatus.OK);
	}

	public static ResponseEntity<Integer> calculateresult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		List<Question>questions = quiz.getQuestion();
		int correct=0;
		int i=0;
		for(Response response : responses)
		{
			if(response.getResponse().equals(questions.get(i).getCorrect_answer()))
			{
				correct++;
			}
			i++;
		}
		return new ResponseEntity<>(correct,HttpStatus.OK);
	}
	

}
