package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(!app.getBoardHelper().isBoardPresent()){
            app.getBoardHelper().createBoard();
        }
    }


    @Test
    public void testRenameBoard() throws InterruptedException {
        app.getBoardHelper().clickOnBoardButton();
        app.getBoardHelper().clickOnFirstBoard();
        String boardName1 = "MMM";
        app.getBoardHelper().changeBoardName(boardName1);

        //Assert.assertTrue(app.getBoardHelper().findBoardByName(boardName1));
        }
    }
