package tests.day15_configuration_Driver_Kullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_negatifLoginTesti {

    //1- https://www.testotomasyonu.com/ anasayfasina gidin
    //2- login linkine basin
    // 3- 3 farkli test method'u olusturun.
    // - gecerli username, gecersiz password
    // - gecersiz username, gecerli password
    // - gecersiz username, gecersiz password.
    //4- Login butonuna basarak login olun
    //5- Basarili olarak giris yapilamadigini test edin

    @Test
    public void gecersizPasswordTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        testOtomasyonuPage.loginButonu.click();
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
    @Test
    public void gecersizUsernameTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
        testOtomasyonuPage.loginButonu.click();
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
    @Test
    public void gecersizUsernameVePasswordTesti(){

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki.click();
        testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
        testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
        testOtomasyonuPage.loginButonu.click();
        Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
        ReusableMethods.bekle(2);
        Driver.quitDriver();
    }
}
