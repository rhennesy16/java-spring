package com.example.gold2;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("count", 0);
			ArrayList<String> events = new ArrayList<String>();
			session.setAttribute("events", events);
		}
		return "index.jsp";
	}

@RequestMapping(value="/process", method=RequestMethod.POST)
public String login(@RequestParam(value="building") String building, HttpSession session) {
	Date now = new Date();
	int gold = (int) session.getAttribute("gold");
	if(building.equals("farm")) {
		int randomNum = ThreadLocalRandom.current().nextInt(10,21);
		gold = gold + randomNum;
		session.setAttribute("gold", gold);
		session.setAttribute("earned", randomNum);
	}
	if(building.equals("house")) {
		int randomNum = ThreadLocalRandom.current().nextInt(2,6);
		gold = gold + randomNum;
		session.setAttribute("gold", gold);
		session.setAttribute("earned", randomNum);
	}
	if(building.equals("casino")) {
		int randomNum = ThreadLocalRandom.current().nextInt(-50,51);
		gold = gold + randomNum;
		session.setAttribute("gold", gold);
		session.setAttribute("earned", randomNum);
	}
	if(building.equals("cave")) {
		int randomNum = ThreadLocalRandom.current().nextInt(5,11);
		gold = gold + randomNum;
		session.setAttribute("gold", gold);
		session.setAttribute("earned", randomNum);
	}
	String event = "";
	if ((int) session.getAttribute("earned") >= 0) {
		event = "Found " + session.getAttribute("earned") + " gold at the " + building + " at " + now; 
	}
	else {
		event = "Lost " + session.getAttribute("earned") + " gold at the " + building + " at " + now;
	}
	ArrayList<String> events = (ArrayList<String>) session.getAttribute("events");
	events.add(event);
	session.setAttribute("events", events);

	return "redirect:/";
	}
@RequestMapping("/clear")
public String clear(HttpSession session) {
	session.invalidate();
	return "redirect:/";
	}
}
