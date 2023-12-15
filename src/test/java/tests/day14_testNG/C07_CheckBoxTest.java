package tests.day14_testNG;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_CheckBoxTest {

    @Test
    public void test01(){
        //a. Verilen web sayfasına gidin.
        //          https://www.testotomasyonu.com/form
        Driver.getDriver().get("https://www.testotomasyonu.com/form");

        // b. Sirt Agrisi ve Carpinti checkbox’larini secin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        TestOtomasyonuFormPage testOtomasyonuFormPage = new TestOtomasyonuFormPage();
        testOtomasyonuFormPage.carpintiCheckboxKutusu.click();
        testOtomasyonuFormPage.sirtAgrisiCheckBoxKutusu.click();

        // c. Sirt Agrisi ve Carpinti checkbox’larininin seçili olduğunu test edin
        Assert.assertTrue(testOtomasyonuFormPage.carpintiCheckboxKutusu.isSelected());
        Assert.assertTrue(testOtomasyonuFormPage.sirtAgrisiCheckBoxKutusu.isSelected());

        // d. Seker ve Epilepsi checkbox’larininin seçili olmadigini test edin

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertFalse(testOtomasyonuFormPage.sekerCheckBoxKutusu.isSelected());
        Assert.assertFalse(testOtomasyonuFormPage.epilepsiCheckBoxKutusu.isSelected());

        ReusableMethods.bekle(4);
        Driver.quitDriver();
    }
}
