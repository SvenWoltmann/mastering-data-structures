package eu.happycoders.datastructures.module2.p2_lists.v07_empty_lists;

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
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)

@Warmup(iterations = 2, time = 5)
@Measurement(iterations = 5, time = 5)
@Fork(1)
public class EmptyListBenchmarkSolution {

  private List<String> list;

  @Param({"ArrayList", "List.of()", "emptyList()"})
  private String listType;

  @Setup(Level.Trial)
  public void setup() {
    list = switch (listType) {
      case "ArrayList" -> new ArrayList<>();
      case "List.of()" -> List.of();
      case "emptyList()" -> Collections.emptyList();
      default -> throw new IllegalStateException();
    };
  }

  @Benchmark
  public int size() {
    return list.size();
  }

  @Benchmark
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Benchmark
  public int indexOf() {
    return list.indexOf("element");
  }

  @Benchmark
  public boolean contains() {
    return list.contains("element");
  }

  @Benchmark
  public void iteration(Blackhole blackhole) {
    for (String s : list) {
      blackhole.consume(s);
    }
  }
}
