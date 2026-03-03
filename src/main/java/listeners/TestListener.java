package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Test Failed! Taking Screenshot...");

        ScreenshotUtil.captureScreenshot(result.getName());
    }
}