package ru.stq.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by A.Kasimova on 18.10.2016.
 */
public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().gotoContactsPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getContactHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactHomePhone())));
    assertThat(contact.getContactMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactMobilePhone())));
    assertThat(contact.getContactWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getContactWorkPhone())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("-()", "");
  }
}
