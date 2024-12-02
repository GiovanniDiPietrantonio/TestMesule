package mobile;

import org.aesys.test.mesule.config.Config;
import org.aesys.test.mesule.utilities.Utility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FirstTest {

    @BeforeEach
    public void setUp() {
       Config.setupAndroid();
    }

    @Test
    public void testInteraction() {
        var androidDriver = Config.getAndroidDriver();

        // Usa i metodi di utilità per interagire con gli elementi
        Utility.clickElement(androidDriver, By.xpath("//android.view.View[@content-desc='Scan a product']"));
        System.out.println("Scan button clicked!");

        Utility.clickElement(androidDriver, By.xpath("//android.widget.Button[@content-desc='Back']"));
        System.out.println("Go back button clicked!");

        Utility.clickElement(androidDriver, By.xpath("//android.widget.Button[@content-desc='Sign in']"));
        System.out.println("Sign in button clicked!");
    }

    @AfterEach
    public void tearDown() {
        //Config.tearDown();
    }
}
