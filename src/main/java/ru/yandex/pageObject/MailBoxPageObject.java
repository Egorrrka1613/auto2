package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

import java.io.File;
import java.io.IOException;

public class MailBoxPageObject extends Base {

  public MailBoxPageObject (WebDriver driver) {super(driver);}

  @FindBy(xpath = ".//a[contains(@title, 'Написать')]")
  private WebElement writeLetterButton;

  @FindBy(xpath = ".//div[@class = 'ComposePopup-Content']")
  private WebElement newLetterWindow;

  @FindBy(xpath = ".//div[contains(@class, 'tst-field-to')]//div[@class = 'composeYabbles']")
  private WebElement addresserField;

  @FindBy(xpath = ".//input[@name = 'subject']")
  private WebElement letterSubjectField;

  @FindBy(xpath = ".//input[contains(@class, 'Button') and @type='file']")
  private WebElement uploadFileButton;

  @FindBy(xpath = ".//button[contains(@class, 'Button_action')]")
  private WebElement sendLetterButton;

  @FindBy(xpath = ".//div[@role='textbox']")
  private WebElement textLetterField;

  @FindBy(xpath = ".//a[contains(@class, 'ComposeDoneScreen-Link') and @href = '#inbox']")
  private WebElement returnToBoxMailButton;

  @FindBy(xpath = ".//span[contains(@class, 'Refresh')]")
  private WebElement refreshMailButton;

  @FindBy(xpath = ".//div[contains(@class, 'mail-MessagesList')]/div[1]/div/div[2]/div[1]/div[1]/div")
  private WebElement receiveLetterElement;

  @FindBy(xpath = ".//span[contains(@class, 'Subject')]")
  private WebElement letterSubjectValueInBoxField;

  @FindBy(xpath = ".//div[contains(@class, 'Message-Body-Content')]/div[1]")
  private WebElement textLetterInBoxField;

  @FindBy(xpath = ".//a[contains(@class, 'download-attachment mail-File')]")
  private WebElement dowonladAttachButton;

  @FindBy(xpath = ".//div[contains(@class, 'SignatureContainer')]")
  private WebElement signListFiled;

  @FindBy(xpath = ".//div[contains(@class, 'SignatureMenu')]")
  private WebElement signListButton;

  @FindBy(xpath = ".//span[contains(@class, 'Item-Name') and contains(text(), 'Входящие')]")
  private WebElement inboxLetterButton;

  @FindBy(xpath = ".//div[contains(@class, 'Item_main-select-all')]//span[@class = 'checkbox_view']")
  private WebElement chooseAllLettersButton;

  @FindBy(xpath = ".//span[contains(@class, 'title-delete')]")
  private WebElement buttonDeleteLetter;

  @FindBy(xpath = ".//div[contains(@class, 'js-messages-list')]/div[1]")
  private WebElement existAnyLetter;

  @FindBy(xpath = ".//div[text() = 'В папке «Входящие» нет писем.']")
  private WebElement checkNoLetter;

  String fileName = "file.txt";

  /**
   * В этом методе нажимаем "Написать письмо".
   */

  @Step("Нажимаем \"Написать\" в ЛК почты")
  public void clickWriteLetter() { click(writeLetterButton); }

  /**
   * В этом методе проверяем наличие формы создания письма.
   */

  @Step("Проверяем наличие формы создания нового письма")
  public void checkWindowNewLetter() {
    //assertTrue(getDriver().findElement(By.xpath(xpath)).getText().contains("Новое письмо")); --- недописаная попытка проверки окошка новго пиьсьма с использованием JUnit
    try {
      getText(newLetterWindow);
      System.out.println("Форма найдена");
    } catch (NoSuchElementException e) {
      System.out.println("Форма не найдена");
    }
  }

  /**
   * В этом методе указываем поле для ввода адреса письма
   */

  @Step("Указываем поле для ввода адреса письма")
  public void setAddresser(String text) {
    setText(addresserField, text);
  }

  /**
   * В этом методе указываем тему письма
   */

  @Step("Указываем тему письма")
  public void setLetterSubject(String text) {
    setText(letterSubjectField, text);
  }

  /**
   * В этом методе пишем текст письма
   */

  @Step("Пишем текст письма")
  public void writeTextLetter(String text) {
    setText(textLetterField, text);
  }

  /**
   * В этом методе создаем файл, для прикрепления к письму
   */

  @Step("Создаем файл для прикрепления к письму")
  public void fileNewCreate() {
    try {
      new File(fileName).createNewFile();
      //SaveInHTML sih = new SaveInHTML(System.getProperty("user.dir")+"/Hello.txt");
      System.out.println("Создан файл аттача");
    } catch (IOException ex) {
      System.out.println(ex.getMessage());
    }
  }

  /**
   * В этом методе загружаем файл к письму, после загрузки удаляем файл
   */

  @Step("Загружаем файл к письму")
  public void setUploadFile() {
    setTextForAttach(uploadFileButton, fileName);
  }

  /**
   * В этом методе нажимаем "Отправить"
   */

  @Step("Нажимаем \"Отправить\"")
  public void clickSendLetter() {
    click(sendLetterButton);
    System.out.println("Отправили письмо");
  }

  /**
   * В этом методе нажимаем "Вернуться во входящие"
   */

