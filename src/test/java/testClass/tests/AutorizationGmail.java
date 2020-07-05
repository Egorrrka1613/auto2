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

import static ru.yandex.randomStringGenerator.textLetterChoice;
import static ru.yandex.randomStringGenerator.letterSubjectValue;


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
        //test1.setLetterSubject("1c9e8db9-ad4c-45bd-86b6-a67493as");
        test1.setLetterSubject(letterSubjectValue);
        test1.writeTextLetter(textLetterChoice());
        test1.setUploadFile();
        test1.clickSendLetter();
        test1.clickReturnToInBox();
        test1.clickRefreshGmail();
        Thread.sleep(10000);
        //System.out.println(test1.checkLetterSubject());
        test1.clickElement(letterSubjectValue);





        /*Thread.sleep(10000);

        test1.clickLoginField();
        test1.assertTranslateIsOk("кошка");
         */
    }
}