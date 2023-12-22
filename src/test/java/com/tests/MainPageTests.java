package com.tests;

import com.pages.ADVBankAccountPage;
import com.pages.AccountOverviewPage;
import com.pages.MainPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTests extends TestBase {

    @Test
    @Owner("Team Andy&Co")
    @Description("Получение информации об открытии первой страницы")
    public void mainPageTest() {
        assertEquals("Online Banking Simulator",
                new MainPage(context)
                        .mainPageText());
    }

    @Test
    @Owner("Team Andy&Co")
    @Description ("Проверка информации о главном меню")
    public void numberOfMainMenu(){
        assertEquals(7,
                new MainPage(context)
                .numberMainMenu());
    }

    @Test
    @Owner("Team Andy&Co")
    @Description("Проверка страницы Account и пользователя")
    public void AccountPageTest(){
       new MainPage(context)
               .toAccountPage();
       assertEquals("Bank of America Preferred Client",
         new AccountOverviewPage(context)
           .getPageHeader());
       assertEquals("Robin Smith",
         new AccountOverviewPage(context)
           .getUserNameText());
    }

    @Test
    @Owner("Team Andy&Co")
    @Description("Провеока информации о количеств счетов пользователя")
    public void scoreOfProduct() {
        new MainPage(context)
                .toAccountPage();
        assertEquals(
                4,
                new AccountOverviewPage(context)
                        .getUserAccountsNumber()
        );
    }

    @Test
    @Owner("Team Andy&Co")
    @Description("Проверка наличия текущего счета")
    public void ADVBankAccountPageTest(){
        new MainPage(context)
            .toAccountPage()
            .closePopup()
            .toADVBankAccount();
        assertEquals("Available Balance (as of today):",
                new ADVBankAccountPage(context)
                        .getAvailableBalanceText()
                );
    }
    @Test
    @Owner("Team Andy&Co")
    @Description("Проверка количества платежей по текущему счету")

    public void numberPayment(){
        new MainPage(context)
                .toAccountPage()
                .closePopup()
                .toADVBankAccount();
        assertEquals(5,
                new ADVBankAccountPage(context)
                        .getNumberPayment()
        );
    }
}
