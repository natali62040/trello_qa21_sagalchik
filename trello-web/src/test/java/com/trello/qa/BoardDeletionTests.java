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


}
