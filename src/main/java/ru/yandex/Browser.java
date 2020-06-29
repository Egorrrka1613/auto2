package ru.yandex;

import org.openqa.selenium.WebDriver;

public class Browser extends Base{
    public Browser(WebDriver driver) {
        super(driver);
    }

    public void maximaze() {
        getDriver().manage().window().maximize();
    }
    public void goToURL (String url) {
        getDriver().get(url);
    }
}