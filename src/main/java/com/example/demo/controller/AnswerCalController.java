package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Answer;
import com.example.demo.Model.AnswerWithqid;
import com.example.demo.Model.FormData;
import com.example.demo.Model.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/answers")
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerCalController {

	
	@Autowired
	QuestionService qservice;
	
	@PostMapping("/score")
	public  ResponseEntity<Integer> calculateMyScore(@RequestBody List<Answer> answers){
		
		int score=0;
		
		  for(Answer a :answers) {
			  Optional<Question> q= qservice.findById(a.getQid());
			  if( q.get().getQanswer().equals(a.getAnswer() )) score++ ;
		  }
		
		  return ResponseEntity.ok(score);
	}
	
	@PostMapping("/correct")
	public  ResponseEntity<List<AnswerWithqid>> getCorrectAnswers(@RequestBody List<Answer> answers){
		
		List<AnswerWithqid> list=new ArrayList<>();
		
			
		for(Answer a:answers) {
			Optional<Question> q= qservice.findById(a.getQid());
			
			AnswerWithqid temp=new AnswerWithqid();
			
			if(q.get().getQanswer().equals(a.getAnswer())) {
				temp.setCorrect(true);
				
			}
			else temp.setCorrect(false);
			temp.setQid(a.getQid());
			temp.setCorrectOption(q.get().getQanswer());
			
			list.add(temp);
		}
		
		  return ResponseEntity.ok(list);
	}
}
