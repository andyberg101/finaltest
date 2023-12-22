package com.pages;

import com.context.TestContext;
import com.pages.InternalPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayAndTransfersPage extends InternalPage {

    public PayAndTransfersPage (TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//div[@class='activity-option card']")
    public List<WebElement> payAndTransfersMenu;


    public int getPayAndTransferMenu(){
        return  payAndTransfersMenu.size();
    }
}
