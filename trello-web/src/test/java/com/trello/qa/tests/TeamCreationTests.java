package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditions(){
        if(!app.getSessionHelper().isUserLoggedIn()){
            app.getSessionHelper().login("natalisagalchik@gmail.com", "Sn271206");
        }
    }

    @BeforeMethod
    public void isOnHomePage(){
        if(! app.getBoardHelper().isTherePersonalBoards()){
            app.getTeamHelper().returnToHomePage();
        }
    }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName = "qa21";
        app.getTeamHelper().fillTeamCreationForm(teamName, "descr qa21");
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());
    }

    @Test(enabled = false)
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm("h","g");
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdTeamName, "h");

    }

    @Test(enabled = false)
    public void testTeamCreation(){
        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());

    }
}
