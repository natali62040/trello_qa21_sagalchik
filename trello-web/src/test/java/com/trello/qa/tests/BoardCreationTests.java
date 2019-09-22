package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("natalisagalchik@gmail.com", "Sn271206");
        }
    }

    @BeforeMethod
    public void isOnHomePage(){
        if(! app.getBoardHelper().isTherePersonalBoards()){
            app.getSessionHelper().returnToHomePage();
        }
    }

    @Test
    public void testBoardCreationFromPlusButtonOnHeader(){
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        String boardName = "My plan3";
        app.getBoardHelper().fillBoardCreationForm(boardName);
        app.getBoardHelper().click(By.xpath("//*[@class='_1vk4y48RR5OmqE']"));
        app.getBoardHelper().click(By.xpath("//*[@class='_1uK2vQ_aMRS2NU'][contains(text(),'No team')]"));
        app.getBoardHelper().clickCreateButton();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdBoardName.toLowerCase(), boardName.toLowerCase());
    }


    @Test(enabled = false)
    public void testBoardCreation(){
        Assert.assertFalse(app.getSessionHelper().isUserLoggedOut());
        app.getSessionHelper().click(By.xpath("//*[@name='add']"));
        app.getSessionHelper().click(By.xpath("//*[contains(text(),'Create Board')]"));
        app.getSessionHelper().type(By.xpath("//*[@placeholder='Add board title']"),"My plans2");
        app.getBoardHelper().clickCreateButton();
    }

}
