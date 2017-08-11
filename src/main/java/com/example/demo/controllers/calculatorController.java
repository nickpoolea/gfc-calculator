package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class calculatorController {
	
	@GetMapping("")
	public String index() {
		return "/index";
	}
	
	@PostMapping("calc")
	public ModelAndView calcHandler(String selection, 
									@RequestParam("left")  double intOne, 
									@RequestParam("right") double intTwo) {
		
		ModelAndView mv = new ModelAndView("/results");
		double result = 0;
		
		switch(selection) {
		
		case "add"     : result = intOne + intTwo;
		break;
		case "subtract": result = intOne - intTwo;
		break;
		case "multiply": result = intOne * intTwo;
		break;
		case "divide"  : result = intOne / intTwo;
		break;
		case "modular" : result = intOne % intTwo;
		break;
		case "exponent": result = Math.pow(intOne,  intTwo);
		break;
		
		}
		
		mv.addObject("result", result);
		return mv;
	}
	
	@GetMapping("calc")
	public String get() {
		return "/results";
	}

}
