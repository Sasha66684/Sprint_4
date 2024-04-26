package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WantPlaseOrder {
    private WebDriver webDriver;
    private By okButtonLocator = By.xpath(".//*[text()='Да']");
    public WantPlaseOrder(WebDriver webDriver) {

        this.webDriver = webDriver;
    }
    //метод нажатия на кнопку Да
    public WantPlaseOrder clickOkButton() {

        webDriver.findElement(okButtonLocator).click();
        return this;
    }

}
