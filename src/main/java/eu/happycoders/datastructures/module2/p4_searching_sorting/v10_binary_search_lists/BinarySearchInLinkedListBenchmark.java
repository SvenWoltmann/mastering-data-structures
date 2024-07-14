package eu.happycoders.datastructures.module2.p4_searching_sorting.v10_binary_search_lists;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Collections;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)

@Warmup(iterations = 3, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class BinarySearchInLinkedListBenchmark {

  @Param({"100", "1000", "10000", "100000"})
  private int size;

  private int key;

  private LinkedList<Integer> list;

  @Setup(Level.Trial)
  public void setupList() {
    list = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      list.add(i);
    }
  }

  @Setup(Level.Invocation)
  public void setupKey() {
    key = ThreadLocalRandom.current().nextInt(size);
  }

  @Benchmark
  public int testBinarySearch() {
    return Collections.binarySearch(list, key);
  }

  @Benchmark
  public int testSequentialSearch() {
    return list.indexOf(key);
  }
}
