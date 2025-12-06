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
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PageObjectMetaFirstPageOrder {
    private WebDriver driver;
    WebElement element;

    // 1-я страница Заказа
    // Локатор для "верхней" кнопки "Заказать" Главной страницы
    private final By upperOrderButton = By.xpath(".//*[@class='Button_Button__ra12g']");
    // Локатор для "нижней" кнопки "Заказать" Главной страницы
    private final By lowerOrderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    // Локатор заполнения поля Имя в Заказе
    private final By nameLocator = By.xpath(".//*[@placeholder='* Имя']");
    // Локатор заполнения поля Фамилия в Заказе
    private final By surnameLocator = By.xpath(".//*[@placeholder='* Фамилия']");
    // Локатор заполнения поля Адрес в Заказе
    private final By adressLocator = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор заполнения поля Метро в Заказе
    private final By metroStationLocator = By.xpath(".//*[@placeholder='* Станция метро']");
    // Локатор заполнения поля Телефон в Заказе
    private final By phoneNumberLocator = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    // Локатор кнопки Далее в Заказе для перехода на 2-ю страницу заполнения Заказа
    private final By buttonNextFromFirstPageLocator = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    @BeforeEach
    public void setUp() {

        driver = new FirefoxDriver();
        // driver = new ChromeDriver();

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

    public PageObjectMetaFirstPageOrder(WebDriver driver) {
        this.driver = driver;
    }

    // Метод кликает на "верхнюю" кнопку "Заказать" Главной страницы
    public void clickUpperOrderButton() {
        driver.findElement(upperOrderButton).click();
    }

    // Метод прокрутки до "нижней" кнопки "Заказать" Главной страницы
    public void scrollToLowerOrderButton() {
        element = driver.findElement(By.xpath(".//*[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Метод кликает на "нижнюю" кнопку "Заказать" Главной страницы
    public void clickLowerOrderButton() {
        driver.findElement(lowerOrderButton).click();
    }

    // Метод заполнения поля Имя в Заказе
    public void fillNameInOrder(String name) {
        driver.findElement(nameLocator).sendKeys(name);
    }

    // Метод заполнения поля Фамилия в Заказе
    public void fillSurnameInOrder(String surname) {
        driver.findElement(surnameLocator).sendKeys(surname);
    }

    // Метод заполнения поля Адрес в Заказе
    public void fillAdressOrder(String adress) {
        driver.findElement(adressLocator).sendKeys(adress);
    }

    // Метод заполнения поля Метро в Заказе
    public void fillMetroOrder(String metroStation) {
        driver.findElement(metroStationLocator).click();
        driver.findElement(By.xpath(".//*[@class='select-search__row'][2]")).click();
    }

    // Метод заполнения поля Телефон в Заказе
    public void fillPhoneNumberOrder(String phoneNumber) {
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
    }

    // Метод нажатия кнопки Далее в Заказе для перехода на 2-ю страницу заполнения Заказа
    public void fillbuttonNextFromFirstPage() {
        driver.findElement(buttonNextFromFirstPageLocator).click();
    }


    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Верхней кнопки Заказать
    public void fillPageObjectFirstPageOrderUpperButtonOrder(
            String name,
            String surname,
            String adress,
            String metroStation,
            String phoneNumber) {
        clickUpperOrderButton();
        fillNameInOrder(name);
        fillSurnameInOrder(surname);
        fillAdressOrder(adress);
        fillMetroOrder(metroStation);
        fillPhoneNumberOrder(phoneNumber);
        fillbuttonNextFromFirstPage();
    }

    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Верхней кнопки Заказать
    public void fillPageObjectFirstPageOrderLowerButtonOrder(
            String name,
            String surname,
            String adress,
            String metroStation,
            String phoneNumber) {
        clickUpperOrderButton();
        fillNameInOrder(name);
        fillSurnameInOrder(surname);
        fillAdressOrder(adress);
        fillMetroOrder(metroStation);
        fillPhoneNumberOrder(phoneNumber);
        fillbuttonNextFromFirstPage();
    }
}