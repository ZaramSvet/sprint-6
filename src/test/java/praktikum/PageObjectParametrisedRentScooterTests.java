package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PageObjectParametrisedRentScooterTests {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        // driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @ParameterizedTest
    @MethodSource("credentialsProvider")
    void testMetaForFillAllStringsInOrder(String name, String surname, String adress, String metroStation, String phoneNumber, String dateOfDeliverOrder, String commentForCourierOfDeliverOrder) throws Exception {
        PageObjectMetaFirstPageOrder pageObjectMetaFirstPageOrder = new PageObjectMetaFirstPageOrder(driver);
        PageObjectMetaSecondPageOrder pageObjectMetaSecondPageOrder = new PageObjectMetaSecondPageOrder(driver);
        PageObjectMetaThirdPageOrder pageObjectMetaThirdPageOrder = new PageObjectMetaThirdPageOrder(driver);
        pageObjectMetaFirstPageOrder.fillPageObjectFirstPageOrderUpperButtonOrder(name, surname,  adress, metroStation, phoneNumber);
        pageObjectMetaSecondPageOrder.fillPageObjectSecondPageOrderUpperButtonOrder(dateOfDeliverOrder, commentForCourierOfDeliverOrder);
        pageObjectMetaThirdPageOrder.fillPageObjectThirdPageOrderUpperButtonOrder(name, surname,  adress, metroStation, phoneNumber, dateOfDeliverOrder, commentForCourierOfDeliverOrder);

        pageObjectMetaFirstPageOrder.fillPageObjectFirstPageOrderLowerButtonOrder(name, surname,  adress, metroStation, phoneNumber);
        pageObjectMetaSecondPageOrder.fillPageObjectSecondPageOrderLowerButtonOrder(dateOfDeliverOrder, commentForCourierOfDeliverOrder);
        pageObjectMetaThirdPageOrder.fillPageObjectThirdPageOrderLowerButtonOrder(name, surname,  adress, metroStation, phoneNumber, dateOfDeliverOrder, commentForCourierOfDeliverOrder);

    }
    private static Stream<Arguments> credentialsProvider() {
        return Stream.of(
                Arguments.of("Марк", "Петров", "г. Москва, улица Новая д.3 кв.1", "Черкизовская", "+79101234567", "25.08.2025", "Вези аккуратно !"),
                Arguments.of("Павел", "Антонов", "г. Ленинград, улица Старая д.2 кв.4", "Черкизовская", "+79107654321", "21.01.2021", "Главное, чтобы был исправный !")
        );
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}