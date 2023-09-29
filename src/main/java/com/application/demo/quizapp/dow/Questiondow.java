package com.application.demo.quizapp.dow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.demo.quizapp.Question;

@Repository
public interface Questiondow extends JpaRepository<Question, Integer>{
		List<Question>findBycategory(String category);
		@Query(value="SELECT * FROM  question ql Where ql.category=:category ORDER BY RANDOM() LIMIT :q",nativeQuery = true)
		List<Question> findRandomQuestionByCategory(String category, int q);
}
