package ru.stq.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().contacts().size() == 0) {
      app.goTo().gotoContactsPage();
      app.contact().createContact(new ContactData().withContactName("Asya").
              withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
    }
  }

  @Test(enabled = true)
    public void testContactDeletion() {
      Contacts before = app.db().contacts();
      ContactData deletedContact = before.iterator().next();
      app.goTo().gotoContactsPage();
      app.contact().delete(deletedContact);
      assertThat(app.contact().count(), equalTo(before.size() - 1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.without(deletedContact)));
    }


}
