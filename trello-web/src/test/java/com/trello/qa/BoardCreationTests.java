package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions(){
        if(!app.isUserLoggedIn()){
            app.login("natalisagalchik@gmail.com", "Sn271206");
        }
    }

    @BeforeMethod
    public void isOnHomePage(){
        if(! app.isTherePersonalBoards()){
            app.returnToHomePage();
        }
    }

    @Test//(enabled = false)
    public void testBoardCreationFromPlusButtonOnHeader(){
        int before = app.getBoardsCount();
        app.clickOnPlusButtonOnHeader();
        app.selectCreateBoardFromDropDown();
        String boardName = "My plan3";
        app.fillBoardCreationForm(boardName);
        app.click(By.xpath("//*[@class='_1vk4y48RR5OmqE']"));
        app.click(By.xpath("//*[@class='_1uK2vQ_aMRS2NU'][contains(text(),'No team')]"));
        app.clickCreateButton();
        String createdBoardName = app.getBoardNameFromBoardPage();
        app.returnToHomePage();
        int after = app.getBoardsCount();
        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdBoardName.toLowerCase(), boardName.toLowerCase());
    }


    @Test(enabled = false)
    public void testBoardCreation(){
        Assert.assertFalse(app.isUserLoggedOut());
        app.click(By.xpath("//*[@name='add']"));
        app.click(By.xpath("//*[contains(text(),'Create Board')]"));
        app.type(By.xpath("//*[@placeholder='Add board title']"),"My plans2");
        app.clickCreateButton();
    }

}
