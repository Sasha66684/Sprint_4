package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

//Главная страница "Яндекс Самоката"
public  class MainPage{

    private WebDriver webDriver;
    //Верняя в правом углу кнопка "Заказать"
    private By higherOrderButtonLocator = By.xpath("//div[contains(@class,'Header')]/button[text()='Заказать']");
    //Нижняя по центру  кнопка "Заказать"
    private By lowerOrderButtonLocator = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Кнопка "да все привыкли" в низу в сообщении о куки
    private By cookiesButtonLocator = By.id("rcc-confirm-button");

    private final String questionLocator ="accordion__heading-%s";
    private final String answerLocator ="//div[contains(@id, 'accordion__panel')][.='%s']";
    public  MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }



    //кликнуть по верхней кнопке Заказать на главной странице
    public void higherOrderButtonClick() {

        webDriver.findElement(higherOrderButtonLocator).click();

    }
    //кликнуть по нижней кнопке Заказать
    public MainPage lowerOrderButtonClick() {
        WebElement element = webDriver.findElement(lowerOrderButtonLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        webDriver.findElement(lowerOrderButtonLocator).click();
        return this;
    }
    //выбор кнопки Заказать на странице
    public MainPage chooseOrderButtonAndClick(String buttonLocation) {
        if (buttonLocation.equals("up")) {
            higherOrderButtonClick();
            return this;
        } else if (buttonLocation.equals("down")) {
            lowerOrderButtonClick();
            return this;
        }
        return this;
    }
    // метод нажатие на кнопку "да" все привыкли" в низу в сообщении о куки
    public void closeCookiesWindow() {
        webDriver.findElement(cookiesButtonLocator).click();

    }
    //Метод для аккордиона "Вопросы о важном"
    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));
//скролл для аккордиона
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(webDriver, ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
        //скролл и ожидание времени для аккордиона
        element.click();
    }

    //Метод для сравнения вопросов с ответами в аккордионе
    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();

    }
}
