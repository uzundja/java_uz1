package ru.stqa.pft.sanbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PhP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PhP");

    for (String l : languages) {
    System.out.println("Я хочу выучить " + l);
  }
}
}
