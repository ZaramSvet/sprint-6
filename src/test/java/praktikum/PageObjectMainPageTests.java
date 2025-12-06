package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageObjectMainPageTests {

    WebDriver driver;
    PageObjectMetaMainPage pageObjectMetaMainPage = new PageObjectMetaMainPage(driver);


    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
// Открыть окно браузера полностью на весь экран
        driver.manage().window().maximize();
// Войти на Главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void testSectionQuestionAboutMain() {
        WebElement element = driver.findElement(pageObjectMetaMainPage.importantQuestionsLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        String actualResult = driver.findElement(pageObjectMetaMainPage.importantQuestionsLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertTextImportantQuestions, actualResult);
    }

    @Test
    public void testSectionHowMuchCost() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.howMuchCostLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.howMuchCostLocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.priceHowMuchCostLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertTextImportantQuestionsFromFirstQuestion, actualResult);
    }


    @Test
    public void testIWantSeveralScootersCanI() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.iWantSeveralScootersCanILocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.iWantSeveralScootersCanILocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.oneOrderOneScooterLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertTextImportantQuestionsFromSecondQuestion, actualResult);
    }

    @Test
    public void testHowRentTimeCalculate() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.howRentTimeCalculateLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.howRentTimeCalculateLocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.forExampleYouRentScooterInMayLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertRorExampleYouRentScooterInMayQuestion, actualResult);
    }

    @Test
    public void testCanIRentScooterRightNow() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.canIrentscooterRigttNowLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.canIrentscooterRigttNowLocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.onlyFromNextDayLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertonlyFromNextDayLocatorQuestion, actualResult);
    }

    @Test
    public void testCanIextendRentOrReturnScooterEarly() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.canIextendRentOrReturnScooterEarlyLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.canIextendRentOrReturnScooterEarlyLocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.notYetLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertNotYetLocatorQuestion, actualResult);
    }

    @Test
    public void testDoYouDeliverChargeWithScooter() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.doYouDeliverChargeWithScooterLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.doYouDeliverChargeWithScooterLocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.scooterHaveFullChargeLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertScooterHaveFullChargeLocatorQuestion, actualResult);
    }

    @Test
    public void testCanIcancelOrder() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.canIcancelOrderLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.canIcancelOrderLocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.yesYouCanIcancelOrderLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertYesYouCanIcancelOrderLocatorQuestion, actualResult);
    }

    @Test
    public void testIliveBehindeMkad() {
// Прокрутить страницу до искомого элемента
        WebElement element = driver.findElement(pageObjectMetaMainPage.iliveBehindeMkadLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(pageObjectMetaMainPage.iliveBehindeMkadLocator).click();
        String actualResult = driver.findElement(pageObjectMetaMainPage.yesWeDeliveScooterBehindeMkadLocator).getText();
        assertEquals(pageObjectMetaMainPage.assertYesWeDeliveScooterBehindeMkadQuestion, actualResult);
    }


    @AfterEach
    public void tearDown() {
// Закрыть окно браузера
        driver.quit();
    }
}