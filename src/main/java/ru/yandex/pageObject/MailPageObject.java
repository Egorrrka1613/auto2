package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;
import ru.yandex.randomStringGenerator;

import static ru.yandex.randomStringGenerator.letterSubjectValue;

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

    @FindBy(xpath = ".//div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField tst-field-to']//div[@class = 'composeYabbles']")
    private WebElement addresser;

    @FindBy(xpath = ".//input[@name = 'subject']")
    private WebElement letterSubject;

    @FindBy(xpath = ".//input[@class = 'ComposeAttachFileButton-FileInput' and @type='file']")
    private WebElement uploadFile;

    @FindBy(xpath = ".//button[@class = 'control button2 button2_view_default button2_tone_default button2_size_l button2_theme_action button2_pin_circle-circle ComposeControlPanelButton-Button ComposeControlPanelButton-Button_action']")
    private WebElement sendLetter;

    @FindBy(xpath = ".//*[@id=\"cke_1_contents\"]/div")
    private WebElement textLetter;

    @FindBy(xpath = ".//a[@class = 'control link link_theme_normal ComposeDoneScreen-Link' and @href = '#inbox']")
    private WebElement returnToInBox;

    @FindBy(xpath = ".//span [@class = 'mail-ComposeButton-Refresh js-main-action-refresh ns-action']")
    private WebElement refreshMail;


    @FindBy(xpath = ".//span [@class= 'mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']/span")
    private WebElement LetterSubjectInBox;

    //@FindBy(xpath = ".//span [@title = '" + sad + "']")
    //private WebElement lastLetterSubjectInBox;


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
    public String checkWindowNewLetter(){
        try {
            getText(uploadFile);
        } catch (NoSuchElementException e) {
            return "Форма не найдена";
        }
        return "Форма найдена";
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
     * В этом методе пишем текст письма
     */

    @Step("Пишем текст письма")
    public void writeTextLetter (String text) {setText(textLetter, text);}


    /**
     *  В этом методе загружаем файл к письму
     */

    @Step("Загружаем файл к письму")
    public void setUploadFile() {
        setText(uploadFile,"C:\\dowonlad\\README.txt");
    }

    /**
     * В этом методе нажимаем "Отправить"
     */

    @Step("Нажимаем \"Отправить\"")
    public void clickSendLetter() {
        click(sendLetter);
    }

    /**
     * В этом методе нажимаем "Вернуться во входящие"
     */

    @Step("Нажимаем \"Вернуться во входящие\"")
    public void clickReturnToInBox() {
        click(returnToInBox);
    }

    /**
     * В этом методе обновляем почтовый ящик
     */

    @Step("Нажимаем \"Проверить, есть ли новые письма \"")
    public void clickRefreshGmail() {click(refreshMail);}

    /**
     *  В этом методе проверяем соответствие темы письма
     */

    @Step("Проверяем тему письма")
    public String checkLetterSubject() {
        String result;
        System.out.println(getText(LetterSubjectInBox) + " тема письма в почте");
        System.out.println(letterSubjectValue + " сгенерированное значение");

        if (getText(LetterSubjectInBox).equals(letterSubjectValue)) {
            result = "Тема письма соответствует";
        }
        else
            result = "Тема письма не соответствует";

        return result;
    }

    @Step("Кликаем")
    public void clickElement(String name) {
        String xphas = ".//span[@title = '" + name + "']";
        click(xphas);
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
