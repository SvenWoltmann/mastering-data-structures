import java.util.Arrays;

void main() {
  int[] ints;
  ints = new int[]{32, 21, 9, 20, 98, 20, 48};

  int[] ints2 = new int[20];

  System.out.println("ints = " + Arrays.toString(ints));
  System.out.println("ints2 = " + Arrays.toString(ints2));

  System.out.println("ints[0] = " + ints[0]);

  ints[2] = 99;
  System.out.println("ints = " + Arrays.toString(ints));
}