package praktikum;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static praktikum.Answers.*;

public class FAQTest {
    private WebDriver driver;

    @Test
    public void FAQCorrectAnswerText() {
        // Создать веб-драйвер для Google Chrome
        driver = new ChromeDriver();
        // Открыть страницу домашнюю Яндекс Самокат
        driver.get("https://qa-scooter.praktikum-services.ru");
        // Проскролить страницу до появления таблицы с вопросами
        WebElement tableFAQ = driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", tableFAQ);
        // Создать объект класса с домашней страницей
        HomePage objHomePage = new HomePage(driver);
        // Проверка соответствия текста ответа с ожидаемым
        objHomePage.clickQuestionCost();
        objHomePage.isCorrectText(objHomePage.getAnswerCost(), answerCostText);
        objHomePage.clickQuestionOneScooter();
        objHomePage.isCorrectText(objHomePage.getAnswerOneScooter(), answerOneScooterText);
        objHomePage.clickQuestionTime();
        objHomePage.isCorrectText(objHomePage.getAnswerTime(), answerTimeText);
        objHomePage.clickQuestionTomorrow();
        objHomePage.isCorrectText(objHomePage.getAnswerTomorrow(), answerTomorrowText);
        objHomePage.clickQuestionCall();
        objHomePage.isCorrectText(objHomePage.getAnswerCall(), answerCallText);
        objHomePage.clickQuestionCharging();
        objHomePage.isCorrectText(objHomePage.getAnswerCharging(), answerChargingText);
        objHomePage.clickQuestionFine();
        objHomePage.isCorrectText(objHomePage.getAnswerFine(), answerFineText);
        objHomePage.clickQuestionMkad();
        objHomePage.isCorrectText(objHomePage.getAnswerMkad(), answerMkadText);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

