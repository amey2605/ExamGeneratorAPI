package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.ExamQ;
import com.example.demo.Model.FormData;
import com.example.demo.Model.Question;
import com.example.demo.repo.QuestionRepo;

@Service
public class ExamService {

	@Autowired
	QuestionRepo qrepo;
	
	public List<ExamQ> generateExam(){
		
		List<Question> allQ = qrepo.findAll();
		
		List<ExamQ> tempExam =new ArrayList<ExamQ>();
		
		for(Question q: allQ) {
			ExamQ texam =new ExamQ();
			texam.setId(q.getId());
			texam.setQtitle(q.getQtitle());
			texam.setOption1(q.getOption1());
			texam.setOption2(q.getOption2());
			texam.setOption3(q.getOption3());
			texam.setOption4(q.getOption4());
			
			tempExam.add(texam);
		}
		
		return tempExam;
	}
	
	public List<ExamQ> generateExamByDifficulty(String diff){
		
		List<Question> allQ = qrepo.findByDifficulty(diff);
		
		List<ExamQ> tempExam =new ArrayList<ExamQ>();
		
		for(Question q: allQ) {
			
		
				ExamQ texam =new ExamQ();
				texam.setId(q.getId());
				texam.setQtitle(q.getQtitle());
				texam.setOption1(q.getOption1());
				texam.setOption2(q.getOption2());
				texam.setOption3(q.getOption3());
				texam.setOption4(q.getOption4());
				
				tempExam.add(texam);
			
			
		}
		
		return tempExam;
	}
	
public List<ExamQ> generateExamByCategory(String cat){
		
		List<Question> allQ = qrepo.findByQcategory(cat);
		
		List<ExamQ> tempExam =new ArrayList<ExamQ>();
		
		for(Question q: allQ) {
			
				ExamQ texam =new ExamQ();
				texam.setId(q.getId());
				texam.setQtitle(q.getQtitle());
				texam.setOption1(q.getOption1());
				texam.setOption2(q.getOption2());
				texam.setOption3(q.getOption3());
				texam.setOption4(q.getOption4());
				
				tempExam.add(texam);
			
			
		}
		
		return tempExam;
	}
	
public List<ExamQ> generateExamByAllFilters(String cat,String diff,int no){
	
	if (cat != null && !cat.isEmpty()) {
        cat = cat.substring(0, 1).toUpperCase() + cat.substring(1);
    }
    if (diff != null && !diff.isEmpty()) {
        diff = diff.substring(0, 1).toUpperCase() + diff.substring(1);
    }
	
	List<Question> allQ = qrepo.findAll();
	
	List<ExamQ> tempExam =new ArrayList<ExamQ>();
	
	
	
	for(Question q: allQ) {
		
		
		if(q.getQcategory().equals(cat) && q.getDifficulty().equals(diff) ) {
			ExamQ texam =new ExamQ();
			texam.setId(q.getId());
			texam.setQtitle(q.getQtitle());
			texam.setOption1(q.getOption1());
			texam.setOption2(q.getOption2());
			texam.setOption3(q.getOption3());
			texam.setOption4(q.getOption4());
			texam.setDiff(q.getDifficulty());
			tempExam.add(texam);
		
		}
		
		
			
		
	}
	
	if(tempExam.size()>no) tempExam=tempExam.subList(0, no);
	
	return tempExam;
}


public List<ExamQ> generateExamByArrayData(FormData data){
	List<ExamQ> ans=new ArrayList<>();
	
	//System.out.println(data);
	
	List<Question> allQ = qrepo.findAll();
	
	for(Question q:allQ) {
		
		boolean isSatisfying=false;
		
		for(String s:data.getCategory()) {
			if(q.getQcategory().equals(s)) {
				
				
				
				
				ExamQ texam =new ExamQ();
				texam.setId(q.getId());
				texam.setQtitle(q.getQtitle());
				texam.setOption1(q.getOption1());
				texam.setOption2(q.getOption2());
				texam.setOption3(q.getOption3());
				texam.setOption4(q.getOption4());
				texam.setDiff(q.getDifficulty());
				
				ans.add(texam);
			}
		}
		
		
	}
	
	for(ExamQ q:ans) {
		boolean isMatching=true;
		
		for(String s:data.getDifficulty()) {
			if(q.getDiff().equals(s)) isMatching=false;
		}
		if(!isMatching) ans.remove(q);
	}
	
	Collections.shuffle(ans);
	
	List<ExamQ> FinalAns = ans.subList(0, Math.min(data.getNo(), ans.size()));
	
	return FinalAns;
}




	
}
