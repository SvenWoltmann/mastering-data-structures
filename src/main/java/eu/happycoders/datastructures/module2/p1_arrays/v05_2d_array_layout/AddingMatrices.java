package eu.happycoders.datastructures.module2.p1_arrays.v05_2d_array_layout;

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
public class AddingMatrices {
  // CPU i7-12700H has 24 MB of cache -->  6,291,456 ints fit into the cache
  //                                  --> 25,000,000 x 3 definitely will not fit
  private static final int HEIGHT = 5_000;
  private static final int WIDTH = 5_000;

  private int[][] m1;
  private int[][] m2;

  @Setup(Level.Trial)
  public void setup() {
    // TODO: Setup arrays, using the ArrayUtils.createRandomMatrix() method

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
  public int[][] measureMatrixAdditionWrongWayRound() {
    // TODO: Sum up m1 and m2, iterating over columns first, and return the sum

    return null;
  }

}

