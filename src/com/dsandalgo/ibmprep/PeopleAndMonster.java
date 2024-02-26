package com.dsandalgo.ibmprep;

public class PeopleAndMonster {

	public static void main(String[] args) {
		
		/*
		 * QUESTION : Given a string consisting 2 monsters (@, $) and group of people (P)
		 * Monsters will divide the group & kill the people.
		 * 
		 * TO DO : Find the group of minimum number of people that will be killed by the monster
		 * 
		 * STEPS : divide & take count of number of people in the string every time a monster is encountered.
		 * return the smallest number from the list.
		 */
		
		String group = "PPPPPP@PPP@PP$PP";
		
		int killed = smallestGroup(group);
		System.out.println(killed);

	}

	private static int smallestGroup(String group) {
		int killed = Integer.MAX_VALUE;
		
		int countOfP = 0;
		for (int i=0; i<group.length(); i++) {
			countOfP++;
			
			if (group.charAt(i) == '@' || group.charAt(i) == '$') {
				killed = Math.min(countOfP, killed);
				countOfP = 0;
			}
		}
		
		killed = Math.min(killed, countOfP);
		
		return killed;
	}

}
