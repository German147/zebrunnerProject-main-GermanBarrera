package com.zebrunner.projects.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import com.zebrunner.projects.pages.launches.LaunchesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends AbstractPage {

    @FindBy(xpath = "(//div[contains(@class,'MuiListItemIcon-root app-menu-item__icon')])[3]")
    private ExtendedWebElement rocket;

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public LaunchesPage clickOnRocketIcon() {
        LaunchesPage LaunchesPage = new LaunchesPage(getDriver());
        rocket.click();
        return LaunchesPage;
    }

}