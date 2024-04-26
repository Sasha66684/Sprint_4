package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//класс страницы Заказ оформлен
public class OrderProcessed {
    private WebDriver webDriver;



    //Локатор поля Заказ оформлен
    private By orderProcessed = By.xpath("//div[text()='Заказ оформлен']");
    public  OrderProcessed(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

//метод возвращает истину, если поле Заказ оформлен отображено
public boolean orderIsProcessedTextIsDisplayed() {

    return webDriver.findElement(orderProcessed).isDisplayed();
}
}
