//Author: Jameson Pierre-Louis
//This program will show a Deadlock example between 2 threads
package com.ss.apr.jb.four;


public class DeadlockExample {
	
	//This is an empty class used to create a shared needed resource
	private static class Resource{}
	
	public static Resource r1 = new Resource();
	public static Resource r2 = new Resource();
	
	
	//Our first Thread which will Hold resource 1 first and then wait for resource 2
	private static class ThreadExample1 extends Thread{
		public void run() {
			//Thread 1 gets a hold on resource 1 first
			synchronized(r1) {
				System.out.println("Thread 1: Holding Resource 1");
				try { Thread.sleep(10); }
				catch(InterruptedException e) {}
				System.out.println("Thread 1: Waiting for Resource 2");
				//Thread 1 is trying to access the second resource, however it is waiting on Thread 2 which is currently holding on to it
				//If Thread 2 ever lets go of resource 2 a message will be printed stating Thread 1 now has both resources
				synchronized (r2){
					System.out.println("Thread 1: Holding Resources 1 & 2");
				}
			}
		}
	}
	
	
	//Our second Thread which will Hold resource 2 first and then wait for resource 1
	private static class ThreadExample2 extends Thread{
		public void run() {
			//Thread 2 gets a hold on resource 2 first
			synchronized(r2) {
				System.out.println("Thread 2: Holding Resource 2");
				try { Thread.sleep(10); }
				catch(InterruptedException e) {}
				System.out.println("Thread 2: Waiting for Resource 1");
				//Thread 2 is trying to access the first resource, however it is waiting on Thread 1 which is currently holding on to it
				//If Thread 1 ever lets go of resource 1 a message will be printed stating Thread 2 now has both resources
				synchronized (r1){
					System.out.println("Thread 2: Holding Resources 1 & 2");
				}
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		ThreadExample1 t1 = new ThreadExample1();
		ThreadExample2 t2 = new ThreadExample2();
		t1.start();
		t2.start();
	}
	
}
