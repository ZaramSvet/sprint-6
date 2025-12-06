package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PageObjectMetaSecondPageOrder {

    private WebDriver driver;

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

    public PageObjectMetaSecondPageOrder(WebDriver driver) {
        this.driver = driver;
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


    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Верхней кнопки Заказать
    public void fillPageObjectSecondPageOrderUpperButtonOrder(
            String dateOfDeliverOrder,
            String commentForCourierOfDeliverOrder) {
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
    }

    // Метод заполнения всех полей для заказа самоката, включая необходимые клики по кнопкам и проверки, при нажатии Верхней кнопки Заказать
    public void fillPageObjectSecondPageOrderLowerButtonOrder(
            String dateOfDeliverOrder,
            String commentForCourierOfDeliverOrder) {
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
    }
}