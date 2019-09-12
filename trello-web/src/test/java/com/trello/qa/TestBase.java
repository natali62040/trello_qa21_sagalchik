package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();//max screen

        openSite("https://trello.com/");
        login("natalisagalchik@gmail.com", "Sn271206");
    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"), email);
        type(By.cssSelector("[type=password]"), password);
        click(By.id("login"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }
    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isUserLoggedOut() {

        return isElementPresent(By.cssSelector("[href=\"/login\"]"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }

    public void returnToHomePage() {
        if(isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))){
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.stalenessOf(driver.
                            findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            click(By.cssSelector("a[href='/']"));
    }

    protected String getTeamNameFromTeamPage() {
    return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public int getTeamsCount() {
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickOnPlusButtonOnLeftNavMenu() {
        click(By.xpath("//*[@name='add']"));
    }

    public void deleteTeam() {
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openSettings() {
        click(By.cssSelector(".icon-gear.icon-sm.OiX3P2i2J92Xat"));
    }

    public void clickOnFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));
    }

    protected String getBoardNameFromBoardPage() {
        return driver.findElement(By.xpath("//h3[contains(text(),'Personal Boards')]/../..//li[1]")).getText();
    }

    public void clickCreateButton() {
        click(By.xpath("//*[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }

    public void fillBoardCreationForm(String boardName) {
        type(By.xpath("//*[@class ='_23NUW98LaZfBpQ']"),boardName);//*[@class ='_23NUW98LaZfBpQ']
    }

    public void selectCreateBoardFromDropDown() {
        click(By.xpath("//*[contains(text(),'Create Board')]"));
    }

    public int getBoardsCount() {
        new WebDriverWait(driver,10).
                until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//h3[contains(text(),'Personal Boards')]/../..//li")));
        return
                driver.findElements(By.xpath("//h3[contains(text(),'Personal Boards')]/../..//li")).size();
    }

    public boolean isTherePersonalBoards() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }
}