package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    protected String getTeamNameFromTeamPage() {

        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void clickContinueButton() {

        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDown() {

        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public int getTeamsCount() {
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickOnPlusButtonOnLeftNavMenu() {
        waitForElementAndClick(By.xpath("//*[@name='add']"),15);
    }

    public void deleteTeam() {
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".quiet-button")));
        click(By.cssSelector(".quiet-button"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openSettings() {
        click(By.cssSelector(".icon-gear.icon-sm.OiX3P2i2J92Xat"));
    }

    public void clickOnFirstTeam() {
        click(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li"));
    }

}
