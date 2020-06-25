package testClass.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.yandex.pageObject.MailPageObject;
import testClass.ChromeBaseTest;

import static org.junit.Assert.*;
import org.junit.Assert;


public class AutorizationGmail extends ChromeBaseTest {

    @Test
    @Epic("Банк")
    @Feature("РБГ")
    @Story("Создание, просмотр и удаление банковской гарантии")
    @DisplayName("Создание, просмотр и удаление банковской гарантии")
    @Description("Создание, просмотр и удаление банковской гарантии")

    public void startTest() {
        toURL("https://mail.yandex.ru/?noretpath=1");
        MailPageObject test1 = new MailPageObject(getDriver());

        /*test1.setEnterText("Cat");
        test1.clickEngButton();
        test1.assertTranslateIsOk("кошка");
         */

    }
}
