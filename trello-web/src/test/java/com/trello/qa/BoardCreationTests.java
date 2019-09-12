package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @BeforeClass
    public void ensurePreconditions(){
        if(!isUserLoggedIn()){
            login("natalisagalchik@gmail.com", "Sn271206");
        }
    }

    @BeforeMethod
    public void isOnHomePage(){
        if(! isTherePersonalBoards()){
            returnToHomePage();
        }
    }

    @Test//(enabled = false)
    public void testBoardCreationFromPlusButtonOnHeader(){
        int before = getBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        String boardName = "My plan3";
        fillBoardCreationForm(boardName);
        clickCreateButton();
        String createdBoardName = getBoardNameFromBoardPage();
        returnToHomePage();
        int after = getBoardsCount();
        Assert.assertEquals(after, before+1);
       // Assert.assertEquals(createdBoardName.toLowerCase(), boardName.toLowerCase());
    }


    @Test(enabled = false)
    public void testBoardCreation(){
        Assert.assertFalse(isUserLoggedOut());
        click(By.xpath("//*[@name='add']"));
        click(By.xpath("//*[contains(text(),'Create Board')]"));
        type(By.xpath("//*[@placeholder='Add board title']"),"My plans2");
        clickCreateButton();
    }

}
