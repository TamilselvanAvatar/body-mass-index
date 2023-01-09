package com.bmi.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class AgeService {

	public String calculateAge(String date) {

		LocalDate today = LocalDate.now();

		LocalDate dob = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		Period age = Period.between(dob, today);

		return "you are " + age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days old.";
	}
}
