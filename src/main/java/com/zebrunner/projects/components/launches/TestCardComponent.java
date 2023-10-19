package com.zebrunner.projects.components.launches;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.projects.enums.launches.LaunchesCardOptionsEnum;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCardComponent extends AbstractUIObject {

    private static final String MAIN_LOCATOR = "(//div[@class='test-details__table-col'])";

    @FindBy(xpath = MAIN_LOCATOR)
    private ExtendedWebElement launchesCard;

    @FindBy(xpath = MAIN_LOCATOR+"//div[@aria-label='More options']")
    private ExtendedWebElement moreOptionsButton;

    @FindBy(xpath = "//li[@role='menuitem' and contains(text(), '%s')]")
    private ExtendedWebElement copyUrlBtn;

    public TestCardComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }



    public void clickMoreOptionBtn(){
        moreOptionsButton.hover();
        moreOptionsButton.click();
    }

    public void clickCopyURLBtn(LaunchesCardOptionsEnum launchesOptionsEnum){
        clickMoreOptionBtn();
        copyUrlBtn.format(launchesOptionsEnum.getTitle()).click();
    }

    public void clickLaunchesCard(){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(launchesCard.getBy()));
        launchesCard.click();
    }

}
