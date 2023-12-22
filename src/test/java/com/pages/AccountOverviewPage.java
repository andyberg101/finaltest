package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccountOverviewPage extends InternalPage {
    public AccountOverviewPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//p[text()=\"Bank of America Preferred Client\"]")
    public WebElement pageHeader;

    @FindBy(xpath = "(//*[@id='root']/..//ul/li[1]/a)[1]")
    public WebElement userName;

    @FindBy(xpath = "//div[@class=\"pt-0 d-flex m-0 card-title\"]")
    public List<WebElement> accounts;

    @FindBy(xpath = "//a[text()='Adv Plus Banking']")
    public WebElement advPlusLink;

    @FindBy(xpath = "//span[@class='close-btn1 close-btn2']")
    public WebElement popupCloseButton;


    public String getPageHeader() {
        return pageHeader.getText();
    }
    public String getUserNameText() {
        return userName.getText();
    }

    public int getUserAccountsNumber() {
        return accounts.size();
    }

    public ADVBankAccountPage toADVBankAccount() {
       advPlusLink.click();
       return new ADVBankAccountPage(context);
    }

    public AccountOverviewPage closePopup(){
        popupCloseButton.click();
        return this;
    }
}




