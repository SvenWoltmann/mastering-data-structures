package eu.happycoders.datastructures.module2.p2_lists.v13_abstractlist;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Objects;

public class MyArrayListSolution<T> extends AbstractList<T> {
  // see SOFT_MAX_ARRAY_LENGTH in jdk.internal.util.ArraysSupport
  private static final int MAX_LENGTH = Integer.MAX_VALUE - 8;

  private T[] elements;
  private int size;

  @SafeVarargs
  public MyArrayListSolution(T... elements) {
    this.elements = elements.clone();
    size = elements.length;
  }

  @Override
  public T get(int index) {
    Objects.checkIndex(index, size);
    return elements[index];
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void add(int index, T element) {
    if (size == elements.length) {
      grow();
    }
    Objects.checkIndex(index, size + 1);
    System.arraycopy(elements, index, elements, index + 1, size - index);
    elements[index] = element;
    size++;
  }

  private void grow() {
    if (elements.length == MAX_LENGTH) {
      throw new OutOfMemoryError();
    }
    long newCapacity = Math.min(elements.length * 2L, MAX_LENGTH);
    elements = Arrays.copyOf(elements, (int) newCapacity);
  }

  @Override
  public T set(int index, T element) {
    Objects.checkIndex(index, size);
    T previous = elements[index];
    elements[index] = element;
    return previous;
  }

  @Override
  public T remove(int index) {
    Objects.checkIndex(index, size);
    T previous = elements[index];
    System.arraycopy(elements, index + 1, elements, index, size - index - 1);
    elements[--size] = null;
    return previous;
  }
}
