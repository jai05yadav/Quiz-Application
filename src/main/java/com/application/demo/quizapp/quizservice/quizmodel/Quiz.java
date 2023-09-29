package com.application.demo.quizapp.quizservice.quizmodel;

import java.util.List;

import com.application.demo.quizapp.Question;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity

public class Quiz {
		
		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY)
		private Integer id;
		private String title;
		@ManyToMany
		private List<Question>question;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public List<Question> getQuestion() {
			return question;
		}
		public void setQuestion(List<Question> question) {
			this.question = question;
		}
		
		
		 
}
