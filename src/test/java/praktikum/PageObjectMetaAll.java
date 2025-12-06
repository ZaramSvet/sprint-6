package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PageObjectMetaAll {

    private WebDriver driver;
    WebElement element;

    // Значение переменной Имя
    String name = "Марк";
    // Значение переменной Фамилия
    String surname = "Петров";
    // Значение переменной Адрес
    String adress = "г. Москва, улица Новая д.3 кв.1";
    // Значение переменной Адрес
    String metroStation = "Черкизовская";
    // Значение переменной Телефон
    String phoneNumber = "+79101234567";
    // Значение переменной даты Когда привезти самокат
    String dateOfDeliverOrder = "25.08.2025";
    // Значение переменной Комментарий для курьера
    String commentForCourierOfDeliverOrder = "Вези аккуратно !";


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

    // 2-я страница Заказа
    // Локатор кнопки Когда привезти самокат
    private final By dateOfDeliverOrderLocator = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    // Локатор поля Про аренду
    private final By aboutOfRentLocator = By.xpath(".//*[text()='Про аренду']");
    // Локатор выбора варианта срока из списка Срок аренды (1 сутки)
    private final By periodOfRentLocator = By.xpath(".//*[@class='Dropdown-placeholder']");
    // Локатор выбора варианта Цвета самоката (чёрный цвет)
    private final By blackColorOfScooterLocator = By.xpath(".//*[@class='Checkbox_Label__3wxSf']");
    // Локатор поля Комментарий для курьера
    private final By commentForCourierOfDeliverOrderLocator = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    // Локатор кнопки Заказать на 2-й странице для оформления заказа
    private final By buttonGetOrderLocator = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Локатор кнопки Да из выпадающего окна "Хотите оформить заказ?"
    private final By confirmGetOrderLocator = By.xpath(".//*[text()='Да']");
    // Локатор окна с подтверждением оформления заказа "Заказ оформлен"
    private final By confirmOrderHasBeenPlacedLocator = By.xpath(".//*[contains(text(),'Заказ оформлен')]");
    // Локатор кнопки Посмотреть статус в окне с подтверждением оформления заказа "Заказ оформлен"
    private final By showStatusOfOrderLocator = By.xpath(".//*[contains(text(),'Посмотреть статус')]");

    // 3-я страница Заказа (ассерты)
    // Значение переменной даты Когда привезти самокат в формате "день (цифра)" - "месяц (буквы)"
    String dateOfDeliverOrderInCheckPage = "25 августа";
    // Локатор поля Имя на финальной странице Заказа
    private final By checkNameLocator = By.xpath(".//*[text()='Марк']");
    // Локатор поля Фамилии на финальной странице Заказа
    private final By checkSurnameLocator = By.xpath(".//*[text()='Петров']");
    // Локатор поля Адрес на финальной странице Заказа
    private final By checkAdressLocator = By.xpath(".//*[text()='г. Москва, улица Новая д.3 кв.1']");
    // Локатор поля Метро на финальной странице Заказа
    private final By checkMetroStationLocator = By.xpath(".//*[@class='Track_Circle__3rizg']");
    // Локатор поля Телефон на финальной странице Заказа
    private final By checkPhoneNumberLocator = By.xpath(".//*[text()='+79101234567']");
    // Локатор поля Дата доставки на финальной странице Заказа
    private final By checkDateOfDeliverOrderLocator = By.xpath(".//*[contains(text(), 'августа')]");
    // Локатор поля Срок аренды на финальной странице Заказа
    private final By checkRentalPeriodOfDeliverOrderLocator = By.xpath(".//*[text()='сутки']");
    // Локатор поля Цвет на финальной странице Заказа
    private final By checkBlackColorOfScooterLocator = By.xpath(".//*[text()='чёрный жемчуг']");
    // Локатор поля Комментарий на финальной странице Заказа
    private final By checkCommentForCourierOfDeliverOrderLocator = By.xpath(".//*[text()='Вези аккуратно !']");


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

    public PageObjectMetaAll(WebDriver driver) {
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

    // Метод заполнения поля Когда привезти самокат
    public void filldateOfDeliverOrder(String dateOfDeliverOrder) {
        driver.findElement(dateOfDeliverOrderLocator).sendKeys(dateOfDeliverOrder);
    }

    // Метод выбора через клик срока аренды из поля Срок аренды
    public void clickAboutOfRentLocator() {
        driver.findElement(aboutOfRentLocator).click();
    }

    // Метод выбора через клик срока аренды из выпадающего списка Срок аренды
    public void clickperiodOfRent() {
        driver.findElement(periodOfRentLocator).click();
        driver.findElement(By.xpath(".//*[@class='Dropdown-option'][1]")).click();
    }

    // Метод выбора через клик срока аренды из выпадающего списка Срок аренды
    public void clickblackColorOfScooter() {
        driver.findElement(blackColorOfScooterLocator).click();
    }

    // Метод заполнения поля Комментарий для курьера
    public void fillcommentForCourierOfDeliverOrder(String commentForCourierOfDeliverOrder) {
        driver.findElement(commentForCourierOfDeliverOrderLocator).sendKeys(commentForCourierOfDeliverOrder);
    }

    // Метод через клик нажатия на кнопку Заказать на 2-й странице для оформления заказа
    public void clickButtonGetOrder() {
        driver.findElement(buttonGetOrderLocator).click();
    }

    // Метод через клик нажатия на кнопку Да из выпадающего окна "Хотите оформить заказ?"
    public void clickButtonConfirmGetOrder() {
        driver.findElement(confirmGetOrderLocator).click();
    }

    // Метод ожидания
    public void waitSome() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    // Метод проверки появления окна с подтверждением оформления заказа "Заказ оформлен"
    public void confirmOrderHasBeenPlaced() {
        driver.findElement(confirmOrderHasBeenPlacedLocator).isEnabled();
    }

    // Метод нажатия на кнопку Посмотреть статус в окне с подтверждением оформления заказа "Заказ оформлен"
    public void clickButtonShowStatusOfOrder() {
        driver.findElement(showStatusOfOrderLocator).click();
    }

    // Метод проверки поля Имя на финальной странице Заказа
    public void assertCheckName() {
        String actualCheckName = driver.findElement(checkNameLocator).getText();
        assertEquals(name, actualCheckName);
    }

    // Метод проверки поля Фамилии на финальной странице Заказа
    public void assertCheckSurname() {
        String actualCheckSurname = driver.findElement(checkSurnameLocator).getText();
        assertEquals(surname, actualCheckSurname);
    }

    // Метод проверки поля Адрес на финальной странице Заказа
    public void assertCheckAdress() {
        String actualCheckAdress = driver.findElement(checkAdressLocator).getText();
        assertEquals(adress, actualCheckAdress);
    }

    // Метод проверки поля Метро на финальной странице Заказа
    public void assertCheckMetroStation() {
        String actualCheckMetroStation = driver.findElement(checkMetroStationLocator).getText();
        assertNotEquals(metroStation, actualCheckMetroStation);
    }

    // Метод проверки поля Телефон на финальной странице Заказа
    public void assertCheckPhoneNumber() {
        String actualCheckPhoneNumber = driver.findElement(checkPhoneNumberLocator).getText();
        assertEquals(phoneNumber, actualCheckPhoneNumber);
    }

    // Метод проверки поля Дата доставки на финальной странице Заказа
    public void assertCheckDateOfDeliverOrder() {
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
    public void assertCheckCommentForCourierOfDeliverOrder() {
        String actualCheckCommentForCourierOfDeliverOrder = driver.findElement(checkCommentForCourierOfDeliverOrderLocator).getText();
        assertEquals(commentForCourierOfDeliverOrder, actualCheckCommentForCourierOfDeliverOrder);
    }


    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Верхней кнопки Заказать
    public void fillAllOrderFromUpperButtonOrder(
            String name,
            String surname,
            String adress,
            String metroStation,
            String phoneNumber,
            String dateOfDeliverOrder,
            String commentForCourierOfDeliverOrder) {
        clickUpperOrderButton();
        fillNameInOrder(name);
        fillSurnameInOrder(surname);
        fillAdressOrder(adress);
        fillMetroOrder(metroStation);
        fillPhoneNumberOrder(phoneNumber);
        fillbuttonNextFromFirstPage();
        filldateOfDeliverOrder(dateOfDeliverOrder);
        clickAboutOfRentLocator();
        clickperiodOfRent();
        clickblackColorOfScooter();
        fillcommentForCourierOfDeliverOrder(commentForCourierOfDeliverOrder);
        clickButtonGetOrder();
        clickButtonConfirmGetOrder();
        waitSome();
        confirmOrderHasBeenPlaced();
        waitSome();
        clickButtonShowStatusOfOrder();
        waitSome();
        assertCheckName();
        assertCheckSurname();
        assertCheckAdress();
        assertCheckMetroStation();
        assertCheckPhoneNumber();
        assertCheckDateOfDeliverOrder();
        assertCheckRentalPeriodOfDeliverOrder();
        assertCheckBlackColorOfScooter();
        assertCheckCommentForCourierOfDeliverOrder();
    }

    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Верхней кнопки Заказать
    public void fillAllOrderFromLowerButtonOrder(
            String name,
            String surname,
            String adress,
            String metroStation,
            String phoneNumber,
            String dateOfDeliverOrder,
            String commentForCourierOfDeliverOrder) {
        clickUpperOrderButton();
        fillNameInOrder(name);
        fillSurnameInOrder(surname);
        fillAdressOrder(adress);
        fillMetroOrder(metroStation);
        fillPhoneNumberOrder(phoneNumber);
        fillbuttonNextFromFirstPage();
        filldateOfDeliverOrder(dateOfDeliverOrder);
        clickAboutOfRentLocator();
        clickperiodOfRent();
        clickblackColorOfScooter();
        fillcommentForCourierOfDeliverOrder(commentForCourierOfDeliverOrder);
        clickButtonGetOrder();
        clickButtonConfirmGetOrder();
        waitSome();
        confirmOrderHasBeenPlaced();
        waitSome();
        clickButtonShowStatusOfOrder();
        waitSome();
        assertCheckName();
        assertCheckSurname();
        assertCheckAdress();
        assertCheckMetroStation();
        assertCheckPhoneNumber();
        assertCheckDateOfDeliverOrder();
        assertCheckRentalPeriodOfDeliverOrder();
        assertCheckBlackColorOfScooter();
        assertCheckCommentForCourierOfDeliverOrder();
    }
}