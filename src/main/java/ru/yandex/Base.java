package ru.yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    private WebDriver driver;
    private int waitTime = 5;
    private int waitTimeTest = 5;
    private int waitTimeToSubjectTest = 200;

    public WebDriver getDriver() { return driver; }

    public Base (final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void click(WebElement element) {
        waitVisibilityElement(element);
        element.click();
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
     * Переопределил метод waitVisibilityElement
     * @param xpath
     * @return
     */
    public boolean waitVisibilityElement (String xpath) {
        WebDriverWait we = new WebDriverWait(driver, waitTimeTest, waitTimeToSubjectTest);
        try {
            //we.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath)))); Код, который дал Коля
            we.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));   // Альтернатива из интернета
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * Переопределил метод click
     * @param xpath
     */
    public void click(String xpath) {
        waitVisibilityElement(xpath);
        getDriver().findElement(By.xpath(xpath)).click();
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

    public void setText(WebElement element, String text) {
        waitVisibilityElement(element);
        element.sendKeys(text);
    }
}
