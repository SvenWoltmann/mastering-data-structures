package eu.happycoders.datastructures.module2.p1_arrays.v05_2d_array_layout;

import eu.happycoders.datastructures.module2.common.ArrayUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class AddingSmallMatrices {
  private static final int HEIGHT = 3;
  private static final int WIDTH = 4;

  private int[][] m1;
  private int[][] m2;
  private int[] m3;
  private int[] m4;

  @Setup(Level.Invocation)
  public void setup() {
    m1 = ArrayUtils.createRandomMatrix(WIDTH, HEIGHT);
    m2 = ArrayUtils.createRandomMatrix(WIDTH, HEIGHT);

    // TODO: Setup m3 and m4, using the ArrayUtils.createRandomArray() method

  }

  @Benchmark
  public int[][] measureMatrixAddition() {
    int height = m1.length;
    int width = m1[0].length;

    int[][] sum = new int[height][width];

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        sum[y][x] = m1[y][x] + m2[y][x];
      }
    }

    return sum;
  }

  @Benchmark
  public int[] measureFlatMatrixAddition() {
    // TODO: Sum up m3 and m4

    return null;
  }

}

