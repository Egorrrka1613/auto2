package ru.yandex;
import java.util.UUID;

public class randomStringGenerator {
  public static void main(String[] args) {
  }

  public static String generateString() {
    String uuid = UUID.randomUUID().toString();
    return uuid;
  }
}
