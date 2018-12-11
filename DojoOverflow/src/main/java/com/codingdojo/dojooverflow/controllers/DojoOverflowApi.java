package com.codingdojo.dojooverflow.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.services.QuestionService;

@RestController
	public class DojoOverflowApi {
		private final QuestionService questionService;
		
		public DojoOverflowApi(QuestionService questionService) {
			this.questionService = questionService;
		}
		@RequestMapping("/api/overflow")
		public List<Question> index(){
			return questionService.allQuestions();
		}
	    @RequestMapping(value="/api/overflow", method=RequestMethod.POST)
	    public Question create(@RequestParam(value="question") String query) {
	        Question question = new Question(query);
	        questionService.createQuestion(question);
	        return questionService.createQuestion(question);
	        
	    }
	}
