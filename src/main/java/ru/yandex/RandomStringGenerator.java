package ru.yandex;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class RandomStringGenerator {

  /*
  Метод, генерирующий значение темы письма и переменная, в которую это значение передается
   */
  public static String letterSubject() {

    String uuid = UUID.randomUUID().toString();
    return uuid;
  }
  public static String letterSubjectValue = letterSubject();

  /*
  Метод, случайно выбирающий значение, которое будет передано в переменную, используемую для хранения текста письма
   */

  public static String textLetterChoice() {
    List<String> textLetter = Arrays.asList(
            "Интервьюер интервента интервьюировал.",
            "Жили-были три китайца: Як, Як-цедрак, Як-цедрак-цедрак-цедрони.",
            "Карл у Клары украл рекламу, а Клара у Карла украла бюджет.",
            "Сачок зацепился за сучок.",
            "Тридцать три корабля лавировали-лавировали, да не вылавировали.");
    Random rand = new Random();
    String i = textLetter.get(rand.nextInt(textLetter.size()));
    return i;
  }

  public static String textLetterChoiceValue = textLetterChoice();

  // Метод, генерирующий подпись и переменная хранящее значения из метода

  public static String signatureGenerate() {
    int length = 8;
    String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvwxyz"
            + "0123456789";
    String str = new Random().ints(length, 0, chars.length())
            .mapToObj(i -> "" + chars.charAt(i))
            .collect(Collectors.joining());
    return str;
  }

  public static String signatureGenerateValue = signatureGenerate();

}




