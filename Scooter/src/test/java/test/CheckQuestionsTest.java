package test;

import home.HomePage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;


public class CheckQuestionsTest {
    private WebDriver driver;


    @Before
    public void setPropAndStartBrowser() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver/WebDriver/bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(HomePage.URL);

        /*WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get(HomePage.URL);*/

        WebElement element = driver.findElement(By.id("accordion__heading-0"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    @After
    public void teardown() {
        driver.quit(); // Закрыть браузер
    }


    @Test
    public void checkAnswerText1() {

        String AnswerText1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.getAnswerOne();
        assertEquals(AnswerText1, homePage.getAnswerOne());
    }

    @Test
    public void checkAnswerText2() {
        String AnswerText2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.getAnswerTwo();
        assertEquals(AnswerText2, homePage.getAnswerTwo());

    }

    @Test
    public void checkAnswerText3() {
        String AnswerText3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.getAnswerThree();
        assertEquals(AnswerText3, homePage.getAnswerThree());

    }

    @Test
    public void checkAnswerText4() {
        String AnswerText4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.getAnswerFour();
        assertEquals(AnswerText4, homePage.getAnswerFour());

    }
    @Test
    public void checkAnswerText5() {
        String AnswerText5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.getAnswerFive();
        assertEquals(AnswerText5, homePage.getAnswerFive());

    }
    @Test
    public void checkAnswerText6() {
        String AnswerText6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        HomePage homePage = new HomePage(driver);
        homePage.getAnswerSix();
        assertEquals(AnswerText6, homePage.getAnswerSix());

    }
    @Test
    public void checkAnswerText7() {
        String AnswerText7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.getAnswerSeven();
        assertEquals(AnswerText7, homePage.getAnswerSeven());

    }
    @Test
    public void checkAnswerText8() {
        String AnswerText8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        HomePage homePage = new HomePage(driver);
        homePage.clickCookeMessageButton();
        homePage.getAnswerEight();
        assertEquals ("Не совпадает текст",AnswerText8, homePage.getAnswerEight());
    }
}
