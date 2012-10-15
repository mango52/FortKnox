package me.mango.utils;

public class Utils {
	public static Integer parseInteger(String s) {
		try {
			Integer i = Integer.parseInt(s);
			if(i > 0) return i;
		} catch(NumberFormatException ex) {
			return -1;
		}
		return -1;
	}
}