package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

import java.io.File;
import java.io.IOException;

public class AutorizationMailPageObject extends Base {

    public AutorizationMailPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//a[@class = 'button2 button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']")
    private WebElement comeGmail;

    @FindBy(xpath = ".//*[@name='login']")
    private WebElement enterLogin;

    @FindBy(xpath = ".//div[@class = 'passp-button passp-sign-in-button']/button[@type = 'submit']")
    private WebElement enterLoginComplate;

    @FindBy(xpath = ".//*[@name='passwd']")
    private WebElement enterPassword;

    @FindBy(xpath = ".//div[@class = 'passp-button passp-sign-in-button']/button[@type = 'submit']")
    private WebElement enterPasswordComplate;

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
        click(enterLoginComplate);
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
        click(enterPasswordComplate);
    }

}