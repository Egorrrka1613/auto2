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

import java.io.IOException;

import static ru.yandex.RandomStringGenerator.*;


public class AutorizationGmail extends ChromeBaseTest {

    @Test
    @Epic("Банк")
    @Feature("РБГ")
    @Story("Создание, просмотр и удаление банковской гарантии")
    @DisplayName("Создание, просмотр и удаление банковской гарантии")
    @Description("Создание, просмотр и удаление банковской гарантии")

    public void startTest() throws InterruptedException, IOException {
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
        test1.fileNewCreate();
        System.out.println("Создан файл аттача");
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
        test1.dowonladCheckAttach();
        test1.clickButtonSetting();
        System.out.println("Кликнули по \"Настройки\"");
        test1.clickPersonalDataAndSignature();
        System.out.println("Кликнули по \"Личные данные, подпись, портрет\"");
        test1.setSignatureField(signatureGenerateValue);
        System.out.println("Ввели новый текст подписи");
        test1.clickButtonAddSignature();
        System.out.println("Добавили новую подпись");
        test1.clickButtonToGmail();
        System.out.println("Вернулись из настроек в почтовый ящик");
        test1.clickWriteLetter();
        test1.checkWindowNewLetter();
        test1.setAddresser("testerawto@yandex.ru");
        letterSubject(); //Генерируем новую тему письма
        test1.setLetterSubject(letterSubjectValue);
        textLetterChoice(); //Генерируем новый текст письма
        test1.writeTextLetter(textLetterChoiceValue);











        Thread.sleep(3000);







        /*Thread.sleep(10000);

        test1.clickLoginField();
        test1.assertTranslateIsOk("кошка");
         */
    }
}