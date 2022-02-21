package IT.Java;

import java.io.IOException;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;


public class Main {
	public static void main(String[] args) throws IOException {
		LongStream fib = LongStream.generate(new FibSupplier());
		// 
		fib.limit(10).forEach(System.out::println);
	}
}

class FibSupplier implements LongSupplier {
	public long getAsLong() {
		return 0;
	}
}
