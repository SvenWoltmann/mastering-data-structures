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
@OutputTimeUnit(TimeUnit.MILLISECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class AddingMatricesSolution {
  // CPU i7-12700H has 24 MB of cache -->  6,291,456 ints fit into the cache
  //                                  --> 25,000,000 x 3 definitely will not fit
  private static final int HEIGHT = 5_000;
  private static final int WIDTH = 5_000;

  private int[][] m1;
  private int[][] m2;

  @Setup(Level.Trial)
  public void setup() {
    m1 = ArrayUtils.createRandomMatrix(WIDTH, HEIGHT);
    m2 = ArrayUtils.createRandomMatrix(WIDTH, HEIGHT);
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
  public int[][] measureMatrixAdditionOptimized() {
    int height = m1.length;
    int width = m1[0].length;

    int[][] sum = new int[height][width];

    for (int y = 0; y < height; y++) {
      int[] row1 = m1[y];
      int[] row2 = m2[y];
      int[] rowSum = sum[y];
      for (int x = 0; x < width; x++) {
        rowSum[x] = row1[x] + row2[x];
      }
    }

    return sum;
  }

  @Benchmark
  public int[][] measureMatrixAdditionWrongWayRound() {
    int height = m1.length;
    int width = m1[0].length;

    int[][] sum = new int[height][width];

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        sum[y][x] = m1[y][x] + m2[y][x];
      }
    }

    return sum;
  }

}

