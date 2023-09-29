package com.application.demo.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.application.demo.quizapp.Question;
import com.application.demo.quizapp.dow.Questiondow;

@Service
public class questionservie {
	@Autowired
	 Questiondow questiondow;
	

	public ResponseEntity<List<Question>> getallQuestion() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(questiondow.findAll(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Question>>getbycategory(String category)
	{
		try {
		return new ResponseEntity<>( questiondow.findBycategory(category),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		questiondow.save(question);
		return new ResponseEntity<>("success",HttpStatus.CREATED);		
		
	}



	

}
