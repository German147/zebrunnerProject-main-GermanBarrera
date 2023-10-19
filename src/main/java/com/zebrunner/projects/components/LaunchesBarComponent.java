package com.zebrunner.projects.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.projects.enums.FiltersEnum;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LaunchesBarComponent extends AbstractUIObject {

    private static final String MAIN_LOCATOR = "//div[@class='launches-filter__control-wrapper']";
    @FindBy(xpath = MAIN_LOCATOR + "//button[.//span[text()='Launcher']]")
    private ExtendedWebElement launcherButton;

    @FindBy(xpath = MAIN_LOCATOR + "//input[contains(@class, 'MuiInputBase-input') and @placeholder='Search launches']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = MAIN_LOCATOR + "//div[contains(@class, 'multiselect-dropdown-placeholder')][contains(text(), 'Status')]")
    private ExtendedWebElement statusButton;

    @FindBy(xpath = MAIN_LOCATOR + "//div[contains(@class, 'multiselect-dropdown-placeholder')][contains(text(), 'Platform')]")
    private ExtendedWebElement platformButton;

    @FindBy(xpath = MAIN_LOCATOR + "//div[contains(@class, 'multiselect-dropdown-placeholder')][contains(text(), 'Browser')]")
    private ExtendedWebElement browserButton;

    @FindBy(xpath = "//div[contains(@class, 'MuiListItemText-root')]/span[contains(@class, 'MuiTypography-body1') and text()='%s']")
    private ExtendedWebElement selectedFilter;

    public void clickStatus() {
        statusButton.click();
    }

    public void clickPlatform() {
        platformButton.click();
    }

    public void clickBrowser() {
        browserButton.click();
    }

    public void clickOption(FiltersEnum statusFilterEnum) {
        selectedFilter.format(statusFilterEnum.getName()).click();
    }

    public LaunchesBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
