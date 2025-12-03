package praktikum;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.is;

public class HomePage {
    private WebDriver driver;
    // Сколько это стоит? И как оплатить?
    private By questionCost = By.xpath(".//div[@class='accordion__item'][1]");
    // Хочу сразу несколько самокатов! Так можно?
    private By questionOneScooter = By.xpath(".//div[@class='accordion__item'][2]");
    // Как рассчитывается время аренды?
    private By questionTime = By.xpath(".//div[@class='accordion__item'][3]");
    // Можно ли заказать самокат прямо на сегодня?
    private By questionTomorrow = By.xpath(".//div[@class='accordion__item'][4]");
    // Можно ли продлить заказ или вернуть самокат раньше?
    private By questionCall = By.xpath(".//div[@class='accordion__item'][5]");
    // Вы привозите зарядку вместе с самокатом?
    private By questionCharging = By.xpath(".//div[@class='accordion__item'][6]");
    // Можно ли отменить заказ?
    private By questionFine = By.xpath(".//div[@class='accordion__item'][7]");
    // Я живу за МКАДом, привезёте?
    private By questionMkad = By.xpath(".//div[@class='accordion__item'][8]");
    // Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private By answerCost = By.id("accordion__panel-0");
    // Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.
    private By answerOneScooter = By.id("accordion__panel-1");
    // Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.
    private By answerTime = By.id("accordion__panel-2");
    // Только начиная с завтрашнего дня. Но скоро станем расторопнее.
    private By answerTomorrow = By.id("accordion__panel-3");
    // Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.
    private By answerCall = By.id("accordion__panel-4");
    // Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.
    private By answerCharging = By.id("accordion__panel-5");
    // Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.
    private By answerFine = By.id("accordion__panel-6");
    // Да, обязательно. Всем самокатов! И Москве, и Московской области.
    private By answerMkad = By.id("accordion__panel-7");
    // Маленькая кнопка Заказать на чердаке
    private By headerOrderButton = By.xpath(".//button[text()='Заказать'][1]");
    // Большая кнопка Заказать на странице
    private By pageOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    // Методы для раскрытия вопросов
    public void clickQuestionCost() {
        driver.findElement(questionCost).click();
    }
    public void clickQuestionOneScooter() {
        driver.findElement(questionOneScooter).click();
    }
    public void clickQuestionTime() {
        driver.findElement(questionTime).click();
    }
    public void clickQuestionTomorrow() {
        driver.findElement(questionTomorrow).click();
    }
    public void clickQuestionCall() {
        driver.findElement(questionCall).click();
    }
    public void clickQuestionCharging() {
        driver.findElement(questionCharging).click();
    }
    public void clickQuestionFine() {
        driver.findElement(questionFine).click();
    }
    public void clickQuestionMkad() {
        driver.findElement(questionMkad).click();
    }
    // Метод для сравнения ответа на вопрос с правильным текстом
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }
    // Геттеры для получения текса ответов
    public String getAnswerCost() {
        return driver.findElement(answerCost).getText();
    }
    public String getAnswerOneScooter() {
        return driver.findElement(answerOneScooter).getText();
    }
    public String getAnswerTime() {
        return driver.findElement(answerTime).getText();
    }
    public String getAnswerTomorrow() {
        return driver.findElement(answerTomorrow).getText();
    }
    public String getAnswerCall() {
        return driver.findElement(answerCall).getText();
    }
    public String getAnswerCharging() {
        return driver.findElement(answerCharging).getText();
    }
    public String getAnswerFine() {
        return driver.findElement(answerFine).getText();
    }
    public String getAnswerMkad() {
        return driver.findElement(answerMkad).getText();
    }
    // Методы для клика по кнопкам Заказать
    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }
    public void clickPageOrderButton() {
        // Проскролить до появления кнопки
        WebElement bigButton = driver.findElement(pageOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", bigButton);
        driver.findElement(pageOrderButton).click();
    }

    /*
    private int number;
    private By question = By.xpath(".//div[@class='accordion__item']");
    public void clickQuestion(int number) {
        driver.findElement(question[number]).click();
    }*/
}
