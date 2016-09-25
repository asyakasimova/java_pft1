package ru.stq.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.GroupData;

/**
 * Created by A.Kasimova on 25.09.2016.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}