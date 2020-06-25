package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    private WebDriver driver;
    private int waitTime = 3;

    public WebDriver getDriver() { return driver; }
    public Base (final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        waitVisibilityElement(element);
        element.click();
    }

    public void setText(WebElement element, String text) {
        waitVisibilityElement(element);
        element.sendKeys(text);
    }

    /**
     * Метод ожидания видимости элемента
     * @param element
     * @return
     */
    public boolean waitVisibilityElement (WebElement element) {
        WebDriverWait we = new WebDriverWait(driver, waitTime);
        try {
            we.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Метод забирвет текст из элемента.
     * @param element
     * @return
     */

    public String getText(WebElement element) {
        waitVisibilityElement(element);
        return element.getText();
    }
}
