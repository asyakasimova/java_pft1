package ru.stq.pft.addressbook.generators;

import org.openqa.selenium.remote.BrowserType;
import ru.stq.pft.addressbook.appmanager.ApplicationManager;
import ru.stq.pft.addressbook.model.ContactData;
import ru.stq.pft.addressbook.model.Groups;
import ru.stq.pft.addressbook.tests.TestBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.Kasimova on 30.10.2016.
 */
public class ContactDataGeneratorNew extends TestBase{

  public static void main(String[] args) throws IOException {

    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);
//    Groups groups = app.db().groups();
    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);

  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact:contacts) {
      writer.write(String.format("%s;%s;%s;%s;%s;\n",
              contact.getContactName(), contact.getContactSecondName(), contact.getContactAddress(), contact.getContactHomePhone(),
              contact.getContactEmail()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();

    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withContactName(String.format("Asya%s", i)).withContactSecondName(String.format("Rfs%s", i)).withContactAddress(String.format("address %s", i))
              .withContactHomePhone(String.format("(123)%s", i))
              .withContactEmail(String.format("email%s@email.com", i)));
      // .inGroup(groups.iterator().next())
    }
    return contacts;
  }


}
