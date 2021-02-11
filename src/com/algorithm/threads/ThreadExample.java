package com.algorithm.threads;

public class ThreadExample {
	public volatile  int status = 1;
	
	public static void main(String args[]) {
		ThreadExample t1 = new ThreadExample();
		RunnableClass r1 = new RunnableClass(t1,1);
		RunnableClass r2 = new RunnableClass(t1,2);
		RunnableClass r3 = new RunnableClass(t1,3);
		

		r1.start();
		r2.start();
		r3.start();
	}

};

class RunnableClass extends Thread {
	private ThreadExample var;
	private int toPrint;

	public RunnableClass(ThreadExample var, int toPrint) {
		this.var = var;
		this.toPrint = toPrint;
	}

	public void run() {
		
		try {
			synchronized (var) {
//				System.out.println("status in "+toPrint+" beginning: "+var.status);
				for (int i = 0; i < 5; i++) {
					while(toPrint!=var.status) {
//						System.out.println("in wait at "+ toPrint);
						var.wait();
					}
					System.out.print(toPrint+"\t,");
					var.status = (var.status%3) + 1;
//					System.out.println("status in "+toPrint+" end: "+var.status);
					var.notifyAll();
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}