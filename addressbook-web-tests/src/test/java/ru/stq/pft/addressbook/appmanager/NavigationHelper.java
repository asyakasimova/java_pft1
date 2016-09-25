package ru.stq.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class NavigationHelper extends HelperBase{


  public NavigationHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void gotoGroupsPage() {
    click(By.linkText("groups"));
  }

  public void gotoCreateContactPage() {
      click(By.linkText("add new"));
  }

  public void gotoContactsPage() {
    click(By.linkText("home"));
  }
}
