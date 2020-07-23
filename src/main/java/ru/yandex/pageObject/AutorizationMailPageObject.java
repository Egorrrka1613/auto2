package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

public class AutorizationMailPageObject extends Base {

    public AutorizationMailPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//a[contains(@class,'HeadBanner-Button-Enter')]")
    private WebElement comeGmailButton;

    @FindBy(xpath = ".//input[@name='login']")
    private WebElement enterLoginField;

    @FindBy(xpath = ".//button[contains(@class,'Button2_size_auth-l') and @type = 'submit']")
    private WebElement enterAuthorizationValueButton;

    @FindBy(xpath = ".//input[@name='passwd']")
    private WebElement enterPasswordField;

    /**
     * В этом методе водим логин
     * @param text
     */

    @Step("В этом методе водим логин")
    public void setEnterLogin(String text) {
        setText(enterLoginField, text);
    }

    /**
     * Кликаем по кнопке "Войти" на стартовом экране "Яндекс Почты".
     */

    @Step("Кликаем по кнопке \"Войти\" указывая наличие зарегестрированного почтового ящика.")
    public void clickComeGmail() {
        click(comeGmailButton);
    }

    /**
     * Кликаем по "Войти" после ввода логина.
     */

    @Step("Кликаем по \"Войти\" после ввода логина.")
    public void clickEnterLoginComplate() {
        click(enterAuthorizationValueButton);
    }

    /**
     * В этом методе вводим пароль.
     */

    @Step("В этом методе вводим пароль.")
    public void setEnterPassword(String text) { setText(enterPasswordField, text); }

    /**
     * В этом методе кликаем "Войти" после ввода пароля.
     */

    @Step("Кликаем \"Войти\", после ввода пароля.")
    public void clickEnterPasswordComplate() {
        click(enterAuthorizationValueButton);
    }

}