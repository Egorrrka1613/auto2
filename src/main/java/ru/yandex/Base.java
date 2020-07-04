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
    private int waitTime = 30;
    private int waitTimeToSubject = 30;
    private int waitTimeTimeout = 500;

    public WebDriver getDriver() { return driver; }

    public Base (final WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setText(WebElement element, String text) {
        waitVisibilityElement(element);
        element.sendKeys(text);
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
        WebDriverWait we = new WebDriverWait(driver, waitTime, waitTimeTimeout);
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
     * Переопределил метод click
     * Метод кликает по веб-элементу, переданному в хпасе
     * @param xpath
     */

    public void click(String xpath) {
        waitVisibilityElement(xpath);
        getDriver().findElement(By.xpath(xpath)).click();
    }

    /**
     * Переопределил метод waitVisibilityElement
     * @param xpath
     * @return
     */

    public boolean waitVisibilityElement (String xpath) {
        WebDriverWait we = new WebDriverWait(driver, waitTimeToSubject, waitTimeTimeout);

        try {
            //we.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));
            we.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))); //visibilityOf(driver.findElement(By.xpath(xpath))));
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

    public String getText (WebElement element) {
        waitVisibilityElement(element);
        return element.getText();
    }
}
