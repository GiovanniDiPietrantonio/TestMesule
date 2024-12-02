package org.aesys.test.mesule.config;

import io.appium.java_client.android.AndroidDriver;
import lombok.Getter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Config {
    @Getter
    private static AndroidDriver androidDriver;

    public static void setupAndroid() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:app", "C://Users//GiovanniDiPietranton//Downloads//mesule-debug.apk");
            capabilities.setCapability("appium:autoGrantPermissions", true); // Concede automaticamente i permessi
            // capabilities.setDeviceName("Android Emulator"); // Nome del dispositivo/emulatore
            // capabilities.setPlatformVersion("11.0"); // Se necessario, specifica la versione del sistema operativo
            // Creazione del driver Android
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            System.out.println("App avviata con successo!");
        } catch (MalformedURLException e) {
            System.err.println("Errore nell'URL del server Appium: " + e.getMessage());
        }
    }

    public static void tearDown() {
        if (androidDriver != null) {
            androidDriver.quit();
            System.out.println("Sessione chiusa.");
        }
    }

}