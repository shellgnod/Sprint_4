package test;

import home.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class CheckOrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String phone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    public CheckOrderTest(String name, String surname, String address, String station, String phone, String date, String period, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }
    @Contract(value = " -> new", pure = true)
    @Parameterized.Parameters
    public static Object[] @NotNull [] getDate () {
        return new Object[][] {
                {"Донки","Ли","город Кок","Ржаки","+7899900099","08.06.2022", "трое суток", "black", "нет"},
                {"Биг","Эсс","город Песков","Путинки","+78858999999","17.08.2022", "двое суток", "black", "нет"}
        };
    }

    @Before
    public void setPropAndStartBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:/Users/Daniil/Desktop/OTH/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(HomePage.URL);
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(HomePage.URL);
    }

     @After
     public void teardown() {driver.quit(); // Закрыть браузер
    }
    @Test
    public void checkOrderSmallButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.clickOrderSmallButton();

        OrderPage orderPage=new OrderPage(driver);
        orderPage.fillOrderForm();
        orderPage.clickButtonNext();

        RentPage rentPage=new RentPage(driver);
        rentPage.fillRentPage();
        rentPage.clickButtonOrder();
        rentPage.clickButtonOrderYes();
        String orderCompleted="Заказ оформлен";
        MatcherAssert.assertThat(rentPage.getOrderCompleted(), containsString(orderCompleted));

    }
    @Test
    public void checkOrderBigButtonTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.clickOrderBigButton();

        OrderPage orderPage=new OrderPage(driver);
        orderPage.fillOrderForm();
        orderPage.clickButtonNext();

        RentPage rentPage=new RentPage(driver);
        rentPage.fillRentPage();
        rentPage.clickButtonOrder();
        rentPage.clickButtonOrderYes();
        String orderCompleted="Заказ оформлен";
        MatcherAssert.assertThat(rentPage.getOrderCompleted(), containsString(orderCompleted));

    }
}
