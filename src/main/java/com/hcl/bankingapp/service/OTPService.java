package com.hcl.bankingapp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bankingapp.utility.MailWithOTPService;

@Service
public class OTPService {
	
	@Autowired
	MailWithOTPService mailWithOTPService;

	public void generateOTPandSendMail(String email) {
		
		String body = "\\";
		Random rand = new Random();
		long otp = 1000 + rand.nextInt(9999);
		mailWithOTPService.sendEmail(email, otp, "", body);
		
		
	}
}
