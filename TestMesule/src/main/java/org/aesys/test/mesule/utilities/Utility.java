package org.aesys.test.mesule.utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Utility {

    private static FluentWait<AndroidDriver> createWait(AndroidDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Tempo massimo di attesa
                .pollingEvery(Duration.ofMillis(500)) // Intervallo di polling
                .ignoring(Exception.class); // Ignora eccezioni specifiche
    }

    public static void clickElement(AndroidDriver driver, By by) {
        FluentWait<AndroidDriver> wait = createWait(driver);

        WebElement element = wait.until(driver1 -> {
            WebElement el = driver1.findElement(by);
            if (el != null && el.isDisplayed()) {
                return el;
            }
            return null;
        });

        if (element != null) {
            element.click();
        } else {
            System.out.println("Elemento non trovato: " + by);
        }
    }

}
