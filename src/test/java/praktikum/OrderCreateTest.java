package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.constants.CreateOrderButton.DOWN_BUTTON;
import static praktikum.constants.CreateOrderButton.UP_BUTTON;
import static praktikum.constants.RentDurationConstants.*;
import static praktikum.constants.ScooterColours.*;

@RunWith(Parameterized.class)
public class OrderCreateTest {
    private WebDriver driver;
    private final String site = "https://qa-scooter.praktikum-services.ru/";
    private final String name;
    private final String surname;
    private final String address;
    private final int stateMetroNumber;
    private final String telephoneNumber;
    private final String date;
    private final String duration;
    private final Enum colour;
    private final String comment;
    private final String expectedHeader = "Заказ оформлен";
    private final Enum button;

    public OrderCreateTest(Enum button, String name, String surname, String address, int stateMetroNumber, String telephoneNumber,
                           String date, String duration, Enum colour, String comment) {
        this.button = button;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.stateMetroNumber = stateMetroNumber;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.duration = duration;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {UP_BUTTON, "Имя Один", "Фамилия", "Адрес 1", 123, "79991111111", "28.05.2023", SIX_DAYS, GREY, "comments one"},
                {UP_BUTTON, "Имя Два", "Фамилия", "Адрес 2", 7, "79992222222", "28.05.2023", FIVE_DAYS, BLACK, "comments two"},
                {UP_BUTTON, "Имя Три", "Фамилия", "Адрес 3", 10, "79993333333", "28.05.2023", ONE_DAY, BLACK, "comments three"},
                {DOWN_BUTTON, "Имя Один", "Фамилия", "Адрес 1", 123, "79991111111", "28.05.2023", SIX_DAYS, GREY, "comments one"},
                {DOWN_BUTTON, "Имя Два", "Фамилия", "Адрес 2", 7, "79992222222", "28.05.2023", FIVE_DAYS, BLACK, "comments two"},
                {DOWN_BUTTON, "Имя Три", "Фамилия", "Адрес 3", 10, "79993333333", "28.05.2023", ONE_DAY, BLACK, "comments three"},
        };
    }

    @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(site);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testCreateOrderWithUpButton() {
        new HomePage(driver)
                .waitForLoadHomePage()
                .clickCreateOrderButton(button);

        new AboutRenter(driver)
                .waitForLoadOrderPage()
                .inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .changeStateMetro(stateMetroNumber)
                .inputTelephone(telephoneNumber)
                .clickNextButton();

        new AboutScooter(driver)
                .waitAboutRentHeader()
                .inputDate(date)
                .inputDuration(duration)
                .changeColour(colour)
                .inputComment(comment)
                .clickButtonCreateOrder();

        PopUpWindow popUpWindow = new PopUpWindow(driver);
        popUpWindow.clickButtonYes();

        assertTrue(popUpWindow.getHeaderAfterCreateOrder().contains(expectedHeader));
    }
}
