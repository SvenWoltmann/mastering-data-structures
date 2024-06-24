package eu.happycoders.datastructures.module2.common;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class ArrayUtils {

  private ArrayUtils() {
  }

  public static void shuffle(int[] array) {
    Random random = ThreadLocalRandom.current();

    for (int i = 0; i < array.length; i++) {
      int randomIndexToSwap = random.nextInt(array.length);
      int temp = array[randomIndexToSwap];
      array[randomIndexToSwap] = array[i];
      array[i] = temp;
    }
  }

  public static void shuffle(long[] array) {
    Random random = ThreadLocalRandom.current();

    for (int i = 0; i < array.length; i++) {
      int randomIndexToSwap = random.nextInt(array.length);
      long temp = array[randomIndexToSwap];
      array[randomIndexToSwap] = array[i];
      array[i] = temp;
    }
  }

  public static <E> void shuffle(E[] array) {
    Random random = ThreadLocalRandom.current();

    for (int i = 0; i < array.length; i++) {
      int randomIndexToSwap = random.nextInt(array.length);
      E temp = array[randomIndexToSwap];
      array[randomIndexToSwap] = array[i];
      array[i] = temp;
    }
  }

  public static int[][] createRandomMatrix(int width, int height) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    int[][] result = new int[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        result[y][x] = random.nextInt();
      }
    }
    return result;
  }

  public static int[] createRandomArray(int length) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = random.nextInt();
    }
    return result;
  }

  public static int[] createRandomPositiveArray(int length) {
    ThreadLocalRandom random = ThreadLocalRandom.current();
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = random.nextInt(Integer.MAX_VALUE);
    }
    return result;
  }
}
