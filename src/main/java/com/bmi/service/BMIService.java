package com.bmi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bmi.bean.User;

@Service
@Repository
public class BMIService {

	public static List<String> genderType = new ArrayList<>();
	public static Map<Integer, User> userList = new HashMap<>();
	private static int userId = 1000;

	public BMIService() {
		genderType.add("Male");
		genderType.add("Female");
		genderType.add("Others");
	}

	public User addUserDetails(User user) {
		user.setUserId(++userId);
		userList.put(userId, user);
		return user;
	}

	public double calculateBMI(User user) {
		// multiplication by 100*100 for cm to m conversion
		int height = user.getHeight();
		double weight = user.getWeight();

		return Math.ceil((100 * 100 * weight) / (height * height));
	}

	public String getBMIStatus(double bmi) {
		return bmi < 18.5 ? "underweight" : (bmi < 25 ? "normal" : (bmi <= 30 ? "overweight" : "obese"));
	}

}
