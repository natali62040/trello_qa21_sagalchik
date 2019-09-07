package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

    @Test
    public void testBoardCreation(){
        Assert.assertFalse(isUserLoggedOut());
        click(By.xpath("//*[@name='add']"));
        click(By.xpath("//*[contains(text(),'Create Board')]"));
        type(By.xpath("//*[@placeholder='Add board title']"),"My plans2");
        click(By.xpath("//*[@class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']"));
    }

    public boolean isUserLoggedOut() {
        return isElementPresent(By.cssSelector("[href=\"/login\"]"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;

    }
}
