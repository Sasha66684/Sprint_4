package ru.yandex.scooter.praktikum;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.*;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest {
    private static final String BROWSER = "chrome";
    private WebDriver webDriver;
    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String newDate;
    private final int days;
    private final String newColor;
    private final String newComment;

//конструктор тест-класса
public OrderTest(String buttonLocation, String name, String surname, String address, String telephone, String newDate, int days, String newColor, String newComment) {
    this.buttonLocation = buttonLocation;
    this.name = name;
    this.surname = surname;
    this.address = address;
    this.telephone = telephone;
    this.newDate = newDate;
    this.days = days;
    this.newColor = newColor;
    this.newComment = newComment;
}
//тестовые данные
@Parameterized.Parameters(name = "{0}.{1}. {2}. {3}. {4}. {5}. {6}. {7}")
public static Object[][] getOrderData() {
    return new Object[][]{
            {"up", "Александр", "Семенов", "Перовская", "89026666666", "10.06.2024", 1, "black", "Скорее везите!"},
            {"down", "Дмитрий ", "Васильев", "Зеленый вал", "89006666666", "30.07.2024", 3, "grey", "Срочно "},

    };
}
@Before
    public void setup() {

       webDriver = WebDriverFactory.getWebDriver(BROWSER);
       //  Значение по умолчанию chrome
      webDriver.get("https://qa-scooter.praktikum-services.ru");
    }
    @Test
    public void enterOrderAllDataTest() {

        //создаю объект главной страницы
        MainPage objMainPage = new MainPage(webDriver);

        //выбираю кнопку Заказать для клика
        objMainPage.chooseOrderButtonAndClick(buttonLocation);

        //создаю объект страницы Для кого самокат

        new OrderPage(webDriver)
                //вызываю метод для ввода данных на странице Для кого самокат
                .enterOrderAllData(name, surname, address, telephone);
        //создаю объект страницы Про аренду
        new RentPage(webDriver)
                //вызываю метод для ввода данных на странице Про аренду
                .enterAllDataRentOrder(newDate, days, newColor, newComment);
        //создаю объект страницы Хотите оформить заказ?
        new WantPlaseOrder(webDriver)
                //нажимаю кнопку Да в окне Хотите оформить заказ?
                .clickOkButton();
        //создаю объект страницы Заказ оформлен
        OrderProcessed objOrderIsProcessed = new OrderProcessed(webDriver);
        //проверяю, что поле "Заказ оформлен" отображается
        assertTrue(objOrderIsProcessed.orderIsProcessedTextIsDisplayed());
    }

    //Закрывю браузер
    @After
    public void tearDown() {
        webDriver.quit();

    }
}







