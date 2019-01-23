import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SensorTest {

  private SensorInterface sensor;

  @Before
  public void createSensor() {

    sensor = new Sensor(1, 10, new int[]{-2, 8, 5, 3, 8, 8, 1, 15});
    //todo test with different input, edge cases, negative numbers

  }


  @Test
  public void TestMean() {

    double meanResult = sensor.findMean();
    assertEquals(meanResult, 5.5, 0);

  }

  @Test
  public void TestMedian() {

    double medianResult = sensor.findMedian();

    assertEquals(medianResult, 6.5, 0);

  }

  @Test
  public void TestMode() {

    int modeResult = sensor.findMode();

    assertEquals(modeResult, 8, 0);

  }

}
