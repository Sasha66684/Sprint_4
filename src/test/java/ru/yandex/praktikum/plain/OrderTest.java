package ru.yandex.scooter.praktikum;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import ru.yandex.praktikum.WebDriverFactory;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.RentPage;
import static org.junit.Assert.assertTrue;

public class OrderTest {
    //

    private static final String BROWSER = "firefox";

    private WebDriver webDriver;

    @Before
    public void setup() {

        webDriver = WebDriverFactory.getWebDriver(BROWSER);
        // Значение по умолчанию chrome
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void createOrder() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickUpCreateOrder();
        //Кнопка "Заказать" верхняя

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustormerInfo("Паша", "Пашков", "Москва,Арбатская 39", "Перово", "89221111123");
        orderPage.clickNextButton();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.clickRenOrderButton();

        rentPage.enterBringScooter();
//Выбор даты аренды из календаря на странице "Про аренду"
        rentPage.enterPeriodInput();
//Нажатие на поле "Срок аренды" на странице "Про аренду"
        rentPage.enterRenPeriodMenu();
        //Выбор срока аренды (количество суток) на странице "Про аренду"
        rentPage.clickScooterColor();
// выбор цвета самоката на странице "Про аренду"
        rentPage.enterCommentForCourier("Привезите самокат во время");
// Поле для ввода комментария для кульера на странице "Про аренду"
        rentPage.clickRenOrderButton();
//Кнопка Заказать на странице "Про аренду"
        rentPage.clickButtonYesInput();
//Нажатие на кнопку "да" в сообщении "Хотите оформить заказ?"
        assertTrue(rentPage.rentPageIsDisplayed());
        //Проверяем сообщение о заказе "заказ оформлен"
    }

@Test
        public void createDownButten() {
    MainPage mainPage = new MainPage(webDriver);
    mainPage.clickDownCreateOrder();


            OrderPage orderPage = new OrderPage(webDriver);
            orderPage.fillCustormerInfo("Паша", "Пашков", "Москва,Арбатская 39", "Перово", "89221111123");
            orderPage.clickNextButton();

            RentPage rentPage = new RentPage(webDriver);
            rentPage.clickRenOrderButton();

            rentPage.enterBringScooter();
//Выбор даты аренды из календаря на странице "Про аренду"
            rentPage.enterPeriodInput();
//Нажатие на поле "Срок аренды" на странице "Про аренду"
            rentPage.enterRenPeriodMenu();
//Выбор срока аренды (количество суток) на странице "Про аренду"
            rentPage.clickScooterColor();
// выбор цвета самоката на странице "Про аренду"
            rentPage.enterCommentForCourier("Привезите самокат во время");
// Поле для ввода комментария для кульера на странице "Про аренду"
            rentPage.clickRenOrderButton();
//Кнопка Заказать на странице "Про аренду"
            rentPage.clickButtonYesInput();
//Нажатие на кнопку "да" в сообщении "Хотите оформить заказ?"
            assertTrue(rentPage.rentPageIsDisplayed());
    //Проверяем сообщение о заказе "заказ оформлен"

        }
        @After
        public void tearDown() {
            webDriver.quit();
        }
    }

