package org.jsp.onetomany.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.onetomany.dto.Answer;
import org.jsp.onetomany.dto.Question;

public class SaveQuestionAndAnswer
{
public static void main(String[] args) {

	
	Question q=new Question();
	q.setQuestion("what is hibernate");
	q.setQuestionBy("by sathish");
	
	Answer a1= new Answer();
	a1.setAnswer("it is an orm tool");
	a1.setAnsweredBy("aryan");
	
	Answer a2= new Answer();
	a2.setAnswer("it is a open source");
	a2.setAnsweredBy("gupta");
	
	Answer a3= new Answer();
	a3.setAnswer("it is a non invasive");
	a3.setAnsweredBy("hanu");
	
	List<Answer> answers=new ArrayList<Answer>();
	answers.add(a1);
	answers.add(a2);
	answers.add(a3);
	
	//assign the Answer for the question
	q.setAnswers(answers);
	//q.setAnswers(new ArrayList<Answer>(Arrays.asList(a1,a2,a3)));
	
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(q);
	transaction.begin();
	transaction.commit();
	
	
	
	
}
}

