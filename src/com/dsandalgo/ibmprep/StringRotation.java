package com.dsandalgo.ibmprep;

public class StringRotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "ABCD";
		String str2 = "CDAB";
		
		if(isRotation(str1, str2)) {
			System.out.println("Rotations");
		} else {
			System.out.println("Not Rotations");
		}
		
	}

	private static boolean isRotation(String str1, String str2) {
		return (str1.length() == str2.length() && (str1+str1).indexOf(str2) != -1);
	}

}
