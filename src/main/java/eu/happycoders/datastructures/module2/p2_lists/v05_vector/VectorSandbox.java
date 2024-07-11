import java.util.Vector;

public void main() {
  var vector = new Vector<String>();

  vector.add("lemon");
  vector.add("blueberry");
  vector.add("papaya");

  System.out.println("vector = " + vector);
  System.out.println("vector.get(1) = " + vector.get(1));

  vector.addFirst("orange");

  vector.add(2, "banana");

  vector.removeLast();
  vector.removeFirst();

  System.out.println("vector = " + vector);

  vector.remove(1);

  System.out.println("vector = " + vector);
}