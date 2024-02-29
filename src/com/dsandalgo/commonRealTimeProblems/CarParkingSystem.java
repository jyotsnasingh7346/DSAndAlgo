package com.dsandalgo.commonRealTimeProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class CarParkingSystem {
	
	/*
	 * This program can be used to park and unPark cars in a parking lot. 
	 * It also displays the list of parked cars. 
	 * The program can be extended to add more features, such as the ability to reserve a parking slot,
	 */

	private static final int TOTAL_SLOTS = 100;
	private static int AVAILABLE_SLOTS = 100;
	private static final int PARKED_CARS = 0;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Create a list to store the parked cars
		ArrayList<Car> parkedCars = new ArrayList<>();

		// Display the main menu
		System.out.println("Main Menu");
		System.out.println("1. Park a car");
		System.out.println("2. Unpark a car");
		System.out.println("3. Display the list of parked cars");
		System.out.println("4. Exit");

		// Get the user's choice
		int choice = scanner.nextInt();

		// Perform the selected operation
		switch (choice) {
		
		case 1: // Park a car
			parkCar(parkedCars);
			break;
		
		case 2: // UnPark a car
			unparkCar(parkedCars);
			break;
		
		case 3: // Display the list of parked cars
			displayParkedCars(parkedCars);
			break;
		
		case 4: // Exit the program
			System.exit(0);
			break;
		
		default:
			System.out.println("Invalid choice");
		}

		// Close the scanner
		scanner.close();
	}

	private static void parkCar(ArrayList<Car> parkedCars) {

		Scanner scanner = new Scanner(System.in);
		
		// Get the car's details
		System.out.println("Enter the car's number:");
		String carNumber = scanner.next();

		System.out.println("Enter the car's type:");
		String carType = scanner.next();

		// Create a new car object
		Car car = new Car(carNumber, carType);

		// Add the car to the list of parked cars
		parkedCars.add(car);

		// Update the number of available slots
		AVAILABLE_SLOTS--;

		// Display a message
		System.out.println("Car parked successfully");
		
		scanner.close();
	}

	private static void unparkCar(ArrayList<Car> parkedCars) {

		Scanner scanner = new Scanner(System.in);
		
		// Get the car's number
		System.out.println("Enter the car's number:");
		String carNumber = scanner.next();

		// Find the car in the list of parked cars
		Car car = null;
		for (Car parkedCar : parkedCars) {
			if (parkedCar.getCarNumber().equals(carNumber)) {
				car = parkedCar;
				break;
			}
		}

		// If the car is not found, display a message
		if (car == null) {
			System.out.println("Car not found");
			return;
		}

		// Remove the car from the list of parked cars
		parkedCars.remove(car);

		// Update the number of available slots
		AVAILABLE_SLOTS++;

		// Display a message
		System.out.println("Car unparked successfully");
		
		scanner.close();
	}

	private static void displayParkedCars(ArrayList<Car> parkedCars) {

		// If there are no parked cars, display a message
		if (parkedCars.isEmpty()) {
			System.out.println("No cars parked");
			return;
		}

		// Display the list of parked cars
		System.out.println("List of parked cars:");
		for (Car parkedCar : parkedCars) {
			System.out.println(parkedCar.getCarNumber() + " - " + parkedCar.getCarType());
		}
	}
}

class Car {

	private String carNumber;
	private String carType;

	public Car(String carNumber, String carType) {
		this.carNumber = carNumber;
		this.carType = carType;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getCarType() {
		return carType;
	}
}
