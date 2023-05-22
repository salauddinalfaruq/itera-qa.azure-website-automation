package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public void takeScreenshot(WebDriver driver) throws IOException {

        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yy-hh-mm-ss-aa").format(new Date());
        String filePath = "./src/test/resources/screenshot/" + time + ".png";
        File destFile = new File(filePath);
        FileUtils.copyFile(screenShotFile , destFile);
    }
}
