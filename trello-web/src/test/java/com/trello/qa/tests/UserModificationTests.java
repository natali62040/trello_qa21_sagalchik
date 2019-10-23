package com.trello.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UserModificationTests extends TestBase {

    //@BeforeMethod

    @Test
    public void changeAvatarTest() throws InterruptedException {
    app.getUserHelper().clickOnAvatar();
    app.getUserHelper().openProfileFromDropDown();
    app.getUserHelper().initAvatarChanging();
    app.getUserHelper().addPicture();
    }
}
