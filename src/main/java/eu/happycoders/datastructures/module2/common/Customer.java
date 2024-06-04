package eu.happycoders.datastructures.module2.common;

public class Customer {
  private String username;

  public Customer(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "%s (%s)".formatted(username,
        Integer.toHexString(System.identityHashCode(this)));
  }
}
