package com.zebrunner.projects.components.launches;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LauncherTableComponent extends AbstractUIObject {

    private static final String MAIN_LOCATOR = "//div[@class='launch-card ']";

    @FindBy(xpath = MAIN_LOCATOR+"[%s]")
    private ExtendedWebElement selectLaunchCard;

    public LauncherTableComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverLaunchCard(Integer index){
        selectLaunchCard.format(index).hover();
    }

    public void clickLaunchCard(Integer index){
        selectLaunchCard.format(index).click();
    }

}
