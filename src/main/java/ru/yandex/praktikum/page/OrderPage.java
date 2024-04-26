package ru.yandex.praktikum.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

//Страница заказа "Для кого самокат"
public class OrderPage {

    private final WebDriver webDriver;
    //Локатор для поле "Имя"
    private final By orderDataName = By.xpath("//input[@placeholder='* Имя']");
    //Локатор для поле "Фамилия"
    private final By  orderDataSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Локатор для поле "Адрес: куда привезти заказ"
    private final By orderDataAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор для поле "Станция метро"
    private By orderDataSubwayStation = By.className("select-search__input");

    private By orderSelectorSubwayStation = By.className("select-search__select");
    //////// private final By subwayInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    //Локатор для поле "Телефон: на него позвонит курьер"
    private  By orderDataTelephoneLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор для кнопки "далее"
    private  By orderButtonFurtherLocator = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");
    //Локатор для выбора станции метро
   // ///////private final  String statioMenuInputLocator = "//div[text()='%s']";

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    //метод для ввода Имени
    public void enterOrderDataName(String name) {
        webDriver.findElement(orderDataName).sendKeys(name);
    }
    //метод для ввода Фамилии
    public void enterOrderDataSurname(String surname) {

        webDriver.findElement(orderDataSurname).sendKeys(surname);
    }
    //метод для ввода Адреса
    public void enterOrderDataAddress(String address) {
        webDriver.findElement(orderDataAddress).sendKeys(address);

    }
    //метод обращения к полю Станция метро и выбора станции
    public void clickOrderDataSubwayStation() {
        webDriver.findElement(orderDataSubwayStation).click();
        webDriver.findElement(orderSelectorSubwayStation).isDisplayed();
        webDriver.findElement(orderDataSubwayStation).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    //метод для ввода номера Телефона
    public void enterOrderDataTelephone(String telephone) {
        webDriver.findElement(orderDataTelephoneLocator).sendKeys(telephone);

    }

    //кликнуть по кнопке Далее на старнице Для кого самокат
    public void clickOrderButtonFurther() {


          new WebDriverWait(webDriver, ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(orderButtonFurtherLocator));
        webDriver.findElement(orderButtonFurtherLocator).click();
    }
    //общий метод для ввода имени, фамилии, адреса, выбора станции, телефона, также кликает по кнопке Далее
    public OrderPage enterOrderAllData(String name, String surname, String address, String telephone) {
        enterOrderDataName(name);
        enterOrderDataSurname(surname);
        enterOrderDataAddress(address);
        clickOrderDataSubwayStation();
        enterOrderDataTelephone(telephone);
        clickOrderButtonFurther();
        return this;

    }
}


