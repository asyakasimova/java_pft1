package ru.stq.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

/**
 * Created by A.Kasimova on 20.10.2016.
 */
public class ContactAddressTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoContactsPage();
    if (! app.contact().isThereAGroup()) {
      app.contact().createContact(new ContactData().withContactName("Asya").
              withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
    }
  }

  @Test
  public void testContactAddress(){
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    MatcherAssert.assertThat(cleaned(contact.getContactAddress()), CoreMatchers.equalTo(cleaned(contactInfoFromEditForm.getContactAddress())));


  }

  public static String cleaned(String email){
    return email.replaceAll("\\n", " ").replaceAll("\\s+", " ");
  }


}
