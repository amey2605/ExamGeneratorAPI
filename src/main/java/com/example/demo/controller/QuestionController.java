package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.FormData;
import com.example.demo.Model.Question;
import com.example.demo.service.QuestionService;

@RestController
@RequestMapping("/questions")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

	@Autowired
	QuestionService service ;
	
	@PostMapping()
	public ResponseEntity<Question> addQuestion(@RequestBody Question q){
	
		Question tempTrade=service.addQuestion(q);
		
		return  ResponseEntity.ok(tempTrade);
	} 
	
	
	
	@GetMapping()
	public ResponseEntity<List<Question>> getALlQuestions(){
		
		List<Question> tempList = service.getAllQuestions();
		
		return ResponseEntity.ok(tempList);
		
	}
 	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Question> getTradeById(@PathVariable int id){
	    return service.findById(id)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/diff/{d}")
	public ResponseEntity<List<Question>> getQByDifficulty(@PathVariable String d){
		
		List<Question> tempList = service.findByDifficulty(d);
		
		return ResponseEntity.ok(tempList);
		
	}
	@GetMapping("/topic/{t}")
	public ResponseEntity<List<Question>> getQByTopic(@PathVariable String t){
		
		List<Question> tempList = service.findByQcategory(t);
		
		return ResponseEntity.ok(tempList);
		
	}
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQById(@PathVariable int id){
        service.deleteQById(id);
        return ResponseEntity.ok().build();
    }
	
	
}
