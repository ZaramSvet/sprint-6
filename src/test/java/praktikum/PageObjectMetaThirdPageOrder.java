package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PageObjectMetaThirdPageOrder {
    private WebDriver driver;

    // 3-я страница Заказа (ассерты)
    // Значение переменной даты Когда привезти самокат в формате "день (цифра)" - "месяц (буквы)"
    String dateOfDeliverOrderInCheckPage = "25 августа";
    // Локатор поля Имя на финальной странице Заказа
    By checkNameLocator = By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[1]");
    // Локатор поля Фамилии на финальной странице Заказа
    By checkSurnameLocator = By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[2]");
    // Локатор поля Адрес на финальной странице Заказа
    By checkAdressLocator = By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[3]");
    // Локатор поля Метро на финальной странице Заказа
    By checkMetroStationLocator = By.xpath(".//*[@class='Track_Circle__3rizg']");
    // Локатор поля Телефон на финальной странице Заказа
    By checkPhoneNumberLocator= By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[5]");
    // Локатор поля Дата доставки на финальной странице Заказа
    By checkDateOfDeliverOrderLocator= By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[6]");
    // Локатор поля Срок аренды на финальной странице Заказа
    By checkRentalPeriodOfDeliverOrderLocator= By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[7]");
    // Локатор поля Цвет на финальной странице Заказа
    By checkBlackColorOfScooterLocator= By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[8]");
    // Локатор поля Комментарий на финальной странице Заказа
    By checkCommentForCourierOfDeliverOrderLocator = By.xpath("(.//*[@class=\"Track_Value__15eEX\"])[9]");



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

    public PageObjectMetaThirdPageOrder(WebDriver driver) {
        this.driver = driver;
    }


    // Метод проверки поля Имя на финальной странице Заказа
    public void assertCheckName(String name) {
        String actualCheckName = driver.findElement(checkNameLocator).getText();
        assertEquals(name, actualCheckName);
    }

    // Метод проверки поля Фамилии на финальной странице Заказа
    public void assertCheckSurname(String surname) {
        String actualCheckSurname = driver.findElement(checkSurnameLocator).getText();
        assertEquals(surname, actualCheckSurname);
    }

    // Метод проверки поля Адрес на финальной странице Заказа
    public void assertCheckAdress(String adress) {
        String actualCheckAdress = driver.findElement(checkAdressLocator).getText();
        assertEquals(adress, actualCheckAdress);
    }

    // Метод проверки поля Метро на финальной странице Заказа
    public void assertCheckMetroStation(String metroStation) {
        String actualCheckMetroStation = driver.findElement(checkMetroStationLocator).getText();
        assertNotEquals(metroStation, actualCheckMetroStation);
    }

    // Метод проверки поля Телефон на финальной странице Заказа
    public void assertCheckPhoneNumber(String phoneNumber) {
        String actualCheckPhoneNumber = driver.findElement(checkPhoneNumberLocator).getText();
        assertEquals(phoneNumber, actualCheckPhoneNumber);
    }

    // Метод проверки поля Дата доставки на финальной странице Заказа
    public void assertCheckDateOfDeliverOrder(String dateOfDeliverOrderInCheckPage) {
        String actualCheckDateOfDeliverOrder = driver.findElement(checkDateOfDeliverOrderLocator).getText();
        assertNotEquals(dateOfDeliverOrderInCheckPage, actualCheckDateOfDeliverOrder);
    }

    // Метод проверки поля Срок аренды на финальной странице Заказа
    public void assertCheckRentalPeriodOfDeliverOrder() {
        String actualCheckRentalPeriodOfDeliverOrder = driver.findElement(checkRentalPeriodOfDeliverOrderLocator).getText();
        assertEquals("сутки", actualCheckRentalPeriodOfDeliverOrder);
    }

    // Метод проверки поля Цвет на финальной странице Заказа
    public void assertCheckBlackColorOfScooter() {
        String actualCheckBlackColorOfScooter = driver.findElement(checkBlackColorOfScooterLocator).getText();
        assertEquals("чёрный жемчуг", actualCheckBlackColorOfScooter);
    }

    // Метод проверки поля Комментарий на финальной странице Заказа
    public void assertCheckCommentForCourierOfDeliverOrder(String commentForCourierOfDeliverOrder) {
        String actualCheckCommentForCourierOfDeliverOrder = driver.findElement(checkCommentForCourierOfDeliverOrderLocator).getText();
        assertEquals(commentForCourierOfDeliverOrder, actualCheckCommentForCourierOfDeliverOrder);
    }

    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Верхней кнопки Заказать

    public void fillPageObjectThirdPageOrderUpperButtonOrder(String name, String surname, String adress, String metroStation, String phoneNumber, String dateOfDeliverOrder, String commentForCourierOfDeliverOrder) {
        assertCheckName(name);
        assertCheckSurname(surname);
        assertCheckAdress(adress);
        assertCheckMetroStation(metroStation);
        assertCheckPhoneNumber(phoneNumber);
        assertCheckDateOfDeliverOrder(dateOfDeliverOrderInCheckPage);
        assertCheckRentalPeriodOfDeliverOrder();
        assertCheckBlackColorOfScooter();
        assertCheckCommentForCourierOfDeliverOrder(commentForCourierOfDeliverOrder);
    }

    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Нижней кнопки Заказать
    public void fillPageObjectThirdPageOrderLowerButtonOrder(String name, String surname, String adress, String metroStation, String phoneNumber, String dateOfDeliverOrder, String commentForCourierOfDeliverOrder) {
        assertCheckName(name);
        assertCheckSurname(surname);
        assertCheckAdress(adress);
        assertCheckMetroStation(metroStation);
        assertCheckPhoneNumber(phoneNumber);
        assertCheckDateOfDeliverOrder(dateOfDeliverOrderInCheckPage);
        assertCheckRentalPeriodOfDeliverOrder();
        assertCheckBlackColorOfScooter();
        assertCheckCommentForCourierOfDeliverOrder(commentForCourierOfDeliverOrder);
    }
}