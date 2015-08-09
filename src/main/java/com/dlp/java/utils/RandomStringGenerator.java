package com.dlp.java.utils;

import java.util.Random;

public class RandomStringGenerator {

	private static Random random = new Random();

	private char[] characterSet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'j', 'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'M',
			'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '2',
			'3', '4', '5', '6', '7', '8', '9' };

	public RandomStringGenerator(char[] characterSet) {
		if (characterSet != null && characterSet.length > 2) {
			this.characterSet = characterSet;
		}
	}

	public String getRandomString(int length) {
		if (length < 1) {
			throw new IllegalArgumentException("Ridiculous password length "
					+ length);
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(characterSet[random.nextInt(characterSet.length)]);
		}
		return sb.toString();
	}
}
