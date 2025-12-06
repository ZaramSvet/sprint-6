package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

public class PageObjectMetaMainPage {

    WebDriver driver;

    // Значение переменной Вопросы о важном
    String assertTextImportantQuestions = "Вопросы о важном";
    // Значение первой переменной (вопроса - Сколько это стоит? И как оплатить?) в разделе Вопросы о важном
    String assertTextImportantQuestionsFromFirstQuestion = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    // Значение второй переменной (вопроса - Хочу сразу несколько самокатов! Так можно?) в разделе Вопросы о важном
    String assertTextImportantQuestionsFromSecondQuestion = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    // Значение третьей переменной (вопроса - Как рассчитывается время аренды?) в разделе Вопросы о важном
    String assertRorExampleYouRentScooterInMayQuestion = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    // Значение четвёртой переменной (вопроса - Можно ли заказать самокат прямо на сегодня?) в разделе Вопросы о важном
    String assertonlyFromNextDayLocatorQuestion = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    // Значение пятой переменной (вопроса - Можно ли продлить заказ или вернуть самокат раньше?) в разделе Вопросы о важном
    String assertNotYetLocatorQuestion = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    // Значение шестой переменной (вопроса - Можно ли продлить заказ или вернуть самокат раньше?) в разделе Вопросы о важном
    String assertScooterHaveFullChargeLocatorQuestion = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    // Значение седьмой переменной (вопроса - 	"Можно ли отменить заказ?") в разделе Вопросы о важном
    String assertYesYouCanIcancelOrderLocatorQuestion = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    // Значение восьмой переменной (вопроса - 	"Я живу за МКАДом, привезёте?") в разделе Вопросы о важном
    String assertYesWeDeliveScooterBehindeMkadQuestion = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    // Главная страница
    // Локатор для раздела "Вопросы о важном"
    public final By importantQuestionsLocator = By.xpath(".//*[@class='Home_FourPart__1uthg']//*[text()='Вопросы о важном']");
    // Локатор для раздела "Сколько это стоит? И как оплатить?"
    public final By howMuchCostLocator = By.xpath(".//*[text()='Сколько это стоит? И как оплатить?']");
    // Локатор для раздела "Сутки — 400 рублей. Оплата курьеру — наличными или картой."
    public final By priceHowMuchCostLocator = By.xpath(".//*[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    // Локатор для раздела "Хочу сразу несколько самокатов! Так можно?"
    public final By iWantSeveralScootersCanILocator = By.xpath(".//*[text()='Хочу сразу несколько самокатов! Так можно?']");
    // Локатор для раздела "Пока что у нас так: один заказ — один самокат..."
    public final By oneOrderOneScooterLocator = By.xpath(".//*[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");
    // Локатор для раздела "Как рассчитывается время аренды?"
    public final By howRentTimeCalculateLocator = By.xpath(".//*[text()='Как рассчитывается время аренды?']");
    // Локатор для раздела "Допустим, вы оформляете заказ на 8 мая..."
    public final By forExampleYouRentScooterInMayLocator = By.xpath(".//*[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");
    // Локатор для раздела "Можно ли заказать самокат прямо на сегодня?"
    public final By canIrentscooterRigttNowLocator = By.xpath(".//*[text()='Можно ли заказать самокат прямо на сегодня?']");
    // Локатор для раздела "Только начиная с завтрашнего дня. Но скоро станем расторопнее"
    public final By onlyFromNextDayLocator = By.xpath(".//*[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");
    // Локатор для раздела "Только начиная с завтрашнего дня. Но скоро станем расторопнее"
    public final By canIextendRentOrReturnScooterEarlyLocator = By.xpath(".//*[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    // Локатор для раздела "Пока что нет!..."
    public final By notYetLocator = By.xpath(".//*[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");
    // Локатор для раздела "Вы привозите зарядку вместе с самокатом?"
    public final By doYouDeliverChargeWithScooterLocator = By.xpath(".//*[text()='Вы привозите зарядку вместе с самокатом?']");
    // Локатор для раздела "Самокат приезжает к вам с полной зарядкой"
    public final By scooterHaveFullChargeLocator = By.xpath(".//*[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");
    // Локатор для раздела "Можно ли отменить заказ?"
    public final By canIcancelOrderLocator = By.xpath(".//*[text()='Можно ли отменить заказ?']");
    // Локатор для раздела "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."
    public final By yesYouCanIcancelOrderLocator = By.xpath(".//*[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");
    // Локатор для раздела "Я живу за МКАДом, привезёте?"
    public final By iliveBehindeMkadLocator = By.xpath(".//*[text()='Я жизу за МКАДом, привезёте?']");
    // Локатор для раздела "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    public final By yesWeDeliveScooterBehindeMkadLocator = By.xpath(".//*[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");


    public PageObjectMetaMainPage(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
// Открыть окно браузера полностью на весь экран
        driver.manage().window().maximize();
// Войти на Главную страницу
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @AfterEach
    public void tearDown() {
// Закрыть окно браузера
        driver.quit();
    }
}