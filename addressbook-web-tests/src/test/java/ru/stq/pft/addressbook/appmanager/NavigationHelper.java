package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class NavigationHelper {

  private FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupsPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  public void gotoCreateContactPage() {
      wd.findElement(By.linkText("add new")).click();
  }
}
