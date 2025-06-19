package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.FormData;
import com.example.demo.Model.Question;
import com.example.demo.repo.QuestionRepo;

@Service
public class QuestionService {
	
	@Autowired
	QuestionRepo qrepo;

	
	public Question addQuestion(Question q) {
		Question tempQ=qrepo.save(q);
		return tempQ;
	}
	
	public List<Question> getAllQuestions(){
		return qrepo.findAll();
		
	}
	
	
	
	public Optional<Question> findById(int id) {
		return qrepo.findById(id);
	}
	
	public List<Question>  findByQcategory(String cat){
		return qrepo.findByQcategory(cat);
	}
	
	public List<Question> findByDifficulty(String diff){
		return qrepo.findByDifficulty(diff);
	}
	
	public void deleteQById(int id) {
		qrepo.deleteById(id);
	}
}
