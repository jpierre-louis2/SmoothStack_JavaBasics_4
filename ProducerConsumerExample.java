//Author: Jameson Pierre-Louis
//This program implements a producer & consumer problem
package com.ss.apr.jb.four;


public class ProducerConsumerExample {	
	
	//This class will create a shared resource
	private static class Resource{
		
		private int[] array = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		private boolean available = false;
		
		//This function returns the array if the resource is available
		public synchronized int[] get() {
			while (available == false) {
				try {wait();}
				catch (InterruptedException e) {}
			}
			available = false;
			notifyAll();
			return array;
		}
		
		//This function inserts into our resource array if it's available
		public synchronized void put(int num) {
			while (available == true) {
				try {wait();}
				catch (InterruptedException e) {}
			}
			array[num] = num;
			available = true;
			notifyAll();
		}
	}
	
	
	//Consumer class which wants data from resource
	static class Consumer extends Thread{
		private Resource resource;
		
		//Constructor which takes in shared resource
		public Consumer(Resource r) {
			 resource = r;
		}
		//Run function will read from shared buffer
		public void run() {
			for(int i = 0; i < 10; ++i) {
				int val = resource.get()[i];
				System.out.println("Consumer got: " + val);
			}
		}
	}
	
	
	//Producer class which inserts data into resource
	static class Producer extends Thread{
		private Resource resource;
		
		//Constructor which takes in shared resource
		public Producer(Resource r) {
			resource = r;
		}
		//Run function will insert into shared buffer
		public void run() {
			for(int i = 0; i < 10; ++i) {
				resource.put(i);
				System.out.println("Producer put: " + i);
				try {
					sleep((int)Math.random() * 100);
				}catch(InterruptedException e) {}
			}
		}
	}
	
	
	public static void main(String[] args) {
		Resource r = new Resource();
		Producer p1 = new Producer(r);
		Consumer c1 = new Consumer(r);
		
		p1.start();
		c1.start();
	}

}
