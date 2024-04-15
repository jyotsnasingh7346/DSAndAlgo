package com.dsandalgo.interviewPrep;

import java.util.Arrays;
import java.util.Comparator;

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
		
		String minDead = Arrays.stream(group.split("[@$]"))
                .min(Comparator.comparingInt(String::length)).orElse("");
		
		System.out.println("People to die = " + minDead);
		
		int miniDead = Arrays.stream(group.split("[@$]"))
                .min(Comparator.comparingInt(String::length)).map(String::length).orElse(0);
		System.out.println("Minimum number of people to die = " + miniDead);
		
	}


}
