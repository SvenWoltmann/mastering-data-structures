import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

void main() {
  var list = new ArrayList<>(Arrays.asList(11, -7, 12, 18, 12, 6, -17, 8, 5, -12, 3, -12, 7, 11, -8));
  System.out.println("list = " + list);

  ListIterator<Integer> iterator = list.listIterator();

  while (iterator.hasNext()) {
    Integer i = iterator.next();
    if (i < 0) {
      iterator.remove();
      if (iterator.hasPrevious()) {
        Integer previous = iterator.previous();
        iterator.set(-previous);
        iterator.next();
      }
    }
  }

  System.out.println("list = " + list);
}
