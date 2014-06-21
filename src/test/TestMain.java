package test;

import java.util.concurrent.atomic.AtomicInteger;

public class TestMain {
	public AtomicInteger counter = new AtomicInteger(0);

	public static void main(String[] args) throws Exception {
		TestMain main = new TestMain();
		for (int i = 0; i < 10; i++) {
			new Thread(main.new Client()).start();
		}
		System.in.read();
	}

	class Client implements Runnable {

		@Override
		public void run() {
			while (true) {
				System.out.println(counter.addAndGet(1));
			}
		}

	}
}
