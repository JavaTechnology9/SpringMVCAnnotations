package com.javatechnology.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidEmail, String>{

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN="[A-Za-z0-9]";
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		 pattern = Pattern.compile(EMAIL_PATTERN);
		 matcher=pattern.matcher(email);
		return matcher.matches();
	}

}