  @Step("Нажимаем \"Вернуться во входящие\"")
  public void clickReturnToInBox() {
    click(returnToBoxMailButton);
    System.out.println("Вернулись во входящие");
  }

  /**
   * В этом методе обновляем почтовый ящик
   */

  @Step("Нажимаем \"Проверить, есть ли новые письма \"")
  public void clickRefreshGmail() {
    click(refreshMailButton);
    System.out.println("Почтовый ящик обновлен");
  }

  /**
   * В этом методе кликаем по письму с указанной темой
   */

  @Step("Проверяем наличие письма, с указанной темой")
  public void findLetterSubject(String subjectLetter) {
    String xpathLetterSubjectElement = ".//span[@title = '" + subjectLetter + "']";
    try {
      click(xpathLetterSubjectElement);
      System.out.println("Письмо с указанной темой присутствует");
      //.//span[@title = '163fa291-0e2a-4749-9494-29f0ce7b70bb'] --- xpath для проверки темы
    } catch ( TimeoutException u) {
      System.out.println("Письмо с указанной темой отсутствует");
    }
  }

  /**
   * В этом методе открываем принятое письмо
   */

  @Step("Открываем принятое письмо")
  public void clickReceiveLetter() {
    click(receiveLetterElement);
    System.out.println("Переход во входящее письмо выполнен");
  }

  /**
   * Метод для сравнения темы писем
   */

  @Step("Сравнение темм писем")
  public void compareLetterSubject(String text) {
    String letterSubjectValueInBoxStr = getText(letterSubjectValueInBoxField);
    if (text.equals(letterSubjectValueInBoxStr)) {
      System.out.println("Темы сравниваемых писем равны");
    }
    else System.out.println("Темы сравниваемых писем не равны");
  }

  /**
   * Метод для сравнения текста писем
   */

  @Step("Сравнение текста писем")
  public void compareLetterText(String text) {
    String textLetterInBoxStr = getText(textLetterInBoxField);
    if (text.equals(textLetterInBoxStr))
      System.out.println("Тексты сравниваемых писем равны");
    else
      System.out.println("Тексты сравниваемых писем различаются");
  }

  /**
   * Метод для скачивания, проверки наличия и удаления аттачей
   */

  @Step("Скачиваем аттач письма, проверяем что он сохранился в директорию загрузки")
  public void dowonladCheckAttach() {
    click(dowonladAttachButton);
    System.out.println("Файл скачан");
    /*
    Условие для проверки наличия файла в директории загрузки

    if (new File("C:/Users/Егор/Downloads/file.txt").isFile()) {
      System.out.println("Файл присутствует в директории загрузки");
    } else
      System.out.println("Файл отсутствует в директории загрузки");

     */
  }

  /**
   * В этом методе удаляем скачанный аттач
   */

  @Step("Удаляем скачанный аттач файла")
  public void deleteDowonladAttach() {
    new File(fileName).delete();
  }

  /**
   * В этом методе удаляем созданный аттач
   */

  @Step("Удаляем созданный аттач файла")
  public void deleteCreateAttach() {
    new File(fileName).delete();
    System.out.println("Удалил файл атача");
  }


  /**
   * В этом методе открываем меню выбора подписи для письма
   */

  @Step("Открываем меню выбора подписи")
  public void clickSignList() {
    click(signListFiled);
    click(signListButton);
  }

  /**
   * В этом методе выбираем сформированную ранее подпись для письма
   */

  @Step("Выбираем подпись для письма")
  public void findSignLetter(String signLetterVal) {
    String xpath = "//div[contains(., '" + signLetterVal + "') and @class = 'SignaturesPopupMenu-Text']";
    //.//div[contains(., 'L1WMnuVp') and @class = 'SignaturesPopupMenu-Text'] -- хпас для проверки на странице
    click(xpath);

    System.out.println("Созданная подпись выбрана для письма");
  }

  /**
   * В этом методе возвращаемся в раздел "Входящие"
   */

  @Step("Возвращаемся в раздел \"Входящие\"")
  public void clickInboxLetterButton() {
    click(inboxLetterButton);
  }

  /**
   * В этом методе кликаем по чекбоксу, для выбора всех писем в почте
   */

  @Step("Выделяем все письма в почте")
  public void clickButtonChooseAllLetters() {
    click(chooseAllLettersButton);
  }

  /**
   * В этом метоже удаляем полученные письма
   */

  @Step("Удаляем все письма")
  public void clickButtonDeleteLetter() {
    click(buttonDeleteLetter);
  }

  /**
   * В этом методе проверяем отсутствие писем в почте
   * @return
   */

  @Step("Проверяем отсутствие писем в почте")
  public void checkExistAnyLetter() {
    Boolean isPresent = getDriver().findElements(By.xpath(".//div[@class = 'ns-view-container-desc mail-MessagesList js-messages-list']/div[1]")).size() > 0;
    if (isPresent) {
      System.out.println("Письма присутсвуют в почтовом ящике");
    }
    else
      System.out.println("Письма удалены");
  }

  /**
   * В этом методе проверяем соответствие подписи в письме
   * @param sign
   */

  @Step("Проверяем соответствие подписи в письме")
  public void checkSignLetter(String sign) {
    Assert.assertTrue(getDriver().findElement(By.xpath(".//div[@class = 'js-message-body-content mail-Message-Body-Content']/div[4]")).getText().contains(sign));
  }
}
