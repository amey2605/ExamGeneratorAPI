package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ExamQ;
import com.example.demo.Model.FormData;
import com.example.demo.Model.Question;
import com.example.demo.service.ExamService;

@RestController
@RequestMapping("exam")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {

	@Autowired
	ExamService eservice;
	
	@GetMapping()
	public ResponseEntity<List<ExamQ>> getExam(){
		
		List<ExamQ> tempList = eservice.generateExam();
		
		return ResponseEntity.ok(tempList);
		
	}
	
	@GetMapping("/diff/{d}")
	public ResponseEntity<List<ExamQ>> getExamByDifficulty(@PathVariable String d){
		
		List<ExamQ> tempList = eservice.generateExamByDifficulty(d);
		
		return ResponseEntity.ok(tempList);
		
	}
	
	@GetMapping("/cat/{c}")
	public ResponseEntity<List<ExamQ>> getExamByCategory(@PathVariable String c){
		
		List<ExamQ> tempList = eservice.generateExamByCategory(c);
		
		return ResponseEntity.ok(tempList);
		
	}
	
	@GetMapping("/filter/{cat}/{diff}/{no}")
	public ResponseEntity<List<ExamQ>> getExamByFilters(@PathVariable String cat,@PathVariable String diff,
			@PathVariable int no){
		
		List<ExamQ> tempList = eservice.generateExamByAllFilters(cat, diff, no);
		
		
		
		return ResponseEntity.ok(tempList);
		
	}
	
	@PostMapping("/array")
	public ResponseEntity<List<ExamQ>> getExamByArrayData(@RequestBody FormData data){
		
		//System.out.println(data);
		
		List<ExamQ> tempList = eservice.generateExamByArrayData(data);
		
		
		
		return ResponseEntity.ok(tempList);
		
	}
	
	
}
