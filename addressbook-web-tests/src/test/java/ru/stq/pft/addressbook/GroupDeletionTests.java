package ru.stq.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

  @Test
  public void testGroupDeletion() {

    app.gotoGroupsPage();
    app.selectGroup();
    app.deleteSelectedGroup();
    app.returnToGroupPage();
  }

}
