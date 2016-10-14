package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{


    @Test(enabled = true)
    public void testContactDeletion() {
      app.goTo().gotoContactsPage();
      if (! app.contact().isThereAGroup()) {
        app.contact().createContact(new ContactData().withContactName("Asya").
                withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
      }
      Contacts before = app.contact().getContactAll();
      ContactData deletedContact = before.iterator().next();
      app.contact().delete(deletedContact);
      Contacts after = app.contact().getContactAll();
      Assert.assertEquals(after.size(), before.size() - 1);

      assertThat(after, equalTo(before.without(deletedContact)));
    }


}
