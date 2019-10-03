package com.trello.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        if(!app.getTeamHelper().isTeamsPresent()){
            app.getTeamHelper().createTeam();
        }
    }

    @Test(enabled = false)
    public  void testRenameTeam() throws InterruptedException {
        app.getTeamHelper().clickOnFirstTeam();
        app.getTeamHelper().openSettings();
        app.getTeamHelper().initEditTeamProfile();
        app.getTeamHelper().changeTeamProfile("hh","hha");
        app.getTeamHelper().confirmEditTeam();
        Thread.sleep(5000);
        //app.getTeamHelper().returnToHomePage();
        app.getTeamHelper().goHomePage();

        Assert.assertEquals(app.getTeamHelper().getTeamNameFromTeamPage(),"hh");
    }
}
