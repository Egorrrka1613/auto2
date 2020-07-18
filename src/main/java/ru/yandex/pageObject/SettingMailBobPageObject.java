package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

public class SettingMailBobPageObject extends Base {
  public SettingMailBobPageObject (WebDriver driver) {super(driver);}
  @FindBy(xpath = ".//button [@class = 'control button2 button2_view_classic button2_theme_default mail-GhostButton mail-SettingsButton']")
  private WebElement buttonSetting;

  @FindBy(xpath = ".//a [@class = 'mail-SettingsPopup__menu-item' and @href = '#setup/sender']")
  private WebElement personalDataAndSignature;

  @FindBy(xpath = ".//div [@class ='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']")
  private WebElement signatureField;

  @FindBy(xpath = ".//span [@class = 'ui-button-text']/..")
  private WebElement buttonAddSignature;

  @FindBy(xpath = ".//a [@class = 'b-setup-title__link' and @href = '#inbox']")
  private WebElement buttonToGmail;

  /**
   * В этом методе кликаем по кнопке "Настройки"
   */

  @Step("Кликаем по кнопке настройки")
  public void clickButtonSetting() {
    click(buttonSetting);
    System.out.println("Кликнули по \"Настройки\"");
  }

  /**
   * В этом методе клаикаем по кнопке "Персональные данные, подпись, портрет"
   */

  @Step("Кликаем по копке \"Персональые данные, подпись, портрет\"")
  public void clickPersonalDataAndSignature() {
    click(personalDataAndSignature);
    System.out.println("Кликнули по \"Личные данные, подпись, портрет\"");
  }

  /**
   * В этом методе вводим новую подпись
   */

  @Step("Вводим в поле подписи переданное значение")
  public void setSignatureField(String text) {
    setText(signatureField, text);
    System.out.println("Ввели новый текст подписи");
  }

  /**
   * В этом методе кликаем по кнопке "Добавить подпись"
   */

  @Step("Кликаем по конпке \"Добавить подпись\"")
  public void clickButtonAddSignature() {
    click(buttonAddSignature);
    System.out.println("Добавили новую подпись");
  }

  /**
   * В этом методе возвращаемся в почту, после смены подписи
   */

  @Step("Переходим в почту, из меню настроек")
  public void clickButtonToGmail() {
    click(buttonToGmail);
    System.out.println("Вернулись из настроек в почтовый ящик");
  }

}
