package eu.happycoders.datastructures.module2.p2_lists.v01_array_based_vs_linked;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class AddingToArrayListVsLinkedListBenchmark {

  @Param({"100", "1000", "10000", "100000"})
  public int size;

  @Benchmark
  public List<Integer> testAddingToArrayList() {
    var list = new ArrayList<Integer>(size);
    for (int i = 0; i < size; i++) {
      list.add(0);
    }
    return list;
  }

  @Benchmark
  public List<Integer> testAddingToLinkedList() {
    var list = new LinkedList<Integer>();
    for (int i = 0; i < size; i++) {
      list.add(0);
    }
    return list;
  }

}
