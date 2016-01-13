import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Arrays;
import java.util.Vector;

import steffen.client.Statistics;


public class TestStatistics {

	//Dataset and results from https://www.easycalculation.com/statistics/standard-deviation.php
	Statistics stats =new Statistics(new Vector<Integer>(Arrays.asList(5,10,15,20,25)));
	//Dataset and results from http://www.dummies.com/how-to/content/how-to-calculate-percentiles-in-statistics.html
	Statistics stats2 = new Statistics(new Vector<Integer>(Arrays.asList( 43, 54, 56, 61, 62, 66, 68, 69, 69, 70, 71, 72, 77, 78, 79, 85, 87, 88, 89, 93, 95, 96, 98, 99, 99)));
	
	@Test
	public void testGetMean() {
		AssertJUnit.assertEquals(15.0,stats.getMean());
	}
	
	@Test
	public void testStandardDeviation() {
		AssertJUnit.assertEquals(7905.0, Math. floor(stats.getStandardDeviation()*1000));
	}
	
	@Test
	public void testPercentile() {
		AssertJUnit.assertEquals(98.0, stats2.getPercentile(90));
		AssertJUnit.assertEquals(77.0, stats2.getPercentile(50));
		AssertJUnit.assertEquals(64.0, stats2.getPercentile(20));
	}
}
