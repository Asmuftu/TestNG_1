package tests.day16_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.annotation.Tainted;
import java.util.List;

public class C02_SoftAssertion {

    @Test
    public void softAssertionTesti(){

        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

        // 2. webbappsecurity ana sayfaya gittiginizi dogrulayin
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Anasayfada degiliz");

        // 3. Sign in butonuna basin
        ZeroPage zeroPage = new ZeroPage();
        zeroPage.signinLinki.click();

        // 4. Login kutusuna “username” yazin
        zeroPage.usernameKutusu.sendKeys("username");

        // 5. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");

        // 6. Sign in tusuna basin
        zeroPage.signInButonu.click();

        // 7. Back tusuna basin
        Driver.getDriver().navigate().back();

        // 8. Giris yapilabildiginizi dogrulayin
        softAssert.assertTrue(zeroPage.onlineBankingLinki.isDisplayed(),"Giris yapilamadi");

        // 9. Online banking menusunu tiklayin
        zeroPage.onlineBankingLinki.click();

        // 10. Pay Bills sayfasina gidin
        zeroPage.paybillsLinki.click();

        // 11. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseForeignCurrencyLinki.click();

        // 12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
        softAssert.assertTrue(zeroPage.pcCurrencyDropdownElementi.isEnabled(),"Currency dropdown kullanilamiyor");

        // 13. “Currency” dropdown menusunden Eurozone’u secin
        Select select = new Select(zeroPage.pcCurrencyDropdownElementi);
        select.selectByValue("EUR");

        // 14. “Eurozone (euro)” secildigini dogrulayin
        String expectedOption = "Eurozone (euro)";
        String actualSeciliOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSeciliOption,expectedOption,"EuroZone secilmedi");

        // 15. Dropdown menude 16 option bulundugunu dogrulayin.
        int expectedDropdownSize = 16;
        int actualDropdownSize = select.getOptions().size();
        softAssert.assertEquals(actualDropdownSize,expectedDropdownSize,"Dropdown beklenen boyutta degil");

        // 16. Dropdown menude “Canada (dollar)” bulunduğunu dogrulayin
        List<WebElement> dropdownElementleriList = select.getOptions();
        List<String> dropdownYazilariList = ReusableMethods.stringListeDonustur(dropdownElementleriList);
        softAssert.assertTrue(dropdownYazilariList.contains("Canada (dollar)"),"Dropdown'da Canada dolari yok");


        // 17. Sayfayi kapatin
        softAssert.assertAll();
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
