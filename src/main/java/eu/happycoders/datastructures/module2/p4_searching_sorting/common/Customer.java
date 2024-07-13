package eu.happycoders.datastructures.module2.p4_searching_sorting.common;

public record Customer(String username,
                       int customerId,
                       String firstName,
                       String lastName) implements Comparable<Customer> {

  @Override
  public int compareTo(Customer o) {
    return Integer.compare(this.customerId, o.customerId);
  }
}
