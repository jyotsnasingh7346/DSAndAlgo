package com.dsandalgo.string;

public class ContainsVowels {

	public boolean hasVowels(String str) {
		return str.toLowerCase().matches(".*[aeiou].*");
	}
	
	public static void main(String[] args) {

		ContainsVowels vow = new ContainsVowels();
		String str = "Jyotsna";
		System.out.println("Does " + str + " has vowels? : " + vow.hasVowels(str));

	}

}
