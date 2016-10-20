package ru.stq.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stq.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import ru.lanwen.verbalregex.VerbalExpression;

/**
 * Created by A.Kasimova on 20.10.2016.
 */
public class ContactInformationTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().gotoContactsPage();
    if (! app.contact().isThereAGroup()) {
      app.contact().createContact(new ContactData().withContactName("Asya").
              withContactSecondName("Kasimova").withContactAddress("test1").withContactHomePhone("+7 945 111 11 11").withContactEmail("asya.kasimova@a.com"), true);
    }
  }

  @Test
  public void testContactInformation() {
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    String viewData = app.contact().infoFromViewForm(contact);
    viewData = viewData.replaceAll("\\s+", " ");
    
    MatcherAssert.assertThat(viewData, CoreMatchers.equalTo(editData(contactInfoFromEditForm)));
  
  }

  private String editData(ContactData contactInfoFromEditForm) {
    return Arrays.asList(contactInfoFromEditForm.getContactName(), contactInfoFromEditForm.getContactSecondName(), cleaned(contactInfoFromEditForm.getContactAddress()),
            homePhone(contactInfoFromEditForm.getContactHomePhone()), mobilePhone(contactInfoFromEditForm.getContactMobilePhone()),
            workPhone(contactInfoFromEditForm.getContactWorkPhone()), mailReworked(contactInfoFromEditForm.getContactEmail()), mailReworked(contactInfoFromEditForm.getContactEmail2()),
            mailReworked(contactInfoFromEditForm.getContactEmail3())).stream().filter((c) -> ! c.equals("null")).collect(Collectors.joining(" "));
  }

  public String cleaned(String address) {
    return address.replaceAll("\\s+", " ");
  }

  public String homePhone (String home) {
    home = "H: " + home;
    return home;
  }

  public String mobilePhone (String mobile) {
    mobile = "M: " + mobile;
    return mobile;
  }

  public String workPhone (String work) {
    work = "W: " + work;
    return work;
  }

  public String mailReworked (String mail) {
    mail = mail.replaceAll("\\s+", "");
    if (mail != null) {
      VerbalExpression re = VerbalExpression.regex().find("@").capture().anything().endCapture().build();
      String domain = re.getText(mail, 1).replaceAll("\\s+", "");
      mail = mail + " (www." + domain + ")";
    }
    return mail;
  }
}
