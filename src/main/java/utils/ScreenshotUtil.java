package utils;

import base.CrossBrowser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void captureScreenshot(String testName) {

        try {

            File source = ((TakesScreenshot)
                    CrossBrowser.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String path = System.getProperty("user.dir")
                    + "/reports/";

            File folder = new File(path);
            if (!folder.exists()) {
                folder.mkdir();
            }

            File destination = new File(path
                    + testName + "_" + timestamp + ".png");

            FileHandler.copy(source, destination);

            System.out.println("Screenshot saved at: "
                    + destination.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}