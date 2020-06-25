package ru.yandex.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.Base;

public class MailPageObject extends Base {

    public MailPageObject(WebDriver driver) {
        super(driver);
    }
    /*
    @FindBy(xpath = ".//div[@class = 'sl-wrap']//div[@role='button' and contains(.,'английский')]")
    private WebElement engBatton;

    @FindBy(xpath = ".//textarea[@id = 'source']")
    private WebElement enterText;

    @FindBy(xpath = ".//span[@class = 'tlid-translation translation']/span")
    private WebElement enterTranslate;

     */

    /**
     * В этом методе водим текст в поле для перевода
     * @param text
     */
    /*
    @Step("В этом методе водим текст в поле для перевода")
    public void setEnterText(String text) {
        setText(enterText, text);
    }

     */

    /**
     * Кликаем по кнопке "Английский" в блоке выбора языка для ввода данных.
     */
    /*
    @Step ("Кликаем по кнопке \"Английский\" в блоке выбора языка для ввода данных.")
    public void clickEngButton() {
        click(engBatton);
    }

     */

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
