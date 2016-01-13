package steffen.client;

import java.io.IOException;
import java.util.Vector;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class WebClient implements Runnable {

	static Vector<Integer> results = new Vector<Integer>();

	int number = 0;

	private CloseableHttpClient httpClient;

	public WebClient(int i, CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
		number = i;
	}

	public void run() {
		HttpGet httpGet = new HttpGet("http://wikipedia.org");
		System.out.println("Executing Task " + number);
		long start = System.currentTimeMillis();
		try {
			CloseableHttpResponse response = httpClient.execute(httpGet);
			if (response.getStatusLine().getStatusCode() == 200
					|| response.getStatusLine().getStatusCode() == 301) {
				results.add((int) (System.currentTimeMillis() - start));
				System.out.println("Added");
			} else {
				System.out.println(response.getStatusLine().getStatusCode());
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
