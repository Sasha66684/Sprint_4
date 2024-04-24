package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public  class MainPage{
    //Главная страница "Яндекс Самоката"
    private  WebDriver webDriver;

    private By createUpOrderButtonLocator = By.xpath("//div[contains(@class,'Header')]/button[text()='Заказать']");
    //Верняя в правом углу кнопка "Заказать"
    private By createDownOrderButtonLocator = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //Нижняя по центру  кнопка "Заказать"
    private By cookiesButtonLocator = By.id("rcc-confirm-button");
    //Кнопка "да все привыкли" в низу в сообщении о куки
    private final String questionLocator ="accordion__heading-%s";
    private final String answerLocator ="//div[contains(@id, 'accordion__panel')][.='%s']";
    public  MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void clickUpCreateOrder() {
        WebElement createUpOrderButton = webDriver.findElement(createUpOrderButtonLocator);
        //кнопка "заказать" в верхнем в правом углу на главной странице
       new WebDriverWait(webDriver, ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(createUpOrderButton));
       createUpOrderButton.click();
        //ожидание при нажатии на кнопку "Заказать" в верху

    }

    public void clickDownCreateOrder() {
       WebElement createDownOrderButton = webDriver.findElement(createDownOrderButtonLocator);
        // метод кнопки заказать внизу страницы по центру
       ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", createDownOrderButton);
// скролл страницы до кнопки "Заказать"
       new WebDriverWait(webDriver, ofSeconds(25))
              .until(ExpectedConditions.elementToBeClickable(createDownOrderButton));
       createDownOrderButton.click();
        //кликнуть на кнопку заказать

        }
        public void closeCookiesWindow() {
        webDriver.findElement(cookiesButtonLocator).click();
        // метод нажатие на кнопку "да все привыкли" в низу в сообщении о куки
    }
    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));
//Метод для аккордиона ("Вопросы о важном")
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
//скролл для аккордиона
        new WebDriverWait(webDriver, ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    } //скролл и ожидание времени для аккордиона
    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
        //Метод для сравнения вопросов с ответами в аккордионе
    }
}