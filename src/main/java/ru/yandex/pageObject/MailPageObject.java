package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;
import java.io.File;
import java.io.IOException;



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

    @FindBy(xpath = ".//div[@class = 'ns-view-container-desc mail-MessagesList js-messages-list']/div[1]/div/div[2]/div[1]/div[1]/div")
    private WebElement receiveLetter;

    @FindBy(xpath = ".//span[@class = 'mail-Message-Toolbar-Subject-Wrapper']")
    private WebElement letterSubjectValueInBox;

    @FindBy(xpath = ".//div[@class = 'js-message-body-content mail-Message-Body-Content']/div[1]")
    private WebElement textLetterInBox;

    @FindBy(xpath = ".//a[@class = 'mail-File-Actions-Item js-skip-click-message-item js-attachment-actions-item js-download-attachment mail-File-Actions-Item_secondary']")
    private WebElement buttonDowonladAttach;

    @FindBy (xpath = ".//button [@class = 'control button2 button2_view_classic button2_theme_default mail-GhostButton mail-SettingsButton']")
    private WebElement buttonSetting;

    @FindBy(xpath = ".//a [@class = 'mail-SettingsPopup__menu-item' and @href = '#setup/sender']")
    private WebElement personalDataAndSignature;

    @FindBy(xpath = ".//div [@class ='cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr']")
    private WebElement signatureField;

    @FindBy(xpath = ".//span [@class = 'ui-button-text']/..")
    private WebElement buttonAddSignature;

    @FindBy(xpath = "//a [@class = 'b-setup-title__link' and @href = '#inbox']")
    private WebElement buttonToGmail;




    /*
    @FindBy(xpath = ".//span[@class = 'mail-MessageSnippet-Item mail-MessageSnippet-Item_sender js-message-snippet-sender']")
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
    public void checkWindowNewLetter(){
        try {
            getText(windowNewLetter);
        } catch (NoSuchElementException e) {
            System.out.println("Форма не найдена");
        }
        System.out.println("Форма найдена");
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
     * В этом методе создаем файл, для прикрепления к письму
     */

    @Step("Создаем файл для прикрепления к письму")
    public void fileNewCreate() {
        try {
            new File("C:/dowonlad/autoTest/attach/file.txt").createNewFile();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *  В этом методе загружаем файл к письму, после загрузки удаляем файл
     */

    @Step("Загружаем файл к письму")
    public void setUploadFile() {
        setText(uploadFile,"C:\\dowonlad\\autoTest\\attach\\file.txt");

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
     *  В этом методе кликаем по письму с указанной темой
     */

    @Step("Проверяем наличие письма, с указанной темой")
    public void findLetterSubject(String subjectLetter) {
        try {
            String xpath = ".//span[@title = '" + subjectLetter + "']";
            click(xpath);
            //.//span[@title = '163fa291-0e2a-4749-9494-29f0ce7b70bb'] --- xpath для проверки темы
        }
        catch (UnreachableBrowserException e) {
            System.out.println("Письмо с указанной темой отсутствует");
        }
        System.out.println("Письмо с указанной темой присутствует");
    }

    /**
     * В этом методе открываем принятое письмо
     */

    @Step ("Открываем принятое письмо")
    public void clickReceiveLetter() {

        click(receiveLetter);
    }

    /**
     * Метод для сравнения темы писем
     */

    @Step ("Сравнение темм писем")
    public void compareLetterSubject (String text) {
        String letterSubjectValueInBoxStr = getText(letterSubjectValueInBox);
        if (text.equals(letterSubjectValueInBoxStr))
            System.out.println("Темы сравниваемых писем равны");
        else System.out.println("Темы сравниваемых писем не равны");

    }

    /**
     * Метод для сравнения текста писем
     */

    @Step("Сравнение текста писем")
    public void compareLetterText (String text) {
        String textLetterInBoxStr = getText(textLetterInBox);
        if (text.equals(textLetterInBoxStr))
            System.out.println("Тексты сравниваемых писем равны");
        else
            System.out.println("Тексты сравниваемых писем различаются");
    }

    /**
     * Метод для скачивания, проверки наличия и удаления аттачей
     */

    @Step("Скачиваем аттач письма, проверяем что он сохранился в директорию загрузки, в случае, если файл найден, удаляем созданный и скачанный файлы")
    public void dowonladCheckAttach() throws InterruptedException {
        click(buttonDowonladAttach);
        Thread.sleep(3000);
        System.out.println("Файл скачан");

        if (new File("C:/Users/Егор/Downloads/file.txt").isFile()) {
            System.out.println("Файл присутствует в директории загрузки");
            new File("C:/Users/Егор/Downloads/file.txt").delete();
            new File("C:/dowonlad/autoTest/attach/file.txt").delete();
        }
        else
            System.out.println("Файл отсутствует в директории загрузки");
    }

    /**
     * В этом методе кликаем по кнопке "Настройки"
     */

    @Step("Кликаем по кнопке настройки")
    public void clickButtonSetting() {
        click(buttonSetting);
    }

    /**
     * В этом методе клаикаем по кнопке "Персональные данные, подпись, портрет"
     */

    @Step("Кликаем по копке \"Персональые данные, подпись, портрет\"")
    public void clickPersonalDataAndSignature() {click(personalDataAndSignature);}

    /**
     * В этом методе вводим новую подпись
     */

    @Step("Вводим в поле подписи переданное значение")
    public void setSignatureField (String text) {
        setText(signatureField, text);
    }

    /**
     * В этом методе кликаем по кнопке "Добавить подпись"
     */

    @Step("Кликаем по конпке \"Добавить подпись\"")
    public void clickButtonAddSignature() {click(buttonAddSignature);}

    /**
     * В этом методе возвращаемся в почту, после смены подписи
     */

    @Step("Переходим в почту, из меню настроек")
    public void clickButtonToGmail() {click(buttonToGmail);}





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
