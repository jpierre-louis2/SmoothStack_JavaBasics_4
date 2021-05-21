//Author: Jameson Pierre-Louis
//This program implements our Double Checked Locking Singleton Class
package com.ss.apr.jb.four;


public class SingletonDoubleChecked {
	
	public static void main(String[] args) {
		//We grab the instance and print out the message
		SingletonExample s1 = SingletonExample.getInstance();
		s1.printMessage();
	}

}
