package ru.yandex;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

  public class randomStringGenerator {
  public static void main(String[] args) {
  }

  /*
  Метод, генерирующий значение темы письма и переменная, в которую это значение передается
   */

  public static String letterSubject() {

    String uuid = UUID.randomUUID().toString();
    System.out.println(uuid + " Тема нового письма");
    return uuid;
  }
  public static String letterSubjectValue = letterSubject();



  /*
  Метод, случайно выбирающий значение, которое будет передано в текст письма
   */

  public static String textLetterChoice() {
    List<String> textLetter = Arrays.asList(
            "Интервьюер интервента интервьюировал.",
            "Жили-были три китайца: Як, Як-цедрак, Як-цедрак-цедрак-цедрони.",
            "Карл у Клары украл рекламу, а Клара у Карла украла бюджет.",
            "Сачок зацепился за сучок.",
            "Тридцать три корабля лавировали-лавировали, да не вылавировали.",
            "Три сороки-тараторки тараторили на горке.");
    Random rand = new Random();
    String i = textLetter.get(rand.nextInt(textLetter.size()));
    return i;
  }
}




