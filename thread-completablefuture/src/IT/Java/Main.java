package IT.Java;

import java.util.concurrent.CompletableFuture;


public class Main {
	public static void main(String[] args) throws Exception {
		// 
		CompletableFuture<String> cfQueryFromSina = CompletableFuture.supplyAsync(() -> {
			return queryCode("中国石油", "https://finance.sina.com.cn/code/");
		});
		CompletableFuture<String> cfQueryFrom163 = CompletableFuture.supplyAsync(() -> {
			return queryCode("中国石油", "https://money.163.com/code/");
		});

		//
		CompletableFuture<Object> cfQuery = CompletableFuture.anyOf(cfQueryFromSina, cfQueryFrom163);

		// 
		CompletableFuture<Double> cfFetchFromSina = cfQuery.thenApplyAsync((code) -> {
			return fetchPrice((String) code, "https://finance.sina.com.cn/price/");
		});
		CompletableFuture<Double> cfFetchFrom163 = cfQuery.thenApplyAsync((code) -> {
			return fetchPrice((String) code, "https://money.163.com/price/");
		});

		// 
		CompletableFuture<Object> cfFetch = CompletableFuture.anyOf(cfFetchFromSina, cfFetchFrom163);

		//
		cfFetch.thenAccept((result) -> {
			System.out.println("price: " + result);
		});
		// 
		Thread.sleep(2000);
	}

	static String queryCode(String name, String url) {
		System.out.println("query code from " + url + "...");
		try {
			Thread.sleep((long) Math.random() * 1000);
		} catch (InterruptedException e) {
		}
		return "601857";
	}

	static Double fetchPrice(String code, String url) {
		System.out.println("query price from " + url + "...");
		try {
			Thread.sleep((long) Math.random() * 1000);
		} catch (InterruptedException e) {
		}
		return 5 + Math.random() * 20;
	}
}
