package com.trello.qa.manager;

import com.trello.qa.model.BoardData;
import org.openqa.selenium.By;
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

    public void fillBoardCreationForm(BoardData board) {
        type(By.xpath("//*[@class ='_23NUW98LaZfBpQ']"), board.getBoardName());
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

    public void clickOnFirstBoard() throws InterruptedException {
        Thread.sleep(10000);
        click(By.xpath("//h3[contains(text(),'Personal Boards')]/../..//li[1]"));
    }

    public void clickOnBoardButton() {
        click(By.xpath("//*[@class='icon-board icon-sm _2aV_KY1gTq1qWc']"));
    }


    public void changeBoardName(String newName) throws InterruptedException {
        driver.findElement(By.cssSelector(".js-rename-board")).click();
        driver.findElement(By.cssSelector("input.js-board-name-input")).sendKeys(newName);
        goHomePage();
        //returnToHomePage();
    }

    public boolean isBoardPresent() {
        return getBoardsCount() > 0;
    }

    public void createBoard() {
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        String boardName = "My plan3";
        fillBoardCreationForm(new BoardData().withBoardName(boardName));
        click(By.xpath("//*[@class='_1vk4y48RR5OmqE']"));
        click(By.xpath("//*[@class='_1uK2vQ_aMRS2NU'][contains(text(),'No team')]"));
        clickCreateButton();
        returnToHomePage();
    }
}
