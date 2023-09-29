package com.application.demo.quizapp.quizservice.quizdow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.demo.quizapp.quizservice.quizmodel.Quiz;
@Repository
public interface QuizDow extends JpaRepository<Quiz, Integer> {

}
