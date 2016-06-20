package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
	@RequestMapping("/")
	public String renderUI(Model model) {
		model.addAttribute("name", "World");
		return "index";
	}
}
