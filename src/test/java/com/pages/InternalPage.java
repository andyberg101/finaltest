package com.pages;

import com.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InternalPage extends BasePage{
    @FindBy(xpath = "//footer/p[2]")
    public WebElement footer;

    @FindBy(css = "#welcomeNavHeading")
    public WebElement mainMenuLink;
    @FindBy(xpath = "//li[@class='list-group-item'][2]")
    public WebElement accountOverviewLink;

    @FindBy(css = "ul[class = 'flex-wrap flex-row list-group']")
            public List<WebElement> mainMenu;

    public InternalPage(TestContext context) {
        super(context);
    }

    public String getFooterText() {
        return footer.getText();
    }

    public MainPage goToMainPage(String nameElementMenu) {
        for (WebElement product : mainMenu) {
            if (product.getText().equals(nameElementMenu)) {
                product.click();
                break;
            }
        }
        return new MainPage(context);
    }
    public AccountOverviewPage openAccount() {
        accountOverviewLink.click();
        return new AccountOverviewPage(context);
    }
}
