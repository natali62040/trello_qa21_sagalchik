package com.trello.qa.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase{

    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public String getBoardNameFromBoardPage() {
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
        new WebDriverWait(driver,20).
                until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//h3[contains(text(),'Personal Boards')]/../..//li")));
        return
                driver.findElements(By.xpath("//h3[contains(text(),'Personal Boards')]/../..//li")).size();
    }

    public boolean isTherePersonalBoards() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    public void clickOnDeleteButton() {

        click(By.xpath("//*[@class='js-confirm full negate']"));
    }

    public void clickOnPermanentlyDeleteBoard() {

        click(By.xpath("//*[@class='quiet js-delete']"));
    }

    public void clickOnCloseBoardButton() {

        click(By.xpath("//*[@class='js-confirm full negate']"));
    }

    public void clickOnCloseBoard() {

        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnMore() {

        click(By.xpath("//*[@class ='board-menu-navigation-item-link js-open-more']"));
    }

    public void clickOnFirstBoard() {

        click(By.xpath("//h3[contains(text(),'Personal Boards')]/../..//li[1]"));
    }

    public void clickOnBoardButton() {
        click(By.xpath("//*[@class='icon-board icon-sm OiX3P2i2J92Xat']"));
    }

    public void fillBoardNameForm(String boardName1) {
        type(By.xpath("//div[@class='board-header-btn mod-board-name inline-rename-board js-rename-board']"),boardName1+ Keys.ENTER);
    }
}
