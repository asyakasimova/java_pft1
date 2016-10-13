package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{


    @Test(enabled = true)
    public void testContactDeletion() {
      app.goTo().gotoContactsPage();
      if (! app.getContactHelper().isThereAGroup()) {
        app.getContactHelper().createContact(new ContactData().withContactName("Asya").
                withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContacts(before.size() - 1);
      app.getContactHelper().deleteSelectedContacts();
      app.getContactHelper().acceptDeletionContacts();
      app.getContactHelper().returnToHomePage();
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(after, before);
    }
}
