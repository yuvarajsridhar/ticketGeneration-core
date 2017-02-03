package com.yuvaraj.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.yuvaraj.exception.ValidationException;

public class ValidationUtil {

	private ValidationUtil() {

	}

	public static void isInvalidObject(Object obj, String msg) throws ValidationException {
		if (obj == null) {
			throw new ValidationException(msg);
		}
	}

	public static void isInvalidString(String name, String msg) throws ValidationException {
		if (name == null || "".equals(name.trim())) {
			throw new ValidationException(msg);
		}
	}

	public static void isInvalidNumber(Integer number, String msg) throws ValidationException {
		if (number == null || number <= 0) {
			throw new ValidationException(msg);
		}
	}

	public static void isInvalidTime(LocalTime time, String msg) throws ValidationException {

		if (time == null) {
			throw new ValidationException(msg);
		}
	}

	public static void isValidDateTime(LocalDateTime time, String msg) throws ValidationException {
		if (time == null) {
			throw new ValidationException(msg);
		}
	}

	public static void isValidBoolean(Boolean bol, String msg) throws ValidationException {
		if (bol == null) {
			throw new ValidationException(msg);
		}
	}






public static void isValidEmail(String email, String msg) throws ValidationException {
		if (email == null || "".equals(email.trim()) || !email.contains("@") || !email.contains(".")) {
			throw new ValidationException(msg);
		}
	}

	public static void isValidPassword(String password, String msg) throws ValidationException {
		if (password == null || "".equals(password.trim()) || password.length() < 8) {
			throw new ValidationException(msg);
		}
	}

}
