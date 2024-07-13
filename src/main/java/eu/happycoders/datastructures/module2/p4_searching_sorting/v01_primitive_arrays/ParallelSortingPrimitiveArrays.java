package eu.happycoders.datastructures.module2.p4_searching_sorting.v01_primitive_arrays;

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

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class ParallelSortingPrimitiveArrays {

  private static final int SIZE = 10_000_000;

  private int[] array;

  @Setup(Level.Invocation)
  public void setup() {
    // TODO: Create random array ... you can use ArrayUtils.createRandomArray()

  }

  @Benchmark
  public void sequentialSort() {
    // TODO: Sort array sequentially

  }

  @Benchmark
  public void parallelSort() {
    // TODO: Sort array in parallel

  }

}

