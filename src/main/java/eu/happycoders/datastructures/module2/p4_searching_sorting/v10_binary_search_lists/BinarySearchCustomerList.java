import eu.happycoders.datastructures.module2.p4_searching_sorting.common.Customer;

import java.util.ArrayList;
import java.util.Arrays;

void main() {
  var customers = new ArrayList<>(Arrays.asList(
      new Customer("jmarsh", 97221, "Jordan", "Marsh"),
      new Customer("lgibson", 17346, "Lane", "Gibson"),
      new Customer("award", 39632, "Aiden", "Ward"),
      new Customer("agibson", 36376, "Ashton", "Gibson")
  ));

  customers.sort(null);
  for (int i = 0; i < customers.size(); i++) {
    Customer customer = customers.get(i);
    System.out.println(i + ": " + customer);
  }


}