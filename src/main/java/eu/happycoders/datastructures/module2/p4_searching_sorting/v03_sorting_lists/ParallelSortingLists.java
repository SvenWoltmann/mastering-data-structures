package eu.happycoders.datastructures.module2.p4_searching_sorting.v03_sorting_lists;

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
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class ParallelSortingLists {

  private static final int SIZE = 5_000_000;

  private List<Integer> list;

  @Setup(Level.Invocation)
  public void setup() {
    list = Arrays.stream(ArrayUtils.createRandomArray(SIZE)).boxed().collect(Collectors.toList());
  }

  @Benchmark
  public void parallelSortViaArray() {
    Object[] a = list.toArray();
    Arrays.parallelSort(a, null);
    ListIterator<Integer> i = list.listIterator();
    for (Object e : a) {
      i.next();
      i.set((Integer) e);
    }
  }

  @Benchmark
  public List<Integer> parallelSortViaStream() {
    return list.parallelStream().sorted().toList();
  }

}
