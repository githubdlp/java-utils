package com.dlp.social.java_utils;

public class StringUtil {
	public String reverse(String input) {
		return hasLength(input) && input.length() > 1 ? new StringBuilder(input)
				.reverse().toString() : input;
	}

	public boolean hasLength(String input) {
		return (input != null && !input.trim().isEmpty()) ? true : false;
	}
}
