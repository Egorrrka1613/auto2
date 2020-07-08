package ru.yandex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static java.nio.file.Files.delete;

public class FileToAttach {

  //Переменная, содержащая номер файла
  private static int numFile = 1;

/*
  public static String getSeparetor() {
    String fileSeparator = System.getProperty("file.separator");
    String absoluteFilePath = fileSeparator + "dowonlad" + fileSeparator + "autoTest" + fileSeparator + "attach" + fileSeparator +"file" + numFile + ".txt";
    return absoluteFilePath;
  }

  private static File file;
  public static File getFile(String path) {
    return file;
  }

 */



  //В этом методе создается и заполняется значениями файл для аттача
  public static void createFileToAttach() throws IOException {
    //File file123 = getFile(getSeparetor());

    //Определяем символ разделителя директории
    String fileSeparator = System.getProperty("file.separator");

    //Указываем путь, до папки, где сохраняются файлы
    String absoluteFilePath = fileSeparator + "dowonlad" + fileSeparator + "autoTest" + fileSeparator + "attach" + fileSeparator +"file" + numFile + ".txt";
    File file = new File(absoluteFilePath);

    if(file.createNewFile()){
      System.out.println(file + " Файл аттача создан");
    } else {
      System.out.println("Файл " + file + " уже существует");
    }

    //Записываем текст в файл
    FileWriter fileWriter = new FileWriter(file);
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    bufferedWriter.write("Это файл, номер " + numFile);
    bufferedWriter.flush();
    bufferedWriter.close();

    numFile++;
  }

  //В этом методе удаляется файл аттача
  public static void deleteAttach() {
    //boolean deleted = file123.delete();
    numFile--;
  }



}
