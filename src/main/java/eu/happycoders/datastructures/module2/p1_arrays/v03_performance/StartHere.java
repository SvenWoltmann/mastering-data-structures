package eu.happycoders.datastructures.module2.p1_arrays.v03_performance;

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
public class StartHere {
  // CPU i7-12700H has 24 MB of cache -->  6,291,456 ints fit into the cache
  //                                  --> 50,000,000 definitely will not fit
  private static final int SIZE = 50_000_000;

  private int[] ints;
  private int[] shuffledInts;
  private Integer[] integers;
  private Integer[] shuffledIntegers;

  @Setup(Level.Trial)
  public void setup() {
    // TODO: Setup arrays, you can use helper functions
    //  from eu.happycoders.datastructures.module2.common.ArrayUtils

  }

  @Benchmark
  public long measureSequentialIntArray() {
    // TODO: Count all values of the sequential int array and return the sum

    return 0;
  }

  @Benchmark
  public long measureShuffledIntArray() {
    // TODO: Count all values of the shuffled int array and return the sum

    return 0;
  }

  @Benchmark
  public long measureSequentialIntegerArray() {
    // TODO: Count all values of the sequential Integer array and return the sum

    return 0;
  }

  @Benchmark
  public long measureShuffledIntegerArray() {
    // TODO: Count all values of the shuffled Integer array and return the sum

    return 0;
  }

}

