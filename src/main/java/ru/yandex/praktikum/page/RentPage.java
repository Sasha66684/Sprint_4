package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RentPage {
    //Страница "Про аренду"
    private final WebDriver webDriver;
    private final By bringScooterLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Локатор для поле "Когда привезти самокат"
    private final By renPeriodInputLocator = By.xpath("//div[text()='* Срок аренды']");
    //Локатор для поле "Срок арендыт"
    private final By renPeriodMenuLocator = By.xpath("//div[text()='двое суток']");
    //Локатор для поле выбора  "Срок аренды" (двое суток)
    private final By scooterColorLocator = By.xpath("//input[@id='black']");
    //Локатор для выбора цвета самоката. Цвет "черный жемчуг"
    private final By commentForCourierInputLocator = By.xpath("//input[@placeholder= 'Комментарий для курьера']");
    //Локатор для поле "Комментарий для курьера"
    private final By creatOrderButtonLocator = By.xpath("//div[contains(@class,'Order')]/button[text()='Заказать']");
    //Локатор для нопки  "Заказать"
    private final By buttonYesInputLocator = By.xpath("//div[contains(@class,'Order')]/button[text()='Да']");
    //Локатор для кнопки "Да" в сообщении  "Хотите оформить заказ"
private final  By rentPageIsDisplayedLocator = By.xpath("//div[contains(@class,'Order_Modal')]//div[text()='Заказ оформлен']");
    //Локатор для сообщения что "Заказ оформлен"
    public RentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void enterBringScooter() {
        WebElement bringScooter = webDriver.findElement(bringScooterLocator);
        bringScooter.sendKeys("25.04.2024", Keys.ENTER);
//Выбор даты аренды из календаря на странице "Про аренду"

    }

    public void enterPeriodInput() {
        WebElement renPeriodInput = webDriver.findElement(renPeriodInputLocator);
        renPeriodInput.click();
//Нажатие на поле "Срок аренды" на странице "Про аренду"
    }

    public void enterRenPeriodMenu() {
        WebElement renPeriodMenu = webDriver.findElement(renPeriodMenuLocator);
        renPeriodMenu.click();
// Выбор срока аренды (количество суток) на странице "Про аренду"
    }

    public void clickScooterColor() {
        WebElement scooterColor = webDriver.findElement(scooterColorLocator);
        scooterColor.click();
        // выбор цвета самоката на странице "Про аренду"
    }

    public void enterCommentForCourier(String commentInput) {
        WebElement commentForCourierInput = webDriver.findElement(commentForCourierInputLocator);
        commentForCourierInput.sendKeys(commentInput);
        // Поле для ввода комментария для кульера на странице "Про аренду"
    }

    public void clickRenOrderButton() {
        WebElement creatOrderButton = webDriver.findElement(creatOrderButtonLocator);
        // new WebDriverWait(webDriver, ofSeconds(15))
        //      .until(ExpectedConditions.elementToBeClickable(creatOrderButton));
        creatOrderButton.click();
        //Кнопка Заказать на странице "Про аренду"
    }

    public void clickButtonYesInput() {
        WebElement buttonYesInput = webDriver.findElement(buttonYesInputLocator);
//Метод для кнопки  "Да"
        buttonYesInput.click();
//Кнопка "да" в окне "Хотите оформить заказ?"
    }
        public boolean rentPageIsDisplayed() {
            return webDriver.findElement(rentPageIsDisplayedLocator).isDisplayed();
            //Метод для проверки сообщения "Заказ оформлен"
        }
    }


