package ru.stq.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;

/**
 * Created by A.Kasimova on 31.10.2016.
 */
public class RegistrationHelper {
  private final ApplicationManager app;
  private WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
    this.app = app;
    wd = app.getDriver();
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");

  }
}
