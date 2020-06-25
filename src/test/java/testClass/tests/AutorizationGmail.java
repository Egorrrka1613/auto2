package testClass.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.google.pageObject.TranslatePageObject;
import testClass.ChromeBaseTest;



public class AutorizationGmail extends ChromeBaseTest {
    @Test
    @Epic("Банк")
    @Feature("РБГ")
    @Story("Создание, просмотр и удаление банковской гарантии")
    @DisplayName("Создание, просмотр и удаление банковской гарантии")
    @Description("Создание, просмотр и удаление банковской гарантии")
    public void startTest() {
        toURL("https://translate.google.com/?hl=ru&tab=TT");
        TranslatePageObject test1 = new TranslatePageObject(getDriver());
        test1.setEnterText("Cat");
        test1.clickEngButton();
        test1.assertTranslateIsOk("кошка");


    }
}
