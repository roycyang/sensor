public class Sensor implements SensorInterface {

  private int lower;
  private int higher;
  private int[] buffer;

  Sensor(int lower, int higher, int[] buffer) {

  }

  @Override
  public double findMean() {
    return 0;
  }

  @Override
  public double findMedian() {
    return 0;
  }

  @Override
  public int findMode() {
    return 0;
  }


}
