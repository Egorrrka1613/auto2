package testClass;

import io.qameta.allure.Step;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.google.Browser;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

public class ChromeBaseTest {
    protected WebDriver driver;
    @Rule
    public TestWatcher watcher;

    {
        watcher = new TestWatcher() {
            @Step("Действия перед началом теста")
            @Override
            protected void starting(final Description description) {
                ChromeOptions options = new ChromeOptions();
                DesiredCapabilities ds = DesiredCapabilities.chrome();
                ds.setCapability(ChromeOptions.CAPABILITY, options);
                URL hub = null;
                try {
                    hub = new URL("http://localhost:4445/wd/hub");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                driver = new RemoteWebDriver(hub, ds);
            }

            @Step("Действия после окончания теста")
            @Override
            protected void finished(final Description description) {
                driver.quit();
                if (driver != null) {
                    driver.quit();
                }
            }

            @Override
            protected void succeeded(final Description description) {

            }

            @Override
            protected void failed(final Throwable e, final Description description) {

            }

        };
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void toURL(String url) {
        Browser bro1 = new Browser(driver);

        bro1.goToURL(url);
        bro1.maximaze();
    }
}
