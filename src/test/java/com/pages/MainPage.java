package com.pages;

import com.context.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MainPage extends InternalPage {
    @FindBy(css = "li[class='list-group-item']")
    public List<WebElement> allElementsMenu;

    @FindBy(xpath = "//li[@class='list-group-item'][2]")
    public WebElement product;

    @FindBy(css = "span[class='close-btn1 close-btn2']")
    public WebElement welcome;

    @FindBy(xpath = "//h1[@class='welcome-obsim-text']")
    public WebElement mainPage;

    public MainPage(TestContext context) {
        super(context);
    }

    public String mainPageText() {
        return mainPage.getText();
    }
    public int numberMainMenu(){
        return  allElementsMenu.size();
    }

    public AccountOverviewPage toAccountPage() {
        product.click();
        return new AccountOverviewPage(context);
    }


}


