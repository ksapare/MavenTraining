package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by z013th3 on 11/21/16.
 */
public class MavenPage {
    public WebDriver driver;

    By signInLink = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
    By userName = By.id("email");
    By passWord = By.id("passwd");
    By login = By.name("SubmitLogin");
    By checkText = By.xpath(".//*[@id='center_column']/h1");

    public MavenPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String strUserName) throws InterruptedException {
        WebElement elementSignIn = driver.findElement(signInLink);
        elementSignIn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement elementCheck = driver.findElement(checkText);
        WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(userName));
        myDynamicElement.click();
        myDynamicElement.sendKeys(strUserName);
        Thread.sleep(3000);



        //System.out.println(cartAccount);
        //driver.findElement(user99GuruName);
    }

    //Set password in password textbox

    public void setPassword(String strPassword){
        driver.findElement(passWord).sendKeys(strPassword);
    }

    //Click on login button

    public void clickLogin(){
        driver.findElement(login).click();
    }

    //Get the title of Login Page

    /*public String getLoginTitle(){
        return    driver.findElement(titleText).getText();
    }
*/
    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginToApp(String strUserName,String strPasword) throws InterruptedException {

        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
    }

}
