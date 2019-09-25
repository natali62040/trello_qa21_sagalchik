package com.trello.qa.tests;

import com.trello.qa.manager.BoardData;
import com.trello.qa.manager.TeamData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name"});
        list.add(new Object[]{"NAME"});
        list.add(new Object[]{"1234"});
        list.add(new Object[]{"&^#$"});
        //list.add(new Object[]{" "});

        return list.iterator();
    }

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

    @Test(enabled = false)
    public void testBoardCreationFromPlusButtonOnHeader(){
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        String boardName = "My plan3";
        app.getBoardHelper().fillBoardCreationForm(new BoardData().withBoardName(boardName));
        app.getBoardHelper().click(By.xpath("//*[@class='_1vk4y48RR5OmqE']"));
        app.getBoardHelper().click(By.xpath("//*[@class='_1uK2vQ_aMRS2NU'][contains(text(),'No team')]"));
        app.getBoardHelper().clickCreateButton();
        String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdBoardName.toLowerCase(), boardName.toLowerCase());
    }

    @Test(dataProvider = "validBoards")
    public void testBoardCreationFromPlusButtonOnHeaderWithDataProvider(String boardName){
        BoardData board = new BoardData().withBoardName(boardName);
        int before = app.getBoardHelper().getBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        //String boardName = "My plan3";
        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().click(By.xpath("//*[@class='_1vk4y48RR5OmqE']"));
        app.getBoardHelper().click(By.xpath("//*[@class='_1uK2vQ_aMRS2NU'][contains(text(),'No team')]"));
        app.getBoardHelper().clickCreateButton();
        //String createdBoardName = app.getBoardHelper().getBoardNameFromBoardPage();
        app.getBoardHelper().returnToHomePage();
        int after = app.getBoardHelper().getBoardsCount();
        Assert.assertEquals(after, before+1);
        //Assert.assertEquals(createdBoardName.toLowerCase(), boardName.toLowerCase());
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
