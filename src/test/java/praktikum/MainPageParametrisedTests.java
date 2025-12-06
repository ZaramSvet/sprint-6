package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageParametrisedTests {

    private WebDriver driver;
    WebElement element;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @ParameterizedTest
    @MethodSource("credentialsProvider")
    void testAllSectionQuestionAboutMain(String expectText, String locator, String locator2) throws Exception {
        WebElement element = driver.findElement(By.xpath(".//*[text()='Сколько это стоит? И как оплатить?']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

        driver.findElement(By.xpath(locator2)).click();
        String actualLocator = driver.findElement(By.xpath(locator)).getText();
        assertEquals(expectText, actualLocator);
    }

    private static Stream<Arguments> credentialsProvider() {
        return Stream.of(
                Arguments.of("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", ".//*[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']", ".//*[text()='Сколько это стоит? И как оплатить?']"),
                Arguments.of("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", ".//*[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']", ".//*[text()='Хочу сразу несколько самокатов! Так можно?']"),
                Arguments.of("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", ".//*[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']", ".//*[text()='Как рассчитывается время аренды?']"),
                Arguments.of("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", ".//*[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']", ".//*[text()='Можно ли заказать самокат прямо на сегодня?']"),
                Arguments.of("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", ".//*[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']", ".//*[text()='Можно ли продлить заказ или вернуть самокат раньше?']"),
                Arguments.of("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", ".//*[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']", ".//*[text()='Вы привозите зарядку вместе с самокатом?']"),
                Arguments.of("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", ".//*[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']", ".//*[text()='Можно ли отменить заказ?']"),
                Arguments.of("Да, обязательно. Всем самокатов! И Москве, и Московской области.", ".//*[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']", ".//*[text()='Я жизу за МКАДом, привезёте?']")
        );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}