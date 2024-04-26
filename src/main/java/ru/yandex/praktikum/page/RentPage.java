package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


//Страница "Про аренду"
public class RentPage {

    private  WebDriver webDriver;
    //Локатор для поле "Когда привезти самокат"
    private By orderDataWhenDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    /////  private final By bringScooterLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Локатор для поле "Срок арендыт"
    private By rentalPeriod = By.className("Dropdown-placeholder");

    private By period_1day = By.xpath(".//*[@class='Dropdown-option'][1]");
    //локатор для поля Срок аренды - 2 суток
    private By period_2days = By.xpath(".//*[@class='Dropdown-option'][2]");
    //локатор для поля Срок аренды - 3 суток
    private By period_3days = By.xpath(".//*[@class='Dropdown-option'][3]");
    //локатор для поля Срок аренды - 4 суток
    private By period_4days = By.xpath(".//*[@class='Dropdown-option'][4]");
    //локатор для поля Срок аренды - 5 суток
    private By period_5days = By.xpath(".//*[@class='Dropdown-option'][5]");
    //локатор для поля Срок аренды - 6 суток
    private By period_6days = By.xpath(".//*[@class='Dropdown-option'][6]");
    //локатор для поля Срок аренды - 7 суток
    private By period_7days = By.xpath(".//*[@class='Dropdown-option'][7]");
    //Цвет самоката Церный жемчуг
    private By blackPearl = By.xpath(".//input[@id='black']");
    //Цвет самоката Серая безысходность
    private By grayHopelessness = By.xpath(".//input[@id='grey']");
    //поле Комментарий для курьера
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public RentPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    //метод для выбора даты в поле Когда привезти самокат
    public void enterDate(String newDate) {
        webDriver.findElement(orderDataWhenDelivery).sendKeys(newDate);
        webDriver.findElement(orderDataWhenDelivery).sendKeys(Keys.ENTER);
    }

    //метод для выборя количества дней аренды
    public void choosePeriod(int days) {
        webDriver.findElement(rentalPeriod).click();
        if (days == 1) {
            webDriver.findElement(period_1day).click();
        } else if (days == 2) {
            webDriver.findElement(period_2days).click();
        } else if (days == 3) {
            webDriver.findElement(period_3days).click();
        } else if (days == 4) {
            webDriver.findElement(period_4days).click();
        } else if (days == 5) {
            webDriver.findElement(period_5days).click();
        } else if (days == 6) {
            webDriver.findElement(period_6days).click();
        } else if (days == 7) {
            webDriver.findElement(period_7days).click();
        }
    }

    //выбор цвета самоката Черный жемчуг
    public void clickBlackPearl() {

        webDriver.findElement(blackPearl).click();
    }

    //выбор цвета самоката Серая безысходность
    public void clickGrayHopelessness() {
        webDriver.findElement(grayHopelessness).click();
    }

    //метод выбора цвета
    public void chooseColor(String newColor) {
        if (newColor.equals("black")) {
            clickBlackPearl();
        } else if (newColor.equals("grey")) {
            clickGrayHopelessness();
        }
    }

    //метод дял ввода комментария для курьера
    public RentPage enterComment(String newComment) {

        webDriver.findElement(comment).sendKeys(newComment);
        return this;
    }

    //метод для нажатия кнопки Заказать
    public RentPage clickOrderButton() {

        webDriver.findElement(orderButton).click();
        return this;
    }

    //общий метод для ввода даты, выбора периода, выбора цвета, ввода комментария и нажатия на кнопку Заказать на странице Про аренду
    public RentPage enterAllDataRentOrder(String newDate, int days, String newColor, String newComment) {
        enterDate(newDate);
        choosePeriod(days);
        chooseColor(newColor);
        enterComment(newComment);

        clickOrderButton();
        return this;
    }

}


