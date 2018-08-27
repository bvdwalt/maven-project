package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

  /**
  * @param someone is the name of the person
  * @return greeting string personalised with the persons name
  */
  public final String greet(final String someone) {
    return String.format("Helloes, %s!", someone);
  }
}
