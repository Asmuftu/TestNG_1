package tests.day_17testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void aramaTesti(){
        extentTest = extentReports.createTest("Arama Testi","Kullanici belirlenen kelimeyi aratip dogru arama yapildigini test eder");

        // testotomasyonu ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("kullanici test otomasyonu anasayfaya gider");

        // belirlenen arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);
        extentTest.info("belirlenen arama kelimesi icin arama yapar");

        // arama sonucunda urun bulunabildigini test edin
        int aramaSonucSayisi = testOtomasyonuPage.bulunanUrunElementleriList.size();
        Assert.assertTrue(aramaSonucSayisi>0);
        extentTest.pass("arama sonucunda urun bulunabildigini test eder");

        // ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("ilk urune click yapar");

        // acilan urun sayfasinda urun isminin
        // case sensitive olmadan belirlenen arama kelimesini icerdigini test edin
        String actualUrunIsmiKucukHarf = testOtomasyonuPage.urunSayfasindakiurunIsimElementi.getText().toLowerCase();
        Assert.assertTrue(actualUrunIsmiKucukHarf.contains(ConfigReader.getProperty("toAranacakKelime")));
        extentTest.pass("acilan urun sayfasinda urun isminin\ncase sensitive olmadan belirlenen arama kelimesini icerdigini test eder");


        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");
    }
}
