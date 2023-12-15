package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.Driver;

public class C05_PageClassKullanimi {

    @Test
    public void aramaTesti(){

        // testotomasyonu anasayfaya gidin
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // bulunan sonuc sayisinin 1'den cok oldugunu test edin
        Assert.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>1);

        // arama sonuc sayisini yazdirin
        System.out.println(testOtomasyonuPage.sonucYaziElementi.getText());

        // sayfayi kapatin
        Driver.quitDriver();
    }
}
