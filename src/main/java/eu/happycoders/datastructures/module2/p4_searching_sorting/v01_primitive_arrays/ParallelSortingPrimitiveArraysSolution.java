package eu.happycoders.datastructures.module2.p4_searching_sorting.v01_primitive_arrays;

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

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class ParallelSortingPrimitiveArraysSolution {

  private static final int SIZE = 10_000_000;

  private int[] array;

  @Setup(Level.Invocation)
  public void setup() {
    array = ArrayUtils.createRandomArray(SIZE);
  }

  @Benchmark
  public void sequentialSort() {
    Arrays.sort(array);
  }

  @Benchmark
  public void parallelSort() {
    Arrays.parallelSort(array);
  }

}

