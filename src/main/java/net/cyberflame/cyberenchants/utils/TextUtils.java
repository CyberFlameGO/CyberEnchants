package net.cyberflame.cyberenchants.utils;

public class TextUtils {

	public static int removeLetters(String content) {

		String numbers = "";
		
		char[] listChars = content.toCharArray();
		
		for (char tempChar : listChars) {
			
			if (tempChar >= '0' && tempChar <= '9') {
				numbers += tempChar;
			}
		}

		return Integer.parseInt(numbers);
	}

	public static String removeColours(String content) {

		int index = 0;
		
		do {
			index = content.indexOf("&");
			
			if (index > -1) {
				String remove = content.substring(index, index+2);
				content = content.replace(remove, "");
			}
			
		} while (index != -1);
		
		return content;
	}
}
