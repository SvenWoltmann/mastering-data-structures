import java.util.List;
import java.util.ListIterator;

void main() {
  var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
  System.out.println("list = " + list);
  
  ListIterator<Integer> iterator = list.listIterator(list.size());
  while (iterator.hasPrevious()) {
    System.out.print(iterator.previous() + " ");
  }
  System.out.println();

  for (Integer i : list.reversed()) {
    System.out.print(i + " ");
  }
  System.out.println();
}
