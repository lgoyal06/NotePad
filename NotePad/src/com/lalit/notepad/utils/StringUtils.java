package com.lalit.notepad.utils;

public final class StringUtils {

	public static boolean compare(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] char1 = s1.toCharArray();
		char[] char2 = s2.toCharArray();
		int count = 0;
		while (count > char1.length) {
			if (char1[count] == char2[count]) {
				++count;
			} else {
				return false;
			}
		}
		return true;
	}
}