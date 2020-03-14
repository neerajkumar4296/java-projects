package com.javatrial.thread;

class Counter {
	
	int count;
	public synchronized void increment() {
		count++;
	}
}





public class ThreadDemo {
	
	public static void main(String args[]) throws InterruptedException {
		
		Counter counter= new Counter();
		
		Thread counterThread1= new Thread(()-> 
		{
			for(int i=1; i<=1500; i++) {
				counter.increment();
			
			}
		}
				);
		
		Thread counterThread2= new Thread(()-> 
		{
			for(int i=1; i<=1000; i++) {
				counter.increment();
				
			}
		}
				);
		
		counterThread1.start();
		counterThread2.start();
		
		counterThread1.join();
		counterThread2.join();
		
		System.out.println("Count:: " +counter.count);
		
		Thread thread1= new Thread(()-> 
		{
			for(int i=1; i<=10; i++) {
				System.out.println("printing the value thread1:: " +i);
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
			}
		}
				);
		
		Thread thread2= new Thread(()-> 
		{
			for(int i=1; i<=10; i++) {
				System.out.println("printing the value thread2:: " +i);
				try {Thread.sleep(1000);} catch (InterruptedException e) {}
			}
		}
				);
		
		thread1.setPriority(Thread.MIN_PRIORITY);
		thread2.setPriority(Thread.MAX_PRIORITY);
		System.out.println("priority thread1:: "+thread1.getPriority());
		System.out.println("priority thread1:: "+thread2.getPriority());
		thread1.start();
		try {Thread.sleep(10);} catch (InterruptedException e) {}
		thread2.start();
		
		thread1.join();
		thread2.join();
		
		System.out.println("am i dead:: "+thread1.isAlive()+" am i Daemon:: "+thread1.isDaemon());
		
		
		
		System.out.println("Ahhh!!!!!...Done!!!!!!");
		
	}
	
	

}


