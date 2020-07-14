package testClass.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.pageObject.MailPageObject;
import testClass.ChromeBaseTest;

import static org.junit.Assert.assertTrue;
import static ru.yandex.RandomStringGenerator.*;





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
        String letterSubjectValue1 = letterSubject(); // Переменная с темой первого письма
        test1.setLetterSubject(letterSubjectValue1);
        String textLetterChoiceValue1 = textLetterChoice(); // Переменная с текстом первого письма
        test1.writeTextLetter(textLetterChoiceValue1);
        test1.fileNewCreate();
        System.out.println("Создан файл аттача");
        test1.setUploadFile();
        Thread.sleep(3000); //Ожидание для загрузки файла
        test1.clickSendLetter();
        System.out.println("Отправили письмо");

        test1.clickReturnToInBox();
        System.out.println("Вернулись во входящие");
        test1.clickRefreshGmail();
        System.out.println("Почтовый ящик обновлен");
        test1.findLetterSubject(letterSubjectValue1);
        System.out.println("Новое письмо найдено");
        test1.clickReceiveLetter();
        System.out.println("Переход во входящее письмо выполнен");
        test1.compareLetterSubject(letterSubjectValue1);
        test1.compareLetterText(textLetterChoiceValue1);
        test1.dowonladCheckAttach();
        test1.clickButtonSetting();
        System.out.println("Кликнули по \"Настройки\"");
        test1.clickPersonalDataAndSignature();
        System.out.println("Кликнули по \"Личные данные, подпись, портрет\"");
        String signatureGenerateValue1 = signatureGenerate(); // Переменая с подписью письма
        test1.setSignatureField(signatureGenerateValue1);
        System.out.println("Ввели новый текст подписи");
        test1.clickButtonAddSignature();
        System.out.println("Добавили новую подпись");
        test1.clickButtonToGmail();
        System.out.println("Вернулись из настроек в почтовый ящик");
        test1.clickWriteLetter();
        test1.checkWindowNewLetter();
        test1.setAddresser("testerawto@yandex.ru");
        String letterSubjectValue2 = letterSubject();; //Генерируем вторую тему письма и записываем в новую переменную
        test1.setLetterSubject(letterSubjectValue2);
        String textLetterChoiceValue2 = textLetterChoice(); //Генерируем текст второго письма
        test1.writeTextLetter(textLetterChoiceValue2);
        test1.fileNewCreate();
        System.out.println("Создан файл аттача");
        test1.setUploadFile();
        Thread.sleep(3000);
        test1.clickSignList();
        test1.findSignLetter(signatureGenerateValue1);
        test1.clickSendLetter();
        test1.clickReturnToInBox();
        System.out.println("Вернулись во входящие");
        test1.clickRefreshGmail();
        System.out.println("Почтовый ящик обновлен");
        test1.findLetterSubject(letterSubjectValue2);
        System.out.println("Второе письмо найдено");
        test1.clickReceiveLetter();
        System.out.println("Переход во входящее письмо выполнен");
        test1.compareLetterSubject(letterSubjectValue2);
        test1.compareLetterText(textLetterChoiceValue2);
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class = 'js-message-body-content mail-Message-Body-Content']/div[4]")).getText().contains(signatureGenerateValue1));
        test1.clickInboxLetterButton();
        test1.clickButtonChooseAllLetters();
        test1.clickButtonDeleteLetter();
        test1.clickConfirmDelete();
        test1.checkExistAnyLetter();
        System.out.println("Тест закончен");




























        /*Thread.sleep(10000);

        test1.clickLoginField();
        test1.assertTranslateIsOk("кошка");
         */
    }
}