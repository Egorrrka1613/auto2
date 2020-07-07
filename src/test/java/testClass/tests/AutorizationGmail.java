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

import static ru.yandex.RandomStringGenerator.letterSubjectValue;
import static ru.yandex.RandomStringGenerator.textLetterChoiceValue;




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
        System.out.println("Авторизация прошла");
        test1.clickWriteLetter();
        test1.checkWindowNewLetter();
        test1.setAddresser("testerawto@yandex.ru");
        test1.setLetterSubject(letterSubjectValue);
        test1.writeTextLetter(textLetterChoiceValue);
        test1.setUploadFile();
        Thread.sleep(3000);
        test1.clickSendLetter();
        System.out.println("Отправили письмо");
        test1.clickReturnToInBox();
        System.out.println("Вернулись во входящие");
        test1.clickRefreshGmail();
        System.out.println("Почтовый ящик обновлен");
        test1.findLetterSubject(letterSubjectValue);
        System.out.println("Новое письмо найдено");
        test1.clickReceiveLetter();
        System.out.println("Переход во входящее письмо выполнен");
        test1.compareLetterSubject(letterSubjectValue);
        test1.compareLetterText(textLetterChoiceValue);
        test1.dowonladAttach();

        Thread.sleep(3000);







        /*Thread.sleep(10000);

        test1.clickLoginField();
        test1.assertTranslateIsOk("кошка");
         */
    }
}