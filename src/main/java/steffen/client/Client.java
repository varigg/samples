package steffen.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client {

	public static void main(String args[]) {
		CloseableHttpClient httpClient = HttpClients.createMinimal();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 100; i++) {
			executor.execute(new WebClient(i,httpClient));
		}
		executor.shutdown();
		try {
			if (executor.awaitTermination(30, TimeUnit.SECONDS)) {
				System.out.println("Statistics");
				Statistics stats=new Statistics(WebClient.results);
				System.out.println("Mean: "+stats.getMean());
				System.out.println("Std. Deviation: "+stats.getStandardDeviation());
			} else {
				System.out.println("Timed out.");
				
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
