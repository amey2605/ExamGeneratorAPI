package com.example.demo.Model;

import lombok.Data;

public @Data class AnswerWithqid {
	private int qid;
	private String correctOption;
	private boolean isCorrect;
}
