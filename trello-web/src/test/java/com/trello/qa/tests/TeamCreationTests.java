package com.trello.qa.tests;

import com.trello.qa.manager.TeamData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTests extends TestBase {
    @DataProvider
    public Iterator<Object[]>validTeams(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name","description"});
        list.add(new Object[]{"NAME","DESC"});
        list.add(new Object[]{"1234","456789"});
        list.add(new Object[]{"&^#$","*&^%"});
        list.add(new Object[]{"name"," "});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>validTeamsfromcsv() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Team.csv")));
       String line = reader.readLine();
       while(line != null){
           String[] split = line.split(",");
           list.add(new Object[]{new TeamData().withTeamName(split[0]).withDescription(split[1])});
           line = reader.readLine();
       }

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
            app.getTeamHelper().returnToHomePage();
        }
    }

    @Test(enabled = false)
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        String teamName = "qa21";
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("h").withDescription("g"));
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        Thread.sleep(7000);
        app.getTeamHelper().click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));
        app.getTeamHelper().goHomePage();
        //app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());
    }

    @Test(dataProvider = "validTeamsfromcsv")
    public void testTeamCreationFromPlusButtonOnHeaderWithDataProviderFromcsv (TeamData team) throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        //String teamName = "qa21";
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        //String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));
        app.getTeamHelper().goHomePage();
        //app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before+1);
        //Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());
    }

    @Test(dataProvider = "validTeams")
    public void testTeamCreationFromPlusButtonOnHeaderWithDataProvider (String teamName, String description) throws InterruptedException {
        TeamData team = new TeamData().withTeamName(teamName).withDescription(description);
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnHeader();
        app.getTeamHelper().selectCreateTeamFromDropDown();
        //String teamName = "qa21";
        app.getTeamHelper().fillTeamCreationForm(team);
        app.getTeamHelper().clickContinueButton();
        //String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        //app.getTeamHelper().returnToHomePage();
        app.getTeamHelper().click(By.xpath("//a[@class='eg0KI5SqghoOFd']"));
        app.getTeamHelper().goHomePage();
        int after = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(after, before+1);
        //Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());
    }

    @Test(enabled = false)
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = app.getTeamHelper().getTeamsCount();
        app.getTeamHelper().clickOnPlusButtonOnLeftNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new TeamData().withTeamName("qa21").withDescription("descr qa 21"));
        app.getTeamHelper().clickContinueButton();
        String createdTeamName = app.getTeamHelper().getTeamNameFromTeamPage();
        app.getTeamHelper().returnToHomePage();
        int after = app.getTeamHelper().getTeamsCount();

        Assert.assertEquals(after, before+1);
        Assert.assertEquals(createdTeamName, "qa21");
    }

    @Test(enabled = false)
    public void testTeamCreation(){
        Assert.assertTrue(app.getSessionHelper().isUserLoggedIn());
    }
}
