import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sensor {

  private int lower;
  private int higher;
  private int[] buffer;
  private int[] output;

  Sensor(int lower, int higher, int[] buffer) {
    this.lower = lower;
    this.higher = higher;
    this.buffer = buffer;
  }


  public double findMean() {
    return Arrays.stream(this.getOutput()).average().orElse(Double.NaN);
  }

  public double findMedian() {
    int[] a = this.getOutput();
    int n = a.length;

    // Even
    if (n % 2 != 0) {
      return (double)a[n / 2];
    }

    return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
  }

  public int findMode() {
    // Creating a HashMap
    Map<Integer, Integer> modeMapping = new HashMap<>();

    int[] output = this.getOutput();
    int highest = 0;
    int mode = output[0];
    int i;
    int count;

    System.out.println("MODE");

    // iterating over an array
    for (i = 0; i < output.length; i++) {
      int key = output[i];

      if (modeMapping.containsKey(key)) {
        count = modeMapping.get(key);
        modeMapping.put(key, count + 1);
      } else {
        modeMapping.put(key, 1);
        count = 1;
      }

      if (count >= highest) {
        highest = count;
        mode = key;
      }
    }

    return mode;
  }


  public int getLower() {
    return lower;
  }

  public int getHigher() {
    return higher;
  }

  public int[] getBuffer() {
    return buffer;
  }

  public int[] getOutput() {
    int[] output = Arrays.stream(this.buffer).filter(number -> number >= this.lower && number <= this.higher).toArray();
    Arrays.sort(output);
    return output;
  }

  public String toString() {
    String strOfInts = Arrays
            .stream(this.getOutput())
            .mapToObj(String::valueOf)
            .reduce((a, b) -> a.concat(",").concat(b))
            .get();

    return strOfInts;
  }
}


