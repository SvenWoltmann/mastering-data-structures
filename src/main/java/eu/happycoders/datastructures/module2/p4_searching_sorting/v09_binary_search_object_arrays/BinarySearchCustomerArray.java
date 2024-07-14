import eu.happycoders.datastructures.module2.p4_searching_sorting.common.Customer;

import java.util.Arrays;

void main() {
  Customer[] customers = {
      new Customer("jmarsh", 97221, "Jordan", "Marsh"),
      new Customer("lgibson", 17346, "Lane", "Gibson"),
      new Customer("award", 39632, "Aiden", "Ward"),
      new Customer("agibson", 36376, "Ashton", "Gibson")
  };

  Arrays.sort(customers);
  for (int i = 0; i < customers.length; i++) {
    Customer customer = customers[i];
    System.out.println(i + ": " + customer);
  }


}