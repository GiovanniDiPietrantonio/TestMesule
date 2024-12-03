package mobile;

import org.aesys.test.mesule.config.Config;
import org.aesys.test.mesule.utilities.Utility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class TestMesuleApp {
    @BeforeEach
    public void setUp() {
        Config.setupAndroid();
    }

    @Test
    public void testOpenCamera() {
        Utility.clickElement(By.xpath("//android.view.View[@content-desc=\"Scan a product\"]"));
    }

    @Test
    public void testSignIn() {
        Utility.clickElement(By.xpath("//android.widget.Button[@content-desc='Sign in']"));
    }

    @AfterEach
    public void tearDown() {
        //Config.tearDown();
    }
}
