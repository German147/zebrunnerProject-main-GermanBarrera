package com.zebrunner.projects.components.launches;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.projects.enums.launches.LaunchesReportHeaderOptionsEnum;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaunchReportPageHeaderComponent extends AbstractUIObject {
    @FindBy(xpath = "//div[@class='launch-page-header__actions']")
    private ExtendedWebElement launchHeader;

    @FindBy(xpath = "//div[@aria-label='Share']")
    private ExtendedWebElement shareBtn;

    @FindBy(xpath = "//div[@class='test-run-share-modal']")
    private ExtendedWebElement testRunShareModal;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation button md-blue _left-icon _small info-light  css-1pblrdc']")
    private ExtendedWebElement copyLinkBtn;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-disableElevation button icon info-dark  css-1obwva5']")
    private ExtendedWebElement moreOptionsBtn;

    @FindBy(xpath = "//span[@class='dropdown__item-title' and contains(text(), '%s')]")
    private ExtendedWebElement exportToHTMLbtn;

    public LaunchReportPageHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private void clickShareBtn(){
        shareBtn.hover();
        shareBtn.click();
    }

    public void clickCopyLinkBtn(){
        clickShareBtn();
        if(isShareModalPresent()){
            copyLinkBtn.click();
        }else {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(e-> copyLinkBtn.isClickable());
        }
    }

    private boolean isShareModalPresent(){
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));
        return wait.until(e->isAnyElementPresent(testRunShareModal));
    }


    private void clickMoreOptionsBtn(){
        moreOptionsBtn.hover();
        moreOptionsBtn.click();
    }

    public void clickExportToHTML(LaunchesReportHeaderOptionsEnum launchesReportHeaderOptionsEnum){
        clickMoreOptionsBtn();
        exportToHTMLbtn.format(launchesReportHeaderOptionsEnum.getTitle()).click();
    }

}
