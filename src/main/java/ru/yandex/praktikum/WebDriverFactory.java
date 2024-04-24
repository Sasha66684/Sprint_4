package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    //Инициализация браузеров
    public static WebDriver getWebDriver(String browserType) {

        if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
       } else if (browserType.equalsIgnoreCase("yandex")) {
            return null;
        } else {
            WebDriverManager.chromedriver();
            return new ChromeDriver();
        }
    }
}
