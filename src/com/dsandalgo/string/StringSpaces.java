package com.dsandalgo.string;

public class StringSpaces {
	
	public void removeWhiteSpaces(String str) {
		
		/***********How to remove white spaces from in between and around string***********/
		
		StringBuilder sb = new StringBuilder();
		
		char[] arr = str.toCharArray();
		
		for (char c : arr) {
			if (!Character.isWhitespace(c)) {
				sb.append(c);
			}
		}
		
		System.out.println("str : " + str);
		System.out.println("sb : "+ sb);
		
	}
	
	public void removesSpaces(String str) {
		
		/***********How to remove spaces from a string***********/

		System.out.println("s :" + str + ".");

		System.out.println("trim() removes both - leading & trailing spaces-> strip() :" + str.trim() + ".");
		
	}

	public static void main(String[] args) {
		
		StringSpaces obj = new StringSpaces();
		
		String str = "  abc  def\t  ";
		
		obj.removesSpaces(str);
		
		System.out.println("/**********************************************/");

		obj.removeWhiteSpaces(str);

	}

}
