package utils;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private String username;

    public void takeScreenshot(WebDriver driver) throws IOException {

        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time = new SimpleDateFormat("dd-MM-yy-hh-mm-ss-aa").format(new Date());
        String filePath = "./src/test/resources/screenshot/" + time + ".png";
        File destFile = new File(filePath);
        FileUtils.copyFile(screenShotFile , destFile);
    }

//    public int generateRandomNumber(int min , int max){
//        int randomNum = (int) Math.floor(Math.random() * (min - max + max));
//        System.out.println(randomNum);
//        return randomNum;
//    }

    public String generateRandomData(){
        Faker faker = new Faker();
        String username = faker.name().username();
        System.out.println(username);
        return username;
    }

    public void writeUserInfo(String username) throws IOException, ParseException {

        String filePath = "./src/test/resources/users.json";

        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(filePath));
        JSONObject userObject = new JSONObject();

        userObject.put("username" , username);

        JSONArray userArray = (JSONArray)object;
        userArray.add(userObject);

        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(userArray.toJSONString());
        fileWriter.flush();
        fileWriter.close();
    }
}
