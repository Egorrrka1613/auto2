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

    @FindBy(xpath = ".//a[@class = 'button2 button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow']")
    private WebElement comeGmail;

    @FindBy(xpath = ".//*[@name=\"login\"]")
    private WebElement enterLogin;

    @FindBy(xpath = ".//div[@class = 'passp-button passp-sign-in-button']/button[@type = 'submit']")
    private WebElement enterLoginComplate;

    @FindBy(xpath = ".//*[@name=\"passwd\"]")
    private WebElement enterPassword;

    @FindBy(xpath = ".//div[@class = 'passp-button passp-sign-in-button']/button[@type = 'submit']")
    private WebElement enterPasswordComplate;

    @FindBy(xpath = "//a[@class = 'mail-ComposeButton js-main-action-compose']")
    private WebElement writeLetter;

    @FindBy(xpath = ".//div[@class = 'ComposePopup-Content']")
    private WebElement windowNewLetter;

    @FindBy(xpath = ".//div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField tst-field-to']//div[@class = 'compose-LabelRow-Content']/div[@class = 'MultipleAddressesDesktop-Field ComposeYabblesField']/div[@class = 'composeYabbles']")
    private WebElement addresser;

    @FindBy(xpath = ".//input[@name = 'subject']")
    private WebElement letterSubject;

    @FindBy(xpath = ".//input[@class = 'ComposeAttachFileButton-FileInput' and @type='file']")
    private WebElement uploadFile;


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
     * В этом методе указываем поле для ввода адреса письма
     */

    @Step("Указываем поле для ввода адреса письма")
    public void setAddresser (String text) {setText(addresser, text);}

    /**
     * В этом методе указываем тему письма
     */

    @Step("Указываем тему письма")
    public void setLetterSubject (String text) {setText(letterSubject, text);}

    /**
     * В этом методе кликаем на "прикрепить"
     */
    /*
    @Step ("Кликаем Прикрепить")
    public void clickAttach() { click(attach); }

     */

    /**
     *  В этом методе загружаем файл к письму
     */

    @Step("Загружаем файл к письму")
    public void setUploadFile() {
        //uploadFile.sendKeys("C:\\dowonlad\\README.txt");
        setText(uploadFile,"C:\\dowonlad\\README.txt");
/*
        WebElement fileInput = getDriver().findElement(By.xpath(String.valueOf(uploadFile)));
        fileInput.sendKeys("C:\\dowonlad\\README.txt");

        By attach2 = By.xpath(".//input[@class = 'ComposeAttachFileButton-FileInput' and @type='file']");
        String uploadFile2 = "C:\\dowonlad\\README.txt";
        getDriver().findElement(attach2).sendKeys(uploadFile2);*/
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
