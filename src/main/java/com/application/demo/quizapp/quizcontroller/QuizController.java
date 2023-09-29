package com.application.demo.quizapp.quizcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.quizapp.Question;
import com.application.demo.quizapp.QuestionWrapper;
import com.application.demo.quizapp.quizSerivce.quizSerivce;




@RestController
@RequestMapping(path="quiz")
public class QuizController {
	@Autowired
	quizSerivce quizservice;
	@PostMapping(path="create")
	public ResponseEntity<String>createquiz(@RequestParam String category,@RequestParam int q,@RequestParam String title){
		return quizservice.created(category,q,title);
	}
	@GetMapping(path = "get/{id}")
	public ResponseEntity<List<QuestionWrapper>>getQuizQuestion(@PathVariable Integer id)
	
	{
		return quizservice.getquizQuestion(id);
		
		
	}
	@PostMapping(path="submit/{id}")
	public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
		return quizSerivce.calculateresult(id , responses);
			
		}
	

}
