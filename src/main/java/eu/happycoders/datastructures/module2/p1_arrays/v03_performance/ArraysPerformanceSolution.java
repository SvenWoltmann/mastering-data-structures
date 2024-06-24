package eu.happycoders.datastructures.module2.p1_arrays.v03_performance;

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
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class ArraysPerformanceSolution {
  // CPU i7-12700H has 24 MB of cache -->  6,291,456 ints fit into the cache
  //                                  --> 50,000,000 will definitely not fit
  private static final int SIZE = 50_000_000;

  private int[] ints;
  private int[] shuffledInts;
  private Integer[] integers;
  private Integer[] shuffledIntegers;

  @Setup(Level.Trial)
  public void setup() {
    // The setup method will take ~5 seconds.
    // We'll waste some time here, as the method sets up all four arrays for each benchmark.
    // The "right" solution here would be to create multiple @State-annotated classes,
    // each having its own setup method; however, that would make the implementation more complicated.
    ints = IntStream.range(0, SIZE).toArray();

    shuffledInts = IntStream.range(0, SIZE).toArray();
    ArrayUtils.shuffle(shuffledInts);

    integers = IntStream.range(0, SIZE).boxed().toArray(Integer[]::new);

    shuffledIntegers = IntStream.range(0, SIZE).boxed().toArray(Integer[]::new);
    ArrayUtils.shuffle(shuffledIntegers);
  }

  @Benchmark
  public long measureSequentialIntArray() {
    long sum = 0;
    for (int i : ints) {
      sum += i;
    }
    return sum;
  }

  @Benchmark
  public long measureShuffledIntArray() {
    long sum = 0;
    for (int i : shuffledInts) {
      sum += i;
    }
    return sum;
  }

  @Benchmark
  public long measureSequentialIntegerArray() {
    long sum = 0;
    for (Integer i : integers) {
      sum += i;
    }
    return sum;
  }

  @Benchmark
  public long measureShuffledIntegerArray() {
    long sum = 0;
    for (Integer i : shuffledIntegers) {
      sum += i;
    }
    return sum;
  }

}

