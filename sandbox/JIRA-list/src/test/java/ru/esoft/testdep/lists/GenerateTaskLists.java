package ru.esoft.testdep.lists;

import com.google.gson.annotations.Expose;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class GenerateTaskLists {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//     public static void main(String[] args) throws Exception {
//       GenerateTaskLists taskLists = new GenerateTaskLists();
//       try {
//         taskLists.setUp();
//         taskLists.generateTaskLists();
//       } finally {
//         taskLists.wd.close();
//       }
//     }

  @Test
  public void generateTaskLists() throws IOException {
      login();
      goToSearchPage();
      executeSearch();
      readTasksList();
    }

  private void readTasksList() throws IOException {
    List<WebElement> elements = wd.findElements(By.tagName("tr"));
    File tasklist = new File("src/test/resources/list.txt");
    System.out.println("size " + elements.size());
    boolean header = true;
    try (Writer writer = new FileWriter(tasklist)) {
      for (WebElement element : elements) {
        try {
          String taskId = element.findElement(By.xpath("./td[2]")).getText();
          String priority = element.findElement(By.xpath("./td[6]/img")).getAttribute("alt");
          String subsystem = element.findElement(By.xpath("./td[12]")).getText();
          writer.write("Приоритет " + priority + " http://jira.e-soft.ru:8080/browse/" + taskId + " подсистема " + subsystem + "\\n");
        } catch (Exception e) {
          e.printStackTrace();
          continue;
        }
        //System.out.println("Приоритет " + priority + " http://jira.e-soft.ru:8080/browse/" + taskId + " подсистема " + subsystem + "\\n");
      }
    }
    System.out.println("out " + tasklist.getAbsolutePath());
  }

  private void goToSearchPage() {
    wd.get("http://jira.e-soft.ru:8080/issues/");
  }

  private void executeSearch() {
    wd.findElement(By.cssSelector("div.header-section-primary")).click();
    String search = wd.findElement(By.xpath("//a[contains(@class, 'switcher-item active')]")).getAttribute("data-id");
    if (search.equals("basic")) {
      wd.findElement(By.linkText("Switch to Advanced")).click();
    }
    wd.findElement(By.id("advanced-search")).click();
    wd.findElement(By.id("advanced-search")).clear();
    wd.findElement(By.id("advanced-search")).sendKeys("project = RFC AND status = Resolved ORDER BY resolution ASC");
    wd.findElement(By.cssSelector("button.aui-button.search-button")).click();
  }

  private void login() {
    wd.get("http://jira.e-soft.ru:8080/login.jsp");
    wd.findElement(By.id("login-form-username")).click();
    wd.findElement(By.id("login-form-username")).clear();
    wd.findElement(By.id("login-form-username")).sendKeys("Valky");
    wd.findElement(By.id("login-form-password")).click();
    wd.findElement(By.id("login-form-password")).clear();
    wd.findElement(By.id("login-form-password")).sendKeys("valky");
    wd.findElement(By.id("login-form-submit")).click();
  }

  @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
