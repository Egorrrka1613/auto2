package testClass.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.pageObject.AutorizationMailPageObject;
import ru.yandex.pageObject.MailBoxPageObject;
import ru.yandex.pageObject.SettingMailBobPageObject;

import testClass.ChromeBaseTest;

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
        AutorizationMailPageObject test1Autorization = new AutorizationMailPageObject(getDriver());
        MailBoxPageObject test1Mail = new MailBoxPageObject(getDriver());
        SettingMailBobPageObject test1Settin = new SettingMailBobPageObject(getDriver());
        test1Autorization.clickComeGmail();
        test1Autorization.setEnterLogin("testerawto");
        test1Autorization.clickEnterLoginComplate();
        test1Autorization.setEnterPassword("010203QAZ");
        test1Autorization.clickEnterPasswordComplate();
        System.out.println("Авторизация прошла");
        test1Mail.clickWriteLetter();
        test1Mail.checkWindowNewLetter();
        test1Mail.setAddresser("testerawto@yandex.ru");
        String letterSubjectValue1 = letterSubject(); // Переменная с темой первого письма
        test1Mail.setLetterSubject(letterSubjectValue1);
        String textLetterChoiceValue1 = textLetterChoice(); // Переменная с текстом первого письма
        test1Mail.writeTextLetter(textLetterChoiceValue1);
        //test1Autorization.fileNewCreate();
        //System.out.println("Создан файл аттача");
        //test1Autorization.setUploadFile();
        //Thread.sleep(3000); //Ожидание для загрузки файла
        test1Mail.clickSendLetter();
        test1Mail.clickReturnToInBox();
        test1Mail.clickRefreshGmail();
        test1Mail.findLetterSubject(letterSubjectValue1);
        test1Mail.clickReceiveLetter();
        test1Mail.compareLetterSubject(letterSubjectValue1);
        test1Mail.compareLetterText(textLetterChoiceValue1);
        //test1Autorization.dowonladCheckAttach();
        //test1Autorization.deleteDowonladAttach();
        //test1Autorization.deleteCreateAttach();
        //System.out.println("Удалили файлы атачей");
        test1Mail.clickButtonSetting();
        test1Mail.clickPersonalDataAndSignature();
        String signatureGenerateValue1 = signatureGenerate(); // Переменая с подписью письма
        test1Mail.setSignatureField(signatureGenerateValue1);
        test1Mail.clickButtonAddSignature();
        test1Mail.clickButtonToGmail();
        test1Mail.clickWriteLetter();
        test1Mail.checkWindowNewLetter();
        test1Mail.setAddresser("testerawto@yandex.ru");
        String letterSubjectValue2 = letterSubject();; //Генерируем вторую тему письма и записываем в новую переменную
        test1Mail.setLetterSubject(letterSubjectValue2);
        String textLetterChoiceValue2 = textLetterChoice(); //Генерируем текст второго письма
        test1Mail.writeTextLetter(textLetterChoiceValue2);
        //test1Autorization.fileNewCreate();
        //System.out.println("Создан файл аттача");
        //test1Autorization.setUploadFile();
        //Thread.sleep(3000);
        //test1Autorization.deleteCreateAttach();
        test1Mail.clickSignList();
        test1Mail.findSignLetter(signatureGenerateValue1);
        test1Mail.clickSendLetter();
        test1Mail.clickReturnToInBox();
        test1Mail.clickRefreshGmail();
        test1Mail.findLetterSubject(letterSubjectValue2);
        test1Mail.clickReceiveLetter();
        test1Mail.compareLetterSubject(letterSubjectValue2);
        test1Mail.compareLetterText(textLetterChoiceValue2);
        Assert.assertTrue(driver.findElement(By.xpath(".//div[@class = 'js-message-body-content mail-Message-Body-Content']/div[4]")).getText().contains(signatureGenerateValue1));
        test1Mail.clickInboxLetterButton();
        test1Mail.clickButtonChooseAllLetters();
        test1Mail.clickButtonDeleteLetter();
        test1Mail.checkExistAnyLetter();

    }
}