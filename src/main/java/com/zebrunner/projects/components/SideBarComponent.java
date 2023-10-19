package com.zebrunner.projects.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.projects.enums.MenuItemsEnum;
import com.zebrunner.projects.enums.MenuItemsOptionsEnum;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SideBarComponent extends AbstractUIObject {
    private static final String MAIN_LOCATOR= "(//div[@class='sidebar-wrapper']";
    @FindBy(xpath = MAIN_LOCATOR+"//img)")
    private ExtendedWebElement projectImage;
    @FindBy(xpath = MAIN_LOCATOR+"//div[@class='sidebar-project__shortname'])")
    private ExtendedWebElement projectName;
    @FindBy(xpath = MAIN_LOCATOR+"//nav//a)[%s]")
    private ExtendedWebElement menuItems;
    @FindBy(xpath = "//div[@class='app-menu-sub-item-wrapper']/div[@class='sub-item__title']")
    private ExtendedWebElement menuItemOptionsTitle;
    @FindBy(xpath = "(//div[@class='app-menu-sub-item-wrapper']//span[text()='%s'])")
    private ExtendedWebElement menuItemsOptions;
    @FindBy(xpath = MAIN_LOCATOR+"//div[@class='sidebar-wrapper']//div[@class='collapse-button__icon'])")
    private ExtendedWebElement expandButton;

    public SideBarComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void hoverMenuItem(MenuItemsEnum menuItemsEnum){
        menuItems.format(menuItemsEnum.getPosition()).hover();
    }
    public void clickMenuItem(MenuItemsEnum menuItemsEnum){
        menuItems.format(menuItemsEnum.getPosition()).click();
    }
     public void clickMenuItemOption(MenuItemsOptionsEnum menuItemOption){
        hoverMenuItem(menuItemOption.getMenuItemParent());
        pause(1);
        menuItemsOptions.format(menuItemOption.getOptionName()).click();
    }
    public void clickExpandButton(){
        expandButton.click();
    }
}
