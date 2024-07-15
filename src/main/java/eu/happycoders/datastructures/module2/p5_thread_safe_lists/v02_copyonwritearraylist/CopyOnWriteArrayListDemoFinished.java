import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

void main() throws InterruptedException {
  Consumer<String> observer1 = string -> System.out.println("observer 1 observed: " + string);
  Consumer<String> observer2 = string -> System.out.println("observer 2 observed: " + string);
  Consumer<String> observer3 = string -> System.out.println("observer 3 observed: " + string);

  var subject = new CopyOnWriteArrayList<Consumer<String>>();
  subject.add(observer1);
  subject.add(observer2);
  subject.add(observer3);

  Thread.startVirtualThread(() -> {
    int counter = 3;
    while (true) {
      int observerId = ++counter;
      Consumer<String> observer = string -> System.out.println("observer " + observerId + " observed: " + string);
      subject.add(observer);
      sleepLong();
    }
  });

  Thread.startVirtualThread(() -> {
    while (true) {
      subject.removeFirst();
      sleepLong();
    }
  });

  while (true) {
    subject.forEach(observer -> observer.accept("message"));
    System.out.println();
    Thread.sleep(500);
  }
}

private static void sleepLong() {
  try {
    Thread.sleep(ThreadLocalRandom.current().nextInt(1500, 2500));
  } catch (InterruptedException e) {
    throw new RuntimeException(e);
  }
}