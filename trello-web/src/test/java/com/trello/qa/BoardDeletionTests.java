package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @Test
    public void deleteBoardFromHomePage(){
        int before = app.getBoardsCount();
        app.clickOnFirstBoard();
        app.clickOnMore();
        app.clickOnCloseBoard();
        app.clickOnCloseBoardButton();
        app.clickOnPermanentlyDeleteBoard();
        app.clickOnDeleteButton();

        app.returnToHomePage();
        int after = app.getBoardsCount();
        Assert.assertEquals(after, before-1);
    }


}
