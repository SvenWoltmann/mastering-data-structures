package eu.happycoders.datastructures.module2.p1_arrays.v07_fill;

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

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class ParallelSetAllBenchmark {

  private static final int SIZE = 100_000_000;

  private int[] array;

  @Setup(Level.Invocation)
  public void setup() {
    array = new int[SIZE];
  }

  @Benchmark
  public void measureSetAllCheap() {
    Arrays.setAll(array, i -> i);
  }

  @Benchmark
  public void measureParallelSetAllCheap() {
    Arrays.parallelSetAll(array, i -> i);
  }

  @Benchmark
  public void measureSetAllExpensive() {
    Arrays.setAll(array, i -> (int) Math.sqrt(i));
  }

  @Benchmark
  public void measureParallelSetAllExpensive() {
    Arrays.parallelSetAll(array, i -> (int) Math.sqrt(i));
  }
}
