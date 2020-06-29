package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

public class MailPageObject extends Base {

    public MailPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    private WebElement comeGmail;

    @FindBy(xpath = ".//*[@id=\"passp-field-login\"]")
    private WebElement enterLogin;

    @FindBy(xpath = ".//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/div[1]/form/div[3]/button[1]")
    private WebElement enterLoginComplate;

    @FindBy(xpath = ".//*[@id=\"passp-field-passwd\"]")
    private WebElement enterPassword;

    @FindBy(xpath = ".//*[@id=\"root\"]/div/div/div[2]/div/div/div[3]/div[2]/div/div/form/div[2]/button[1]")
    private WebElement enterPasswordComplate;

    @FindBy(xpath = ".//*[@id=\"nb-1\"]/body/div[2]/div[5]/div/div[3]/div[2]/div[2]/div/div/a/span")
    private WebElement writeLetter;

    @FindBy(xpath = ".//*[@id=\"nb-1\"]/body/div[2]/div[9]/div/div[1]")
    private WebElement windowNewLetter;

    /*
    @FindBy(xpath = ".//span[@class = 'tlid-translation translation']/span")
    private WebElement enterTranslate;
     */

    /**
     * В этом методе водим логин
     * @param text
     */

    @Step("В этом методе водим логин")
    public void setEnterLogin(String text) {
        setText(enterLogin, text);
    }

    /**
     * Кликаем по кнопке "Войти" на стартовом экране "Яндекс Почты".
     */

    @Step ("Кликаем по кнопке \"Войти\" указывая наличие зарегестрированного почтового ящика.")
    public void clickComeGmail() {
        click(comeGmail);
    }

    /**
     * Кликаем по "Войти" после ввода логина.
     */

    @Step ("Кликаем по \"Войти\" после ввода логина.")
    public void clickEnterLoginComplate() {
        click(enterLoginComplate);
    }

    /**
     * В этом методе вводим пароль.
     */

    @Step ("В этом методе вводим пароль.")
    public void setEnterPassword(String text) {
        setText(enterPassword, text);
    }

    /**
     * В этом методе кликаем "Войти" после ввода пароля.
     */

    @Step ("Кликаем \"Войти\", после ввода пароля.")
    public void clickEnterPasswordComplate() {
        click(enterPasswordComplate);
    }

    /**
     * В этом методе нажимаем "Написать письмо".
     */

    @Step ("Нажимаем \"Написать\" в ЛК почты")
    public void clickWriteLetter() { click(writeLetter); }

    /**
     * В этом методе проверяем наличие формы создания письма.
     */

    @Step ("Проверяем наличие формы создания нового письма")
    public boolean checkWindowNewLetter(){
        try {
            getDriver().findElement(By.xpath(String.valueOf(windowNewLetter)));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Определение корректности перевода слова.
     * @param transText
     */
    /*
    @Step ("Определение корректности перевода слова.")
    public void assertTranslateIsOk(String transText) {
        boolean result = transText.equalsIgnoreCase(getText(enterTranslate));
        System.out.println("Слово " + transText + " переведено: " + result);
    }

     */
}
