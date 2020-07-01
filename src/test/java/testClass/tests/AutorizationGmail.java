package testClass.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.pageObject.MailPageObject;
import testClass.ChromeBaseTest;
import static ru.yandex.randomStringGenerator.generateString;

import static org.junit.Assert.*;
import org.junit.Assert;


public class AutorizationGmail extends ChromeBaseTest {

    @Test
    @Epic("Банк")
    @Feature("РБГ")
    @Story("Создание, просмотр и удаление банковской гарантии")
    @DisplayName("Создание, просмотр и удаление банковской гарантии")
    @Description("Создание, просмотр и удаление банковской гарантии")

    public void startTest() throws InterruptedException {
        toURL("https://mail.yandex.ru/?noretpath=1");
        MailPageObject test1 = new MailPageObject(getDriver());
        test1.clickComeGmail();
        test1.setEnterLogin("testerawto");
        test1.clickEnterLoginComplate();
        test1.setEnterPassword("010203QAZ");
        test1.clickEnterPasswordComplate();
        test1.clickWriteLetter();
        test1.checkWindowNewLetter();
        System.out.println(test1.checkWindowNewLetter());
        test1.setAddresser("testerawto@yandex.ru");
        test1.setLetterSubject("Тестовое задание");
        test1.writeTextLetter(generateString());
        test1.setUploadFile();
        test1.clickSendLetter();
        test1.clickReturnToInBox();


        Thread.sleep(20000);
/*
        test1.clickLoginField();
        test1.assertTranslateIsOk("кошка");
         */
    }
}