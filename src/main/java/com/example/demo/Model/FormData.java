package com.example.demo.Model;

import java.util.Arrays;

public class FormData {
		private String[] category;
		private String[] difficulty;
		private int no;
		public String[] getCategory() {
			return category;
		}
		public void setCategory(String[] category) {
			this.category = category;
		}
		public String[] getDifficulty() {
			return difficulty;
		}
		public void setDifficulty(String[] difficulty) {
			this.difficulty = difficulty;
		}
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public FormData(String[] category, String[] difficulty, int no) {
			super();
			this.category = category;
			this.difficulty = difficulty;
			this.no = no;
		}
		public FormData() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "FormData [category=" + Arrays.toString(category) + ", difficulty=" + Arrays.toString(difficulty)
					+ ", no=" + no + "]";
		}
		
		
}
