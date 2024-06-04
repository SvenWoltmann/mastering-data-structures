import eu.happycoders.datastructures.module2.common.Customer;

import java.util.Arrays;

void main() {
  Customer[] customers = new Customer[] {
      new Customer("jmarsh"),
      new Customer("lgibson"),
      new Customer("award"),
  };

  System.out.println("customers = " + Arrays.toString(customers));
  System.out.println("customers[1] = " + customers[1]);

  customers[1] = new Customer("batkinson");
  System.out.println("customers = " + Arrays.toString(customers));

  customers[2].setUsername("atkinson");
  System.out.println("customers = " + Arrays.toString(customers));
}