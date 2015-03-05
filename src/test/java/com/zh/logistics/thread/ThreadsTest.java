package com.zh.logistics.thread;

public class ThreadsTest {
	public static void main(String[] args) {
		for (Thread t : getThreads()) {
			t.start();
		}
	}

	public static Thread[] getThreads() {
		Thread[] thread = new Thread[5];
		for (int i = 0; i < 10; i++) {
			final Integer num = new Integer(i);
			thread[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					int j = 1;
					while (j-- > 0) {
						System.out.println("this is thread" + num);
					}
				}
			});
		}
		return thread;
	}
}
