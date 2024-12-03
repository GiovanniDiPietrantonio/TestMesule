package org.aesys.test.mesule.utilities;

import io.appium.java_client.android.AndroidDriver;
import org.aesys.test.mesule.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Utility extends Config {

    private static FluentWait<AndroidDriver> createWait(AndroidDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);
    }

    public static void clickElement(By by) {
        FluentWait<AndroidDriver> wait = createWait(_androidDriver);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    /* TEST FOR QR CODE
    public void asd() {
        File screenshot = _androidDriver.getScreenshotAs(OutputType.FILE);
        String content = decodeQRCode(generateImage(qrCodeElement, screenshot));
        System.out.println("content = " + content);
    }

    private static String decodeQRCode(BufferedImage qrCodeImage) throws NotFoundException {
        LuminanceSource source = new BufferedImageLuminanceSource(qrCodeImage);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        Result result = new MultiFormatReader().decode(bitmap);
        return result.getText();
    }

    private BufferedImage generateImage(WebElement element, File screenshot) throws IOException {
        BufferedImage fullImage = ImageIO.read(screenshot);
        var imageLocation = element.getLocation();
        int qrCodeImageWidth = element.getSize().getWidth();
        int qrCodeImageHeight = element.getSize().getHeight();
        int pointXPosition = imageLocation.getX();
        int pointYPosition = imageLocation.getY();
        BufferedImage qrCodeImage = fullImage.getSubimage(pointXPosition, pointYPosition, qrCodeImageWidth, qrCodeImageHeight);
        ImageIO.write(qrCodeImage, "png", screenshot);
        return qrCodeImage;
    }

     */
}
