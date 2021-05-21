//Author: Jameson Pierre-Louis
//This file SingletonExample is a singleton class example (With Double Checked Locking)
package com.ss.apr.jb.four;

public class SingletonExample {

	//Creates a volatile instance object of our class called instance
	private static volatile SingletonExample instance;
	
	private SingletonExample() {/*We make the constructor private to create a Singleton class*/} //Singleton constructor
	
	//Returns the instance of the singleton class
	public static SingletonExample getInstance() {
		//Occurs should there not be an instance already created
		//This method is referred to as double checked because we check with and without a lock
		if(instance == null) { //Single Checked
			synchronized (SingletonExample.class) {
				if(instance == null) { //Double Checked
					instance = new SingletonExample();
				}
			}
		}
		return instance;
	}
	

	//Simple print function to help test our Singleton Class
	public void printMessage() {
		System.out.println("This is the Singleton Class");
	}
	
}
