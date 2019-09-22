package com.trello.qa.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase{

@Test//(enabled = false)
public void testRenameBoard() throws InterruptedException {
    app.getBoardHelper().clickOnBoardButton();
    app.getBoardHelper().clickOnFirstBoard();
    String boardName1 = "MMM";
    app.getBoardHelper().fillBoardNameForm(boardName1);
    Thread.sleep(5000);
    app.getBoardHelper().returnToHomePage();

}
}
