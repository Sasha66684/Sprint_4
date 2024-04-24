package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;


public class OrderPage {
//Страница заказа "Для кого самокат"
    private final WebDriver webDriver;
    private final By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    //Локатор для поле "Имя"
    private final By  lastNameInputLocator = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор для поле "Фамилия"
    private final By orderAddressLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поле "Адрес: куда привезти заказ"
    private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    //Локатор для поле "Станция метро"
    private final By phoneNumberLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для поле "Телефон: на него позвонит курьер"
    private final By nexButtonLocator = By.xpath("//button[text()='Далее']");
    //Локатор для кнопки "далее"
    private final  String statioMenuInputLocator = "//div[text()='%s']";
    //Локатор для выбора станции метро
    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void fillCustormerInfo(String name, String lastname, String address, String subwayTitle, String phone) {



        WebElement nameInput = webDriver.findElement(nameInputLocator);
        nameInput.sendKeys(name);
//Поле ввода имени на странице  "Для кого самокат"

        WebElement lastNameInput = webDriver.findElement(lastNameInputLocator);
        lastNameInput.sendKeys(lastname);
// Поле ввода фамилии на странице  "Для кого самокат"

        WebElement orderAddress = webDriver.findElement(orderAddressLocator);
        orderAddress.sendKeys(address);
//Ввод в поле "Адрес" куда доставить самокат на странице  "Для кого самокат"

        WebElement subwayInput = webDriver.findElement(subwayInputLocator);
        subwayInput.click();
//Нажатие на поле "Станция метро" на странице  "Для кого самокат"
        WebElement perovoStationMenu = webDriver.findElement(By.xpath (String.format(statioMenuInputLocator, subwayTitle)));

        ((JavascriptExecutor) webDriver). executeScript("arguments[0].scrollIntoView();", perovoStationMenu);
        perovoStationMenu.click();
        //скролл до нужной станции метро
//Выбор станции метро куда доставить самокат на странице  "Для кого самокат"

        WebElement phoneNumber = webDriver.findElement(phoneNumberLocator);
        phoneNumber.sendKeys(phone);
        //Ввод номера телефона на странице  "Для кого самокат"
    }

    public void clickNextButton() {
        WebElement nextButton = webDriver.findElement(nexButtonLocator);
     new WebDriverWait(webDriver, ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
        // Ожидание при нажатии на кнопку "Далее"
//Кнопка "Далее" на странице  "Для кого самокат"
    }
}
