package com.application.demo.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.demo.quizapp.Question;
import com.application.demo.quizapp.service.questionservie;

@RestController
@RequestMapping(path = "question")
public class QuestionController {
	@Autowired
	questionservie service;
	
	
	@GetMapping(path="allquestion")
	public ResponseEntity<List<Question>> allquestion()
	{
		return service.getallQuestion();
	}
	@GetMapping(path="find/{category}")
	public ResponseEntity<List<Question>> allquestion(@PathVariable String category)
	{
		return service.getbycategory(category);
	}
	@PostMapping(path="add")
	public  ResponseEntity<String> addQuestion(@RequestBody Question question)
	{
		return service.addQuestion(question);
		
	}

}
