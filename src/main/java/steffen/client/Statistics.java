package steffen.client;

import java.util.Arrays;
import java.util.Vector;

public class Statistics {
	Vector<Integer> series = null;
	long sum = 0;

	public Statistics(Vector<Integer> results) {
		series = results;
		for (int i = 0; i < series.size(); i++) {
			sum += series.get(i);
		}

	}

	public double getMean() {
		return sum / series.size();
	}

	public double getStandardDeviation() {
		//http://web.stanford.edu/class/ed150x/variability.doc		
		double squared_diff_sum = 0;
		for (int i = 0; i < series.size(); i++) {
			squared_diff_sum += (series.get(i) - getMean())
					* (series.get(i) - getMean());
			System.out.println(series.get(i) - getMean());
		}
		System.out.println("Variance: " + squared_diff_sum
				/ (series.size() - 1));
		return Math.sqrt(squared_diff_sum / (series.size() - 1));

	}

	public double getPercentile(double percent) {
		
		//http://web.stanford.edu/class/archive/anthsci/anthsci192/anthsci192.1064/handouts/calculating%20percentiles.pdf

		double i = percent * series.size() / 100 + .5;
		int k = (int) Math.floor(i);
		System.out.println("k: "+k);
		double f = i - k;
		Integer sorted[] = (Integer[]) series.toArray(new Integer[] {});
		Arrays.sort(sorted);

		return (1 - f) * sorted[k-1] + f * sorted[k];

	}
}
