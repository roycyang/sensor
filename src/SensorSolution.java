import java.util.Arrays;

public class SensorSolution implements SensorInterface {

  private int lower;
  private int higher;
  private int[] buffer;

  SensorSolution(int lower, int higher, int[] buffer) {

    this.lower = lower;
    this.higher = higher;
    populateInstanceBuffer(buffer);

  }

  private void populateInstanceBuffer(int[] buffer) {
    int counter = 0;

    for (int bufferElement : buffer) {
      if (isBufferElementInRange(bufferElement)) {
        counter++;
      }
    }
    this.buffer = new int[counter];
    counter = 0;

    for (int bufferElement : buffer) {
      if (isBufferElementInRange(bufferElement)) {
        this.buffer[counter++] = bufferElement;
      }
    }
    Arrays.sort(this.buffer);

    int a = buffer.length;
  }

  private boolean isBufferElementInRange(int bufferElement){
    return bufferElement >= lower && bufferElement <= higher;
  }

  public double findMean() {

    int total = 0;
    for (int i : buffer) {
      total += i;
    }
    return (double)total / buffer.length;

    //return Arrays.stream(buffer).average().getAsDouble();

  }

  @Override
  public double findMedian() {

    int middle = buffer.length/2;

    if (buffer.length %2 != 0){
      return buffer[middle];
    }
    return (buffer [middle] + buffer[middle-1]) / 2.0 ;

  }

  @Override
  public int findMode() {

    //assuming all non negative input todo
    int [] elementCount = new int[higher+1];
    for (int bufferElement : buffer) {
      elementCount[bufferElement]++;
    }
    int mode = 0;
    int modeIndex = 0;

    for (int i=0; i<higher+1; i++){
      if (elementCount[i] > mode){
        mode = i;
        modeIndex = i;
      }
    }
      return modeIndex;

  }
}
