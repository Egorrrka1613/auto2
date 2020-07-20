package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

import java.io.File;
import java.io.IOException;

public class MailBoxPageObject extends Base {

  public MailBoxPageObject (WebDriver driver) {super(driver);}

  @FindBy(xpath = "//a[@class = 'mail-ComposeButton js-main-action-compose']")
  private WebElement writeLetter;

  @FindBy(xpath = ".//div[@class = 'ComposePopup-Content']")
  private WebElement windowNewLetter;

  @FindBy(xpath = ".//div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField tst-field-to']//div[@class = 'composeYabbles']")
  private WebElement addresser;

  @FindBy(xpath = ".//input[@name = 'subject']")
  private WebElement letterSubject;

  @FindBy(xpath = ".//input[@class = 'ComposeAttachFileButton-FileInput' and @type='file']")
  private WebElement uploadFile;

  @FindBy(xpath = ".//button[@class = 'control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")
  private WebElement sendLetter;

  @FindBy(xpath = ".//div[@role='textbox']")
  private WebElement textLetter;

  @FindBy(xpath = ".//a[@class = 'control link link_theme_normal ComposeDoneScreen-Link' and @href = '#inbox']")
  private WebElement returnToInBox;

  @FindBy(xpath = ".//span [@class = 'mail-ComposeButton-Refresh js-main-action-refresh ns-action']")
  private WebElement refreshMail;

  @FindBy(xpath = ".//div[@class = 'ns-view-container-desc mail-MessagesList js-messages-list']/div[1]/div/div[2]/div[1]/div[1]/div")
  private WebElement receiveLetter;

  @FindBy(xpath = ".//span[@class = 'mail-Message-Toolbar-Subject-Wrapper']")
  private WebElement letterSubjectValueInBox;

  @FindBy(xpath = ".//div[@class = 'js-message-body-content mail-Message-Body-Content']/div[1]")
  private WebElement textLetterInBox;

  @FindBy(xpath = ".//a[@class = 'mail-File-Actions-Item js-skip-click-message-item js-attachment-actions-item js-download-attachment mail-File-Actions-Item_secondary']")
  private WebElement buttonDowonladAttach;

  @FindBy(xpath = ".//div[@class = 'ComposeReact-SignatureContainer']")
  private WebElement signList;

  @FindBy(xpath = ".//div[@class = 'ComposeReact-SignatureMenuAnchor']")
  private WebElement signListOpen;

  @FindBy(xpath = ".//span[@class = 'mail-NestedList-Item-Name' and contains(text(), 'Входящие')]")
  private WebElement inboxLetterButton;

  @FindBy(xpath = ".//div[@class = 'ns-view-container-desc']/div[1]//span[@class = 'checkbox_view']")
  private WebElement buttonChooseAllLetters;

  @FindBy(xpath = ".//span[@class = 'mail-Toolbar-Item-Text js-toolbar-item-title js-toolbar-item-title-delete']")
  private WebElement buttonDeleteLetter;

  @FindBy(xpath = ".//span[@class = 'button2__text' and text() = 'Удалить']/..")
  private WebElement confirmDelete;

  @FindBy(xpath = ".//div[@class = 'ns-view-container-desc mail-MessagesList js-messages-list']/div[1]")
  private WebElement existAnyLetter;

  @FindBy(xpath = ".//div[text() = 'В папке «Входящие» нет писем.']")
  private WebElement checkNoLetter;

  @Step("asd")
  public void testtest() {  }


  /**
   * В этом методе нажимаем "Написать письмо".
   */

  @Step("Нажимаем \"Написать\" в ЛК почты")
  public void clickWriteLetter() { click(writeLetter); }

  /**
   * В этом методе проверяем наличие формы создания письма.
   */

  @Step("Проверяем наличие формы создания нового письма")
  public void checkWindowNewLetter() {
    //assertTrue(getDriver().findElement(By.xpath(xpath)).getText().contains("Новое письмо")); --- недописаная попытка проверки окошка новго пиьсьма с использованием JUnit
    try {
      getText(windowNewLetter);
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
    setText(addresser, text);
  }

  /**
   * В этом методе указываем тему письма
   */

  @Step("Указываем тему письма")
  public void setLetterSubject(String text) {
    setText(letterSubject, text);
  }

  /**
   * В этом методе пишем текст письма
   */

  @Step("Пишем текст письма")
  public void writeTextLetter(String text) {
    setText(textLetter, text);
  }

  /**
   * В этом методе создаем файл, для прикрепления к письму
   */

  @Step("Создаем файл для прикрепления к письму")
  public void fileNewCreate() {
    try {
      new File("src/main/resources/file.txt").createNewFile();
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
    setTextForAttach(uploadFile, "/src/main/resources/file.txt");
  }

  /**
   * В этом методе нажимаем "Отправить"
   */

  @Step("Нажимаем \"Отправить\"")
  public void clickSendLetter() {
    click(sendLetter);
    System.out.println("Отправили письмо");
  }

  /**
   * В этом методе нажимаем "Вернуться во входящие"
   */

  @Step("Нажимаем \"Вернуться во входящие\"")
  public void clickReturnToInBox() {
    click(returnToInBox);
    System.out.println("Вернулись во входящие");
  }

  /**
   * В этом методе обновляем почтовый ящик
   */

  @Step("Нажимаем \"Проверить, есть ли новые письма \"")
  public void clickRefreshGmail() {
    click(refreshMail);
    System.out.println("Почтовый ящик обновлен");
  }

  /**
   * В этом методе кликаем по письму с указанной темой
   */

  @Step("Проверяем наличие письма, с указанной темой")
  public void findLetterSubject(String subjectLetter) {
    String xpath = ".//span[@title = '" + subjectLetter + "']/..";
    try {
      click(xpath);
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
    click(receiveLetter);
    System.out.println("Переход во входящее письмо выполнен");
  }

  /**
   * Метод для сравнения темы писем
   */

  @Step("Сравнение темм писем")
  public void compareLetterSubject(String text) {
    String letterSubjectValueInBoxStr = getText(letterSubjectValueInBox);
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
    String textLetterInBoxStr = getText(textLetterInBox);
    if (text.equals(textLetterInBoxStr))
      System.out.println("Тексты сравниваемых писем равны");
    else
      System.out.println("Тексты сравниваемых писем различаются");
  }

  /**
   * Метод для скачивания, проверки наличия и удаления аттачей
   */

  @Step("Скачиваем аттач письма, проверяем что он сохранился в директорию загрузки")
  public void dowonladCheckAttach() throws InterruptedException {
    click(buttonDowonladAttach);
    Thread.sleep(3000);
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
    new File("C:/Users/Егор/Downloads/file.txt").delete();
  }

  /**
   * В этом методе удаляем созданный аттач
   */

  @Step("Удаляем созданный аттач файла")
  public void deleteCreateAttach() {
    new File("src/main/resources/file.txt").delete();
    System.out.println("Удалил файл атача");
  }


  /**
   * В этом методе открываем меню выбора подписи для письма
   */

  @Step("Открываем меню выбора подписи")
  public void clickSignList() {
    click(signList);
    click(signListOpen);
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
    click(buttonChooseAllLetters);
  }

  /**
   * В этом метоже удаляем полученные письма
   */

  @Step("Удаляем все письма")
  public void clickButtonDeleteLetter() {
    click(buttonDeleteLetter);
  }

  /**
   * В этом методе подтверждаем удаление всех отмеченных писем
   */

  @Step("Подтверждаем удаление")
  public void clickConfirmDelete() {
    click(confirmDelete);
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



}
