import java.util.Arrays;

void main() {
  // ⎡2 3 6⎤
  // ⎣6 4 3⎦
  int[][] m1 = {
      {3, 2, 1},
      {1, 0, 2}
  };

  int[][] m2 = {
      {4, 5, 1},
      {0, 1, 4}
  };

  int[][] sum = add(m1, m2);
  System.out.println("sum = " + Arrays.deepToString(sum));
}

private static int[][] add(int[][] m1, int[][] m2) {
  int height = m1.length;
  int width = m1[0].length;

  int m2Width = m2[0].length;
  int m2Height = m2.length;

  if (width != m2Width || height != m2Height) {
    throw new IllegalArgumentException();
  }

  int[][] sum = new int[height][width];

  for (int y = 0; y < height; y++) {
    for (int x = 0; x < width; x++) {
      sum[y][x] = m1[y][x] + m2[y][x];
    }
  }

  return sum;
}
