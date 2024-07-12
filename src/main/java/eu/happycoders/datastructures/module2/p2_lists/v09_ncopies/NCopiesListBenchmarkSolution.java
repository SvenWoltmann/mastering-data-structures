package eu.happycoders.datastructures.module2.p2_lists.v09_ncopies;

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
public class NCopiesListBenchmarkSolution {

  private static final int LIST_SIZE = 10000;
  private static final int LIST_INDEX_FOR_GET = LIST_SIZE >> 1;
  private static final String LIST_ELEMENT = "element";

  private List<String> list;

  @Param({"ArrayList", "nCopies()"})
  private String listType;

  @Setup(Level.Trial)
  public void setup() {
    list = switch (listType) {
      case "ArrayList" -> {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
          arrayList.add(LIST_ELEMENT);
        }
        yield arrayList;
      }
      case "nCopies()" -> Collections.nCopies(LIST_SIZE, LIST_ELEMENT);
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
  public String get() {
    return list.get(LIST_INDEX_FOR_GET);
  }

  @Benchmark
  public int indexOf() {
    return list.indexOf(LIST_ELEMENT);
  }

  @Benchmark
  public boolean contains() {
    return list.contains(LIST_ELEMENT);
  }

  @Benchmark
  public void iteration(Blackhole blackhole) {
    for (String s : list) {
      blackhole.consume(s);
    }
  }
}
