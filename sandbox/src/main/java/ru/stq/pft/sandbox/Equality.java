package ru.stq.pft.sandbox;

/**
 * Created by A.Kasimova on 28.09.2016.
 */
public class Equality {
  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = new String(s1);
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));

  }
}
