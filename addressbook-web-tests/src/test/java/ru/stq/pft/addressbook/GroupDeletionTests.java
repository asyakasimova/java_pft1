package ru.stq.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTests extends TestBase{

  @Test
  public void testGroupDeletion() {

    gotoGroupsPage();
    selectGroup();
    deleteSelectedGroup();
    returnToGroupPage();
  }

}
