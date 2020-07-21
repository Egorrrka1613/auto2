package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

public class AutorizationMailPageObject extends Base {

    public AutorizationMailPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[contains(@class,'HeadBanner-Button-Enter with-shadow')]")
    private WebElement comeGmail;

    @FindBy(xpath = ".//*[@name='login']")
    private WebElement enterLogin;

    @FindBy(xpath = ".//*[contains(@class,'Button2_size_auth-l') and @type = 'submit']")
    private WebElement enterAuthorizationValue;

    @FindBy(xpath = ".//*[@name='passwd']")
    private WebElement enterPassword;

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

    @Step("Кликаем по кнопке \"Войти\" указывая наличие зарегестрированного почтового ящика.")
    public void clickComeGmail() {
        click(comeGmail);
    }

    /**
     * Кликаем по "Войти" после ввода логина.
     */

    @Step("Кликаем по \"Войти\" после ввода логина.")
    public void clickEnterLoginComplate() {
        click(enterAuthorizationValue);
    }

    /**
     * В этом методе вводим пароль.
     */

    @Step("В этом методе вводим пароль.")
    public void setEnterPassword(String text) {
        setText(enterPassword, text);
    }

    /**
     * В этом методе кликаем "Войти" после ввода пароля.
     */

    @Step("Кликаем \"Войти\", после ввода пароля.")
    public void clickEnterPasswordComplate() {
        click(enterAuthorizationValue);
    }

}