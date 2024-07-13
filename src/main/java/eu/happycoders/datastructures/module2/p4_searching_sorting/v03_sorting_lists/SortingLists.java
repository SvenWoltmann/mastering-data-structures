
import eu.happycoders.datastructures.module2.p4_searching_sorting.common.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

void main() {
  List<Customer> customers = new ArrayList<>(Arrays.asList(
      new Customer("jmarsh", 97221, "Jordan", "Marsh"),
      new Customer("lgibson", 17346, "Lane", "Gibson"),
      new Customer("award", 39632, "Aiden", "Ward"),
      new Customer("agibson", 36376, "Ashton", "Gibson")
  ));


  for (Customer customer : customers) {
    System.out.println(customer);
  }

}