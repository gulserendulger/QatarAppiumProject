package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest{

    @Step("<time> saniye bekle")
    public void waitForsecond(int time) throws InterruptedException {
        Thread.sleep(time*1000);
    }
    @Step("<id> İd'li elementi bul ve tıkla")
    public void clickByid(String id){
        appiumDriver.findElement(By.id(id)).click();
        System.out.println("Element tıklandı.");
    }

    @Step("<xpath> Xpath'li elementi bul ve tıkla")
    public void clickByxpath(String xpath){
        appiumDriver.findElement(By.xpath(xpath)).click();
        System.out.println("Element tıklandı.");
    }
    @Step("<id> İd'li elementi bul ve <text> değerini yaz")
    public void sendKeysByid(String id,String text){
        appiumDriver.findElement(By.id(id)).sendKeys(text);
        System.out.println(text +"değeri yazıldı");
    }
    @Step("<xpath> Xpath'li elementi bul ve <text> değerini yaz")
    public void sendKeysByxpath(String xpath,String text){
        appiumDriver.findElement(By.xpath(xpath)).sendKeys(text);
        System.out.println(text +"değeri yazıldı");
    }
    @Step("<id> İd'li element <text> değerini içeriyor mu kontrol et")
    public void ControltoElementByid(String id,String text){
        MobileElement element = appiumDriver.findElement(By.id(id));
        System.out.println("Alınan elementın text değeri " + element.getText());
        Assert.assertTrue("Verilen text değeri ile alınan text değeri eşit değil",element.getText().equals(text));
    }
    @Step("<xpath> Xpath'li elementler arasında rasgele bir tanesine tıkla")
    public void clickByrandomElement(String xpath){
        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));
        System.out.println("Total elements : " + elements.size());
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        System.out.println("index====" + index);
        elements.get(index).click();
    }

}
