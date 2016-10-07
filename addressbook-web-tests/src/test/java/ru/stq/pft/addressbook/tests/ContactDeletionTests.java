package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{


    @Test
    public void testContactDeletion() {
      app.getNavigationHelper().gotoContactsPage();
      if (! app.getContactHelper().isThereAGroup()) {
        app.getContactHelper().createContact(new ContactData("Asya", "Kasimova", "test1", null, "+7 945 111 11 11", "asya.kasimova@a.com"), true);
      }
      int before = app.getContactHelper().getContactCount();
      app.getContactHelper().selectContacts(before - 1);
      app.getContactHelper().deleteSelectedContacts();
      app.getContactHelper().acceptDeletionContacts();
      app.getContactHelper().returnToHomePage();
      int after = app.getContactHelper().getContactCount();
      Assert.assertEquals(after, before - 1);
    }

}
