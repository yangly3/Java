package IT.Java;

import java.util.concurrent.Callable;


public class Main {

	public static void main(String[] args) throws Exception {
		Callable<Long> callable = new Task(123450000L);
		Thread thread = new Thread(new RunnableAdapter(callable));
		thread.start();
		thread.join();
	}
}
