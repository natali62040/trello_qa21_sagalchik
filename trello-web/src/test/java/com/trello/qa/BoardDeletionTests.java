package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @Test
    public void deleteBoardFromHomePage(){
        int before = getBoardsCount();
        clickOnFirstBoard();
        clickOnMore();
        clickOnCloseBoard();
        clickOnCloseBoardButton();
        clickOnPermanentlyDeleteBoard();
        clickOnDeleteButton();

        returnToHomePage();
        int after = getBoardsCount();
        Assert.assertEquals(after, before-1);
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

}
