package io.pubby.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import io.pubby.data.DataService;
import io.pubby.models.Question;

@Controller
@SessionAttributes("question")
public class PubbyController {

	@Autowired
	DataService dataService;
	
	
	@ModelAttribute
	public Question question() {
		
		return new Question();
	}

	@RequestMapping("/question")
	public String showHome(Model model) {
		
		return "question-home";

	}

	@RequestMapping("/question/form")
	public String showForm(Model model, @ModelAttribute Question question) {
		
		System.out.println(question.toString());
		
		List<String> questionTypes = Arrays.asList("left_or_right", "would_you_rather", "player_vote");
        model.addAttribute("questionTypes", questionTypes);
        question.setId(null);
        question.setDescription("");
		return "question-form";

	}

	@RequestMapping("/question/submit")
	public String submitForm(Model model, SessionStatus status, @ModelAttribute Question question) {

		
		dataService.saveQuestion(question).subscribe();
		
		System.out.println(question);
		return "question-submit";

	}

}
