package com.trello.qa;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {

    @Test
    public void deleteBoardFromHomePage() throws InterruptedException {
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickOnFirstBoard();
        app.getBoardHelper().clickOnMore();
        Thread.sleep(10);
        app.getBoardHelper().clickOnCloseBoard();
        app.getBoardHelper().clickOnCloseBoardButton();
        app.getBoardHelper().clickOnPermanentlyDeleteBoard();
        app.getBoardHelper().clickOnDeleteButton();

        app.sessionHelper.returnToHomePage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before-1);
    }


}
