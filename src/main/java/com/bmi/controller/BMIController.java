package com.bmi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.bmi.bean.User;
import com.bmi.service.AgeService;
import com.bmi.service.BMIService;

@Controller
public class BMIController {
//add the code as per the requirement
    @Autowired
    private BMIService bmiService;
    
    @Autowired
    private AgeService ageService;
	
	@GetMapping(value="/bmiForm")
	public String showBMIForm(@ModelAttribute("user") User user) {
		return "bmiCalculatorForm";
	}

	@GetMapping(value="/getBMI")
	public String getBMIStatus(@ModelAttribute("user") @Valid User user, BindingResult result, ModelMap map) {
	    
	    if(result.hasErrors()){
	        return "bmiCalculatorForm";
	    }
	    
	    User validUser = bmiService.addUserDetails(user);
	    Double bmi = bmiService.calculateBMI(validUser);
	    String bmiStatus = bmiService.getBMIStatus(bmi);
	    
	    map.addAttribute("validUser",validUser);
	    map.addAttribute("bmi",bmi);
	    map.addAttribute("BMIstatus",bmiStatus);
	    map.addAttribute("dob",ageService.calculateAge(user.getDob()));
	
		return "bmiStatus";

	}
    
    @ModelAttribute("genderList")
	public List<String> populateGenderList() {
	return BMIService.genderType;
	}
}