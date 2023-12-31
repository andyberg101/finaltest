package com.pages;
import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ADVBankAccountPage extends InternalPage {

    public ADVBankAccountPage(TestContext context) {
        super(context);
    }
    @FindBy(xpath = "//span[text()=\"Available Balance (as of today):\"]")
    public WebElement availableBalanceText;

    @FindBy(xpath = "//tr[@class='collapsed']")
    public List<WebElement> numberPayment;

    @FindBy(xpath = "//span[text()='Pay & Transfer']")
    public WebElement payTranferLink;

    @FindBy(xpath = "//h1[text()='Pay & Transfer']")
    public WebElement payTransferButton;

    public String getAvailableBalanceText() {
        return availableBalanceText.getText();
    }

    public int getNumberPayment(){
        return  numberPayment.size();
    }
    public String toPayTransferPage(){
        payTranferLink.click();
        return payTranferLink.getText();
    }
}
